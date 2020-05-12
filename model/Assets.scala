package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

case class Assets(
  url: String,
  browser_download_url: String,
  id: Long,
  name: String,
  label: String,
  uploader: User
)

object Assets extends EnhancedRestDataCompanion[Assets]
