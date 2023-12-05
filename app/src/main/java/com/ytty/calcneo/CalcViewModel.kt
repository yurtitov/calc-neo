package com.ytty.calcneo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ytty.calclib.CalcProcessor
import com.ytty.calclib.operator.AdditionOperator
import com.ytty.calclib.operator.CleanOperator
import com.ytty.calclib.operator.DivisionOperator
import com.ytty.calclib.operator.EqualOperator
import com.ytty.calclib.operator.MultiplicationOperator
import com.ytty.calclib.operator.PercentOperator
import com.ytty.calclib.operator.PlusMinusToggleSignOperator
import com.ytty.calclib.operator.SubtractionOperator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CalcViewModel : ViewModel() {

    private val processor = CalcProcessor()
        .apply {
            addResultListener(object : CalcProcessor.ResultListener() {
                override fun onResult(result: String) {
                    viewModelScope.launch {
                        _state.emit(State(result))
                    }
                }

                override fun onError(message: String) {
                    TODO("Not yet implemented")
                }
            })
        }

    private val _state = MutableStateFlow(State.empty())
    val state: StateFlow<State> get() = _state

    fun input(action: Action) {
        when (action) {
            is Action.DigitClick -> digitClick(action.digit)
            Action.AdditionClick -> additionClick()
            Action.CleanClick -> cleanClick()
            Action.CommaClick -> commaClick()
            Action.DivisionClick -> divisionClick()
            Action.EqualClick -> equalClick()
            Action.MultiplicationClick -> multiplicationClick()
            Action.PercentClick -> percentClick()
            Action.PlusMinusSignClick -> plusMinusSignClick()
            Action.SubtractionClick -> subtractionClick()
        }
    }

    override fun onCleared() {
        super.onCleared()
        processor.clear()
    }

    private fun digitClick(digit: Int) {
        processor.addDigit(digit)
    }

    private fun commaClick() {
        processor.addComma()
    }

    private fun additionClick() {
        processor.process(AdditionOperator())
    }

    private fun cleanClick() {
        processor.process(CleanOperator())
    }

    private fun divisionClick() {
        processor.process(DivisionOperator())
    }

    private fun equalClick() {
        processor.process(EqualOperator())
    }

    private fun multiplicationClick() {
        processor.process(MultiplicationOperator())
    }

    private fun percentClick() {
        processor.process(PercentOperator())
    }

    private fun plusMinusSignClick() {
        processor.process(PlusMinusToggleSignOperator())
    }

    private fun subtractionClick() {
        processor.process(SubtractionOperator())
    }

    sealed interface Action {

        data class DigitClick(val digit: Int) : Action
        data object CleanClick : Action
        data object PlusMinusSignClick : Action
        data object PercentClick : Action
        data object MultiplicationClick : Action
        data object DivisionClick : Action
        data object SubtractionClick : Action
        data object AdditionClick : Action
        data object CommaClick : Action
        data object EqualClick : Action
    }

    data class State(
        val displayText: String
    ) {
        companion object {
            fun empty(): State = State("0")
        }
    }
}
