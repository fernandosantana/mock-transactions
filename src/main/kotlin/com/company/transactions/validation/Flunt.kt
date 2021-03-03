package com.company.transactions.validation

class Flunt {

    private val errors = mutableListOf<String>()

    fun hasMinValue (value: Int, min: Int, message: String) {
        if (value < min) {
            this.errors.add(message)
        }
    }

    fun hasMaxValue (value: Int, max: Int, message: String) {
        if (value > max) {
            this.errors.add(message)
        }
    }

    fun isNumberFixedLen (value: Int, len: Int, message: String) {
        val valueLength = value.toString().length
        if(valueLength !== len) {
            this.errors.add(message)
        }
    }

    fun isValid() = this.errors.size == 0

    fun getErrors() = this.errors.toList()
}