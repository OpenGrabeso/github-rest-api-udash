package com.github.opengrabeso.github
package rest

import com.avsystem.commons.serialization.transientDefault
import model._
import io.udash.rest._

import scala.concurrent.Future

trait LabelsAPI {
  @GET("")
  def apply(ref: String): Future[Seq[Label]]

  @GET("")
  def named(@Path name: String): Future[Label]

  // https://developer.github.com/v3/issues/labels/#create-a-label
  @POST("")
  def create(
    name: String, // The name of the label. Emoji can be added to label names, using either native emoji or colon-style markup.
    color: String, // The hexadecimal color code for the label, without the leading #.
    @transientDefault description: String = null // A short description of the label.
  ): Future[Label]
}

object LabelsAPI extends RestClientApiCompanion[EnhancedRestImplicits,LabelsAPI](EnhancedRestImplicits)
