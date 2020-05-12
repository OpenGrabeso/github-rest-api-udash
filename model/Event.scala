package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime

import rest.EnhancedRestDataCompanion

// https://developer.github.com/v3/issues/events/
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