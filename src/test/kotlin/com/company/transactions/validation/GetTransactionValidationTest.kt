package com.company.transactions.validation

import com.company.transactions.dto.GetTransactionDto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class GetTransactionValidationTest {

    @Test
    fun `must return id less than 1000 error`() {
        val getTransactionDto = GetTransactionDto(1, 2021, 12)
        val validation = GetTransactionValidation()
        val validate = validation.validate(getTransactionDto)

        assertFalse(validate)
        assertEquals(1, validation.getErrors().size)
        assertEquals("Id can't be less than 1000", validation.getErrors()[0])
    }

    @Test
    fun `must return id bigger than 100000 error`() {
        val getTransactionDto = GetTransactionDto(200000, 2021, 12)
        val validation = GetTransactionValidation()
        val validate = validation.validate(getTransactionDto)

        assertFalse(validate)
        assertEquals(1, validation.getErrors().size)
        assertEquals("Id can't be bigger than 100000", validation.getErrors()[0])
    }

    @Test
    fun `must return month less than 1 error`() {
        val getTransactionDto = GetTransactionDto(20000, 2021, 0)
        val validation = GetTransactionValidation()
        val validate = validation.validate(getTransactionDto)

        assertFalse(validate)
        assertEquals(1, validation.getErrors().size)
        assertEquals("Month can't be less than 1", validation.getErrors()[0])
    }

    @Test
    fun `must return month bigger than 12 error`() {
        val getTransactionDto = GetTransactionDto(20000, 2021, 13)
        val validation = GetTransactionValidation()
        val validate = validation.validate(getTransactionDto)

        assertFalse(validate)
        assertEquals(1, validation.getErrors().size)
        assertEquals("Month can't be bigger than 12", validation.getErrors()[0])
    }

    @Test
    fun `must return year cant less than 4 digit error`() {
        val getTransactionDto = GetTransactionDto(20000, 20, 1)
        val validation = GetTransactionValidation()
        val validate = validation.validate(getTransactionDto)

        assertFalse(validate)
        assertEquals(2, validation.getErrors().size)
        assertEquals("Year must be on format YYYY", validation.getErrors()[0])
    }

    @Test
    fun `must return year cant less than 1970 error`() {
        val getTransactionDto = GetTransactionDto(20000, 1950, 1)
        val validation = GetTransactionValidation()
        val validate = validation.validate(getTransactionDto)

        assertFalse(validate)
        assertEquals(1, validation.getErrors().size)
        assertEquals("Min year is 1970", validation.getErrors()[0])
    }
}