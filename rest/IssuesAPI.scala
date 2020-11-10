package com.github.opengrabeso.github
package rest

import com.avsystem.commons.serialization.transientDefault
import java.time.ZonedDateTime

import scala.concurrent.Future
import model._
import io.udash.rest._

trait IssuesAPI {
  @GET("")
  def get: Future[Issue]

  @PATCH("")
  def update(
    @transientDefault title: String = null,
    @transientDefault body: String = null,
    @transientDefault state: String = null,
    @transientDefault milestone: Int = -1,
    @transientDefault labels: Seq[String] = null,
    @transientDefault assignees: Seq[String] = null
  ): Future[Issue]

  @GET
  def comments(
    @transientDefault since: ZonedDateTime = null,
    @transientDefault page: Int = 0,
    @transientDefault per_page: Int = 0,
  ): Future[DataWithHeaders[Seq[Comment]]]

  @GET
  def events(
    @transientDefault since: ZonedDateTime = null,
    @transientDefault page: Int = 0,
    @transientDefault per_page: Int = 0,
  ): Future[DataWithHeaders[Seq[Event]]]

  @POST("comments")
  def createComment(body: String): Future[Comment]
}

object IssuesAPI extends RestClientApiCompanion[EnhancedRestImplicits,IssuesAPI](EnhancedRestImplicits)
