package com.zaar.chequeinfo.model.dataSource.local.room.converter

import androidx.room.TypeConverter
import com.zaar.chequeinfo.utilities.serializers.FormatterLocalDateTime
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.parse
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

class ConverterDate {

    @TypeConverter
    fun dateTimeToTimestamp(dateTime: LocalDateTime): Long =
        dateTime.toInstant(TimeZone.UTC).epochSeconds

    @TypeConverter
    fun timestampToDateTime(timestamp: Long): LocalDateTime =
        Instant.fromEpochMilliseconds(timestamp).toLocalDateTime(TimeZone.UTC)

    @TypeConverter
    fun dateTimeCompToTimestamp(dateTimeComponents: DateTimeComponents): Long =
        dateTimeComponents.toInstantUsingOffset().epochSeconds

    @TypeConverter
    fun dateTimeCompToString(dateTimeComponents: DateTimeComponents): String =
        dateTimeComponents.toInstantUsingOffset().toString()

    @TypeConverter
    fun stringToDateTimeComp(string: String): DateTimeComponents =
        DateTimeComponents.parse(string, FormatterLocalDateTime.formatterDateTimeComponent)

    @TypeConverter
    fun dateTimeToString(dateTime: LocalDateTime): String =
        dateTime.format(FormatterLocalDateTime.formatterDateTime)

    @TypeConverter
    fun stringToDateTime(string: String): LocalDateTime =
        LocalDateTime.parse(string, FormatterLocalDateTime.formatterDateTime)
}