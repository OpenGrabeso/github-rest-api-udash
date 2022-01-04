package com.github.opengrabeso.github.model

import java.time.ZonedDateTime

trait IssueOrPull {
  def id: Long
  def number: Long
  def pull_request: Option[PRInfo]
  def html_url: String
  def title: String
  def body: String
  def user: User
  def comments: Long
  def milestone: Milestone
  def state: String
  def labels: Array[Label]
  def assignees: Array[User]
  def created_at: ZonedDateTime
  def updated_at: ZonedDateTime
  def text_matches: Array[TextMatchIssue] // used in search API only
}
