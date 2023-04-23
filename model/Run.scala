package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime
import rest.EnhancedRestDataCompanion

// https://docs.github.com/en/rest/actions/workflow-runs?apiVersion=2022-11-28#list-workflow-runs-for-a-repository

case class Run(
  id: Long,
  name: String = null,
  created_at: ZonedDateTime,
  updated_at: ZonedDateTime,
  run_started_at: ZonedDateTime,
  check_suite_id: Long,
  head_branch: String = null,
  head_sha: String,
  path: String,
  run_number: Int,
  run_attempt: Int,
  // referenced_workflows
  conclusion: String = null,
  event: String,
  workflow_id: Long,
  url: String,
  html_url: String,
  actor: User,
  triggering_actor: User,
  repository: Repository,
  head_repository: Repository,
  //head_commit: Commit
)

object Run extends EnhancedRestDataCompanion[Run]
