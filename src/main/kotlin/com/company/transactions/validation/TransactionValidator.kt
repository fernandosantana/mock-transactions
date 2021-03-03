package com.company.transactions.validation

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class TransactionValidator<T>(private val validation: IValidation<T>) {

    fun validate(model: T) {
        val valid = this.validation.validate(model)
        if(!valid) {
            val errors = this.validation.getErrors().toString()
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, errors);
        }
    }
}