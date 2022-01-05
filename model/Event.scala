package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime

import rest.EnhancedRestDataCompanion

// https://developer.github.com/v3/issues/events/

/**
 * @param event see https://docs.github.com/en/developers/webhooks-and-events/events/issue-event-types
 *              we use: reopened, closed, mentioned, assigned, unassigned, review_requested, review_request_removed
* */
case class Event(
  id: Long,
  actor: User,
  assignee: User = null, // Only provided for assigned and unassigned events
  assignees: Seq[User] = null, // Only provided for assigned and unassigned events
  assigner: User = null, // Only provided for assigned and unassigned events
  commit_id: String = null,
  created_at: ZonedDateTime,
  event: String,
  url: String

)

object Event extends EnhancedRestDataCompanion[Event]