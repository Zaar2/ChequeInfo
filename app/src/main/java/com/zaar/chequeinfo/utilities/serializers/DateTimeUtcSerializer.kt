package com.zaar.chequeinfo.utilities.serializers

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.char
import kotlinx.datetime.format.parse
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object DateTimeUtcSerializer : KSerializer<DateTimeComponents> {
    private val formatter = FormatterLocalDateTime.formatterDateTimeComponent

    override fun serialize(encoder: Encoder, value: DateTimeComponents) =
        encoder.encodeString(value.toInstantUsingOffset().toString())

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("DateTimeByZeroUtc", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): DateTimeComponents =
        DateTimeComponents.parse(decoder.decodeString(), formatter)

}