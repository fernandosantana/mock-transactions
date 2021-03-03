package com.company.transactions.service

import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId

@Service
class BuildTransactionDate {

    fun getDate(month: Int, year: Int): Long {
        val day = (1..28).random()
        val date = LocalDate.of(year, month, day)
        return date.atStartOfDay(ZoneId.systemDefault()).toInstant().epochSecond
    }
}