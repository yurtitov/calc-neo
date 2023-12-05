package com.ytty.calclib.operand

internal class OperandBuilder {

    private var value = INIT_VALUE

    fun concatDigit(digit: Int): OperandBuilder {
        if (value == INIT_VALUE) {
            value = "$digit"
        } else {
            value += digit
        }
        return this
    }

    fun concatComma(): OperandBuilder {
        if (!containsComma(value)) {
            value += COMMA
        }
        return this
    }

    fun intermediateStringValue(): String {
        return value
    }

    fun build(): Operand {
        val result = Operand(value)
        clean()
        return result
    }

    fun clean() {
        value = INIT_VALUE
    }

    private fun containsComma(s: String): Boolean {
        return s.contains('.') || s.contains(',')
    }

    companion object {
        private const val COMMA = "."
        private const val INIT_VALUE = "0"
    }
}
