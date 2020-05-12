package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime

import rest.EnhancedRestDataCompanion

case class Repository(
  name: String,
  full_name: String,
  owner: User,
  html_url: String,
  description: String,
  url: String
)

object Repository extends EnhancedRestDataCompanion[Repository]
