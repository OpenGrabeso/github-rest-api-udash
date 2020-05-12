package com.github.opengrabeso.github
package rest

import java.time.ZonedDateTime

import io.udash.rest._
import model._

import scala.concurrent.Future

trait RestAPI {
  @Prefix("")
  def authorized(@Header("Authorization") bearer: String): AuthorizedAPI
}

object RestAPI extends RestClientApiCompanion[EnhancedRestImplicits,RestAPI](EnhancedRestImplicits)
