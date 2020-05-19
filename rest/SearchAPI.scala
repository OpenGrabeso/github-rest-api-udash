package com.github.opengrabeso.github
package rest

import com.avsystem.commons.serialization.transientDefault
import model._
import io.udash.rest._

import scala.concurrent.Future

// https://developer.github.com/v3/search/#search-issues-and-pull-requests
trait SearchAPI {
  @GET
  def issues(
    q: String, // The query contains one or more search keywords and qualifiers - https://developer.github.com/v3/search/#constructing-a-search-query
    @transientDefault sort: String = null, // comments, reactions, ...., interactions, created, updated. Default: best match
    @transientDefault order: String = null, // desc or asc This parameter is ignored unless you provide sort. Default: desc
  ): Future[SearchResultIssues]
}

object SearchAPI extends RestClientApiCompanion[EnhancedRestImplicits,SearchAPI](EnhancedRestImplicits)
