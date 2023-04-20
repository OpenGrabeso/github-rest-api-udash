package com.github.opengrabeso.github

import com.avsystem.commons.misc.Opt
import com.avsystem.commons.rpc.AsReal
import com.avsystem.commons.serialization.GenCodec
import com.github.opengrabeso.github.rest._
import sttp.client3._
import io.udash.rest.raw._
import io.udash.rest.{RestException, SttpRestClient}
import sttp.model.{Header, Method}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class RestAPIClient[TAPI: RawRest.AsRealRpc : RestMetadata](sttpBackend: SttpBackend[Future, Any], uri: String) {
  private implicit val backend = sttpBackend
  val api: TAPI = SttpRestClient.future[TAPI](uri)
  def apply(): TAPI = api

  // adapted from io.udash.rest.SttpRestClient#fromSttpResponse
  // we cannot use it directly, as it is private there
  private def fromSttpResponse(sttpResp: Response[String]): RestResponse = RestResponse(
    sttpResp.code.code,
    IMapping(sttpResp.headers.map { case Header(n, v) => (n, PlainValue(v)) }.toList),
    sttpResp.contentType.fold(HttpBody.empty) { contentType =>
      val mediaType = HttpBody.mediaTypeOf(contentType)
      HttpBody.charsetOf(contentType) match {
        case Opt(charset) =>
          // TODO: uncool that we have to go through byte array for textual body
          val text = sttpResp.body
          HttpBody.textual(text, mediaType, charset)
        case _ =>
          HttpBody.textual(sttpResp.body, contentType)
      }
    }
  )

  // many APIs return URLs which should be used to obtain more information - this can be used to have the result decoded
  def request[T](uri: String, token: String, method: Method = Method.GET, headers: Seq[(String, String)] = Seq.empty)(implicit asReal: AsReal[RestResponse, T]): Future[T] = {
    val request = quickRequest.method(method, uri"$uri").auth.bearer(token).headers(headers.map((Header.apply _).tupled):_*)
    sttpBackend.send(request).map { r =>
      val raw = fromSttpResponse(r)
      implicitly[AsReal[RestResponse, T]].asReal(raw)
    }
  }

  // used for issue paging - use the provided URL and process the result headers
  def requestWithHeaders[T: GenCodec](uri: String, token: String, headers: Seq[(String, String)] = Seq.empty): Future[DataWithHeaders[T]] = {
    val request = quickRequest.method(Method.GET, uri"$uri").auth.bearer(token).headers(headers.map((Header.apply _).tupled):_*)

    sttpBackend.send(request).map { r =>
      val raw = fromSttpResponse(r)
      import io.udash.rest.GenCodecRestImplicits._
      EnhancedRestImplicits.fromResponse[T].asReal(raw)
    }
  }
}
