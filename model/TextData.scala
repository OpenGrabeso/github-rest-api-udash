package com.github.opengrabeso.github
package model

import com.avsystem.commons.rpc.AsRawReal
import io.udash.rest.raw.{HttpBody, IMapping, PlainValue, RestResponse}
import com.github.opengrabeso.github.rest.EnhancedRestDataCompanion

case class TextData(data: String)

// text encoding, needed for some parameters which require plain text (GitHub /markdown/raw)

object TextData extends EnhancedRestDataCompanion[TextData] {
  implicit val rawReal: AsRawReal[RestResponse, TextData] = AsRawReal.create(
    real => RestResponse(200, IMapping.create[PlainValue](), HttpBody.textual(real.data)),
    raw => TextData(raw.body.readText())
  )

}
