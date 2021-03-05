package com.company.transactions.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BuildTransactionDescriptionTest {

    @Test
    fun `must return at least min size - equal 10`() {
        val id = 100000
        val year = 2021
        val month = 10

        val buildDescription = BuildTransactionDescription()
        val buildCodeSyllabes = BuildCodeSyllablesToTransaction()
        val codeSyllablesList = buildCodeSyllabes.getSyllables(id, year, month)

        val description = buildDescription.getDescription(codeSyllablesList, 1)
        assertTrue(description.length >= 10)
    }

    @Test
    fun `must return bisides 10 and 60 characters with max id and month`() {
        val id = 99999
        val year = 2021
        val month = 12

        val buildDescription = BuildTransactionDescription()
        val buildCodeSyllabes = BuildCodeSyllablesToTransaction()
        val codeSyllablesList = buildCodeSyllabes.getSyllables(id, year, month)

        val description = buildDescription.getDescription(codeSyllablesList, 1)
        assertTrue(description.length >= 10)
        assertTrue(description.length <= 60)
    }
}