package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

case class User( // https://developer.github.com/v3/users/#get-the-authenticated-user
  login: String,
  id: Long,
  url: String,
  avatar_url: String,
  name: String = null
) {
  def displayName: String = if (name != null) name else login
}

object User extends EnhancedRestDataCompanion[User]
