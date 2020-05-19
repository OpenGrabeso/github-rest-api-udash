package com.github.opengrabeso.github
package rest

import model._
import io.udash.rest._

import scala.concurrent.Future

trait AuthorizedAPI {
  @GET
  def user: Future[User]

  def repos(owner: String, repo: String): RepositoryAPI

  def search: SearchAPI

  def notifications: NotificationsAPI

  @Prefix("")
  def markdown: MarkdownAPI

  @GET
  def rate_limit: Future[RateLimits]
}

object AuthorizedAPI extends RestClientApiCompanion[EnhancedRestImplicits,AuthorizedAPI](EnhancedRestImplicits)