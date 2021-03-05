package com.company.transactions.service

import org.springframework.stereotype.Service
import java.time.*
import java.time.temporal.TemporalAdjusters

@Service
class BuildTransactionDate {

    fun getDate(month: Int, year: Int, transactionIndex: Int): Long {
        val firstDay = 1
        val maxWeek = 5
        val defaultTime = LocalTime.of(12,0,0)

        val dateWithFirstDayMonth = LocalDateTime.of(LocalDate.of(year, month, firstDay), defaultTime)
        val lastDayMonth = dateWithFirstDayMonth.with(TemporalAdjusters.lastDayOfMonth()).dayOfMonth

        val date = if(transactionIndex > lastDayMonth) {
            val day = (lastDayMonth + transactionIndex) / maxWeek
            LocalDateTime.of(LocalDate.of(year, month, day), defaultTime)
        } else {
            LocalDateTime.of(LocalDate.of(year, month, transactionIndex), defaultTime)
        }

        //return date.toEpochDay()
        return date.atZone(ZoneOffset.UTC).toEpochSecond()
    }


}