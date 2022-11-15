package com.github.opengrabeso.github
package rest

import java.time.ZonedDateTime

import com.avsystem.commons.serialization.{GenCodec, GenKeyCodec, Input, Output}

trait ZonedDateTimeCodecs {

  implicit val zonedDateTimeCodec: GenCodec[ZonedDateTime] = new GenCodec[ZonedDateTime] {
    override def read(input: Input): ZonedDateTime = {
      if (input.readNull) null
      else {
        val str = input.readSimple().readString()
        ZonedDateTime.parse(str)
      }
    }
    override def write(output: Output, value: ZonedDateTime): Unit = {
      if (value != null) {
        val str = value.toString
        output.writeSimple().writeString(str)
      } else output.writeNull()
    }
  }
  implicit val zonedDateTimeKeyCodec: GenKeyCodec[ZonedDateTime] = GenKeyCodec.create(ZonedDateTime.parse,_.toString)
}
