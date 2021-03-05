package com.company.transactions.service

import org.springframework.stereotype.Service

@Service
class BuildTransactionValue {

    fun getValue(id: Int, month: Int, transactionIndex: Int) = (((id + month + transactionIndex) / (month + 1)) * transactionIndex) + id
}