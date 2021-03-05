package com.company.transactions.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class BuildTransactionDateTest {

    @Test
    fun `must return date 2021-02-28 as long`() {
        val buildDate = BuildTransactionDate()
        val longDate = buildDate.getDate(2, 2021, 28)

        val date = LocalDateTime.ofInstant(Instant.ofEpochSecond(longDate), ZoneOffset.UTC)
        assertEquals("2021-02-28T12:00", date.toString())
    }

    @Test
    fun `must return date with transactionId bigger than 31`() {
        val buildDate = BuildTransactionDate()
        val longDate = buildDate.getDate(2, 2021, 40)

        val date = LocalDateTime.ofInstant(Instant.ofEpochSecond(longDate), ZoneOffset.UTC)
        assertEquals("2021-02-13T12:00", date.toString())
    }
}