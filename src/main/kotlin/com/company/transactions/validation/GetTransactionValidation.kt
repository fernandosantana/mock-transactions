package com.company.transactions.validation

import com.company.transactions.dto.GetTransactionDto

class GetTransactionValidation() : IValidation<GetTransactionDto> {
    private val errors = mutableListOf<String>()

    override fun validate(model: GetTransactionDto): Boolean {
        val flunt = Flunt()
        flunt.hasMinValue(model.id, 1000, "Id can't be less than 1000")
        flunt.hasMaxValue(model.id, 100000, "Id can't be bigger than 100000")
        flunt.hasMinValue(model.month, 1, "Month can't be less than 1")
        flunt.hasMaxValue(model.month, 12, "Month can't be bigger than 12")
        flunt.isNumberFixedLen(model.year, 4, "Year must be on format YYYY")
        flunt.hasMinValue(model.year, 1970, "Min year is 1970")

        this.errors.addAll(flunt.getErrors())
        return flunt.isValid()
    }

    override fun getErrors() = errors.toList()
}