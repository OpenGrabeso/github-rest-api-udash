package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime
import rest.EnhancedRestDataCompanion

case class Issue(
  id: Long,
  number: Long,
  pull_request: Option[PRInfo] = None,
  html_url: String = "",
  title: String,
  body: String,
  user: User,
  comments: Long,
  milestone: Milestone,
  state: String,
  labels: Array[Label],
  assignees: Array[User],
  created_at: ZonedDateTime,
  updated_at: ZonedDateTime,
  text_matches: Array[TextMatchIssue] = Array.empty // used in search API only
) extends IssueOrPull

object Issue extends EnhancedRestDataCompanion[Issue]