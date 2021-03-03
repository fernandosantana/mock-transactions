package com.company.transactions.service

import org.springframework.stereotype.Service

@Service
class BuildTransactionDescription {

    fun getDescription(codeSyllables: List<Int>, transactionIndex: Int): String {
        val syllables = codeSyllables.map { SourceSyllables.get(it + transactionIndex) }
        return syllables.joinToString("")
    }
}