package com.github.opengrabeso.github
package model

import java.time.ZonedDateTime

import rest.EnhancedRestDataCompanion

// https://developer.github.com/v3/repos/releases/#get-a-single-release
case class Release(
  url: String,
  html_url: String,
  assets_url: String,
  id: Long,
  created_at: ZonedDateTime,
  published_at: ZonedDateTime,
  tag_name: String,
  name: String,
  body: String,
  author: User,
  assets: Seq[Assets],
)

object Release extends EnhancedRestDataCompanion[Release]