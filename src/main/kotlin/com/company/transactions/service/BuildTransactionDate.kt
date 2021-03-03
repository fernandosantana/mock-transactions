package com.company.transactions.service

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class BuildTransactionDate {

    fun getDate(month: Int, year: Int): Long {
        val day = (1..28).random()
        return LocalDate.of(year, month, day).toEpochDay()
    }
}