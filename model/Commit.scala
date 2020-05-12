package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

case class Commit(
  url: String,
  sha: String,
  html_url: String,
  author: User,
  committer: User,
)

object Commit extends EnhancedRestDataCompanion[Commit]
