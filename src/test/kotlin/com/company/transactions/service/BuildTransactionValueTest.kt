package com.company.transactions.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BuildTransactionValueTest {

    @Test
    fun `must return with max possible value on params`() {
        val id = 100000
        val month = 12
        val transactionIndex = 108

        val buildValue = BuildTransactionValue()
        val value = buildValue.getValue(id, month, transactionIndex)
        assertEquals(931708, value)
    }

    @Test
    fun `must return with min possible value on params`() {
        val id = 1000
        val month = 1
        val transactionIndex = 1

        val buildValue = BuildTransactionValue()
        val value = buildValue.getValue(id, month, transactionIndex)
        assertEquals(1501, value)
    }
}