package com.zaar.chequeinfo.utilities.serializers

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.DateTimeFormat
import kotlinx.datetime.format.char

object FormatterLocalDateTime {
    val formatterDateTimeComponent: DateTimeFormat<DateTimeComponents>
        get() = DateTimeComponents.Format {
            date(LocalDate.Formats.ISO)
            char('T')
            time(LocalTime.Formats.ISO)
            offset(UtcOffset.Formats.ISO)
        }
    val formatterDateTime: DateTimeFormat<LocalDateTime>
        get() = LocalDateTime.Format {
            date(LocalDate.Formats.ISO)
            char('T')
            time(LocalTime.Formats.ISO)
        }
    val formatterDate: DateTimeFormat<LocalDateTime>
        get() = LocalDateTime.Format {
            date(LocalDate.Format {
                dayOfMonth(); char('.')
                monthNumber(); char('.')
                year()
            })
        }
}