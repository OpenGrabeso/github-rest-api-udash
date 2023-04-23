package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime
import rest.EnhancedRestDataCompanion

case class Runs(
  total_count: Long = 0,
  workflow_runs: Seq[Run] = Seq.empty
)

object Runs extends EnhancedRestDataCompanion[Runs]
