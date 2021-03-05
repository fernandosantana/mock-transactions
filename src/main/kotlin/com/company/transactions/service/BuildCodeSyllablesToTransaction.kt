package com.company.transactions.service

import org.springframework.stereotype.Service

@Service
class BuildCodeSyllablesToTransaction {

    fun getSyllables(id: Int, year: Int, month: Int): List<Int> {
        val minSize = 5

        val idCodes = id.toString().chunked(2)
        val yearCodes = year.toString().chunked(2)

        val codeSyllablesById = idCodes.map { it.toInt() }.filter { it != 0 }
        val codeSyllablesByYear = yearCodes.map { it.toInt() }.filter { it != 0 }

        val codeSyllables = mutableListOf(month)
        codeSyllables.addAll(codeSyllablesById)
        codeSyllables.addAll(codeSyllablesByYear)

        if(codeSyllables.size < minSize) {
            val newCode = codeSyllables.first() * minSize
            codeSyllables.add(newCode)
        }

        return codeSyllables
    }
}