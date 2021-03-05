package com.company.transactions.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BuildCodeSyllablesToTransactionTest {

    @Test
    fun `must return sillable list whithout zeros`() {
        val id = 100000
        val year = 2021
        val month = 10

        val buildCodeSyllabes = BuildCodeSyllablesToTransaction()
        val codeSyllablesList = buildCodeSyllabes.getSyllables(id, year, month)

        assertFalse(codeSyllablesList.contains(0))
    }

    @Test
    fun `must return code sillable list with space code - mean two words`() {
        val id = 100000
        val year = 2021
        val month = 10

        val buildCodeSyllabes = BuildCodeSyllablesToTransaction()
        val codeSyllablesList = buildCodeSyllabes.getSyllables(id, year, month)

        assertTrue(codeSyllablesList.contains(32))
    }
}