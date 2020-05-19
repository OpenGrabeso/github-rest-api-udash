package com.github.opengrabeso.github
package model

import rest.EnhancedRestDataCompanion

case class TextMatch(
  text: String,
  indices: Array[Int]
)

object TextMatch extends EnhancedRestDataCompanion[TextMatch]
