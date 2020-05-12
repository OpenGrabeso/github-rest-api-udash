package com.github.opengrabeso.github
package model

case class Milestone(
  id: Long,
  number: Int,
  title: String,
  description: String
)

import rest.EnhancedRestDataCompanion

object Milestone extends EnhancedRestDataCompanion[Milestone]

