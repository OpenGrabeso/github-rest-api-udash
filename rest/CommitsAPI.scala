package com.github.opengrabeso.github.rest

import io.udash.rest._

trait CommitsAPI {
  @Prefix("")
  def apply(ref: String): CommitsRefAPI
}

object CommitsAPI extends RestClientApiCompanion[EnhancedRestImplicits,CommitsAPI](EnhancedRestImplicits)
