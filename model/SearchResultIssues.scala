package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

// it would be nice to have this generic, but this way EnhancedRestDataCompanion is simple to use
case class SearchResultIssues(
  total_count: Long,
  incomplete_results: Boolean,
  items: Seq[Issue] = Seq.empty
)

object SearchResultIssues extends EnhancedRestDataCompanion[SearchResultIssues]
