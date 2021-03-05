package com.company.transactions.core

import com.company.transactions.dto.BuildTransactionDto
import com.company.transactions.model.Transaction
import com.company.transactions.service.BuildCodeSyllablesToTransaction
import com.company.transactions.service.BuildTransactionDate
import com.company.transactions.service.BuildTransactionDescription
import com.company.transactions.service.BuildTransactionValue
import org.springframework.stereotype.Service

@Service
class TransactionCore(
    private val buildCodeSyllables: BuildCodeSyllablesToTransaction,
    private val buildDate: BuildTransactionDate,
    private val buildValue: BuildTransactionValue,
    private val buildDescription: BuildTransactionDescription) {

    fun getTransactions(id: Int, year: Int, month: Int): List<Transaction> {
        val totalTransactions = this.totalTransactions(id, month)
        val codeSyllables = this.buildCodeSyllables.getSyllables(id, year, month)

        val transactions = 1..totalTransactions
        return transactions.map { this.buildTransaction(BuildTransactionDto(id, year, month, codeSyllables, it)) }
    }

    private fun buildTransaction(buildTransactionDto: BuildTransactionDto): Transaction {
        val (id, year, month, codeSyllables, transactionIndex) = buildTransactionDto

        val date = this.buildDate.getDate(month, year, transactionIndex)
        val value = this.buildValue.getValue(id, month, transactionIndex)
        val description = this.buildDescription.getDescription(codeSyllables, transactionIndex)

        return Transaction(description, date,  value)
    }

    private fun totalTransactions(id: Int, month: Int): Int {
        val firstDigit = id.toString()[0].toString().toInt()
        return firstDigit * month
    }
}