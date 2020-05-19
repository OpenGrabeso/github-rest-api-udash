package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

// https://developer.github.com/v3/search/#text-match-metadata

case class TextMatchIssue(
  object_type: String, // Issue, IssueComment
  object_url: String,
  property: String, // title, body
  fragment: String,
  matches: Array[TextMatch]
)

object TextMatchIssue extends EnhancedRestDataCompanion[TextMatchIssue]