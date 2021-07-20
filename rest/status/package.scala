package com.github.opengrabeso.github
package rest

import io.udash.rest._

import scala.concurrent.Future

// https://www.githubstatus.com/api - https://www.githubstatus.com/api/v2
package object status {

  case class StatusJson(page: Page, status: Status)

  object StatusJson extends EnhancedRestDataCompanion[StatusJson]

  case class Page(id: String, name: String, url: String, updated_at: String)

  object Page extends EnhancedRestDataCompanion[Page]

  case class Status(description: String, indicator: String)

  object Status extends EnhancedRestDataCompanion[Status]

  trait GitHubStatusAPI {
    @GET("status.json")
    def status: Future[StatusJson]
  }

  object GitHubStatusAPI extends RestClientApiCompanion[EnhancedRestImplicits,GitHubStatusAPI](EnhancedRestImplicits)
}
