package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

case class Team( // https://docs.github.com/en/rest/reference/teams
  id: Long,
  url: String,
  name: String = null,
  slug: String = null
)

object Team extends EnhancedRestDataCompanion[Team]
