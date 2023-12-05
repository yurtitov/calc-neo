package com.ytty.calclib.operand

import java.math.BigDecimal

internal class Operand {

    private val value: BigDecimal

    constructor(str: String) {
        this.value = BigDecimal(str)
    }

    constructor(value: BigDecimal) {
        this.value = value
    }
    override fun toString(): String {
        return value.toString()
    }

    fun value(): BigDecimal {
        return value
    }
}