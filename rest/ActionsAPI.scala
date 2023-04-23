package com.github.opengrabeso.github
package rest

import io.udash.rest._
import com.avsystem.commons.serialization._
import model._

import scala.concurrent.Future

trait ActionsAPI {

  @GET
  def runs(
    @transientDefault actor: String = null,
    @transientDefault branch: String = null,
    @transientDefault event: String = null,
    @transientDefault status: String = null,
    @transientDefault per_page: Int = 30, // maximum 100
    @transientDefault page: Int = 1,
    @transientDefault check_suite_id: Int = 0,
    @transientDefault head_sha: String = null,
  ): Future[DataWithHeaders[Runs]]
}

object ActionsAPI extends RestClientApiCompanion[EnhancedRestImplicits,ActionsAPI](EnhancedRestImplicits)
