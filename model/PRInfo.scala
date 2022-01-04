package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

case class PRInfo(
  url: String,
  html_url: String
)

object PRInfo extends EnhancedRestDataCompanion[PRInfo]
