package com.company.transactions.validation

interface IValidation<T> {
    fun validate(model: T): Boolean
    fun getErrors(): List<String>
}