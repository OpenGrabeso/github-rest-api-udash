package com.github.opengrabeso.github
package rest

import com.avsystem.commons.serialization.transientDefault

import scala.concurrent.Future
import model._
import io.udash.rest._

trait ThreadsAPI {
  @GET("")
  def get: Future[Notification]

  @PATCH("")
  def markAsRead(): Future[Unit]

  def subscription(threadId: Long): SubscriptionAPI
}

object ThreadsAPI extends RestClientApiCompanion[EnhancedRestImplicits,ThreadsAPI](EnhancedRestImplicits)
