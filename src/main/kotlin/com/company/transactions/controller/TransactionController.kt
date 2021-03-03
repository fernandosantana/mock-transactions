package com.company.transactions.controller

import com.company.transactions.core.TransactionCore
import com.company.transactions.dto.GetTransactionDto
import com.company.transactions.model.Transaction
import com.company.transactions.validation.GetTransactionValidation
import com.company.transactions.validation.TransactionValidator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController(private val transactionCore: TransactionCore) {

    @GetMapping("/{id}/transacoes/{year}/{month}")
    fun findById(@PathVariable("id") id: Int,
                 @PathVariable("year") year: Int,
                 @PathVariable("month") month: Int): ResponseEntity<List<Transaction>> {

        TransactionValidator(GetTransactionValidation()).validate(GetTransactionDto(id, year, month))

        val transactionList = this.transactionCore.getTransactions(id, year, month)

        return ResponseEntity(transactionList, HttpStatus.OK)
    }
}