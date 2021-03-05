package com.company.transactions.service

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters

@Service
class BuildTransactionDate {

    fun getDate(month: Int, year: Int, transactionIndex: Int): Long {
        val firstDay = 1
        val maxWeek = 5

        val dateWithFirstDayMonth = LocalDate.of(year, month, firstDay)
        val lastDayMonth = dateWithFirstDayMonth.with(TemporalAdjusters.lastDayOfMonth()).dayOfMonth

        val date = if(transactionIndex > lastDayMonth) {
            val day = (lastDayMonth + transactionIndex) / maxWeek
            LocalDate.of(year, month, day)
        } else {
            LocalDate.of(year, month, transactionIndex)
        }

        return date.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
    }


}