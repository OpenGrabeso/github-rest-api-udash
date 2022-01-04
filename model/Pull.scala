package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime

import rest.EnhancedRestDataCompanion

case class Pull(
  id: Long,
  number: Long,
  pull_request: Option[PRInfo] = None,
  html_url: String,
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
  // values above are common with Issue
  // PR specific values follow
  merged_at: ZonedDateTime,
  requested_reviewers: Array[User],
  requested_teams: Array[Team],
  // common with Issue, but with a default value - last
  text_matches: Array[TextMatchIssue] = Array.empty // used in search API only
) extends IssueOrPull


object Pull extends EnhancedRestDataCompanion[Pull]