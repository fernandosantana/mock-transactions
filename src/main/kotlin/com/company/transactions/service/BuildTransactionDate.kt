package com.company.transactions.service

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.TemporalAdjusters

@Service
class BuildTransactionDate {

    fun getDate(month: Int, year: Int, transactionIndex: Int): Long {
        val dateWithFirstDayMonth = LocalDate.of(year, month, 1)
        val lastDayMonth = dateWithFirstDayMonth.with(TemporalAdjusters.lastDayOfMonth()).dayOfMonth

        val date = if(transactionIndex > lastDayMonth) {
            val day = (lastDayMonth + transactionIndex) / 5
            LocalDate.of(year, month, day)
        } else {
            LocalDate.of(year, month, transactionIndex)
        }

        return date.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
    }


}