package com.company.transactions.service

import com.company.transactions.core.TransactionCore
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransactionCoreTest {

    @Test
    fun `must return 108 objects as max possible length`() {
        val id = 99999
        val year = 2021
        val month = 12

        val transactionCore = TransactionCore(
            BuildCodeSyllablesToTransaction(),
            BuildTransactionDate(),
            BuildTransactionValue(),
            BuildTransactionDescription()
        )

        val transactions = transactionCore.getTransactions(id, year, month)
        assertEquals(108, transactions.size)
    }
}