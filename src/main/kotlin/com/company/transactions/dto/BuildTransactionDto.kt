package com.company.transactions.dto

data class BuildTransactionDto (
    val id: Int,
    val year: Int,
    val month: Int,
    val codeSyllables: List<Int>,
    val transactionIndex: Int
)