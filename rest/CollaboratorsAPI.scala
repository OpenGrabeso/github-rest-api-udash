package com.github.opengrabeso.github
package rest

import model._
import io.udash.rest._

import scala.concurrent.Future

// https://developer.github.com/v3/repos/collaborators/

trait CollaboratorsAPI {
  @GET("")
  def apply(): Future[Seq[User]]
}

object CollaboratorsAPI extends RestClientApiCompanion[EnhancedRestImplicits,CollaboratorsAPI](EnhancedRestImplicits)
