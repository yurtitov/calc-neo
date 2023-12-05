package com.ytty.calclib

import com.ytty.calclib.expression.Expression
import com.ytty.calclib.operand.OperandBuilder
import com.ytty.calclib.operator.CleanOperator
import com.ytty.calclib.operator.Operator

class CalcProcessor {

    private val listeners: MutableList<ResultListener> = ArrayList()
    private val operandBuilder = OperandBuilder()
    private val expression = Expression()

    fun addDigit(digit: Int) {
        operandBuilder.concatDigit(digit)
        emitResult(operandBuilder.intermediateStringValue())
    }

    fun addComma() {
        operandBuilder.concatComma()
        emitResult(operandBuilder.intermediateStringValue())
    }

    fun process(operator: Operator) {
        if (operator is CleanOperator) {
            operandBuilder.clean()
        }
        expression.add(operandBuilder.build())
        expression.add(operator)
    }

    fun clear() {
        listeners.clear()
    }

    fun addResultListener(listener: ResultListener) {
        listeners.add(listener)
    }

    private fun emitResult(result: String) {
        listeners.forEach {listener ->
            listener.onResult(result)
        }
    }

    abstract class ResultListener {
        abstract fun onResult(result: String)
        abstract fun onError(message: String)
    }

}