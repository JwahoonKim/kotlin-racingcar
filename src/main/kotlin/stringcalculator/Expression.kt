package stringcalculator

class Expression(input: String) {
    private val expression = input.split(DELIMITER).toMutableList()

    init {
        validateInput(input)
    }

    private fun validateInput(input: String) {
        validateBlank(input)
        validateSizeOfInput()
        validateOperandsAndOperatorsOrder()
    }

    private fun validateSizeOfInput() {
        if (expression.size.isEven()) {
            throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
        }
    }

    private fun validateBlank(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
        }
    }

    private fun validateOperandsAndOperatorsOrder() {
        expression.forEachIndexed { index, value ->
            validateOperandOrder(index, value)
            validateOperatorOrder(index, value)
        }
    }

    private fun validateOperatorOrder(index: Int, value: String) {
        if (index.isOdd() && Operator.fromSymbol(value) == null) {
            throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
        }
    }

    private fun validateOperandOrder(index: Int, value: String) {
        if (index.isEven() && value.toIntOrNull() == null) {
            throw IllegalArgumentException(INVALID_INPUT_ERROR_MESSAGE)
        }
    }

    fun getOperandAndOperator(): OperandAndOperator {
        val num1 = getNextNumber()
        val operator = getNextOperator()
        val num2 = getNextNumber()
        return OperandAndOperator(
            operand1 = num1,
            operand2 = num2,
            operator = operator,
        )
    }

    private fun getNextNumber(): Int {
        return expression.removeFirst().toInt()
    }

    private fun getNextOperator(): String {
        return expression.removeFirst()
    }

    fun setResult(result: Int) {
        expression.addFirst(result.toString())
    }

    fun isEnd(): Boolean {
        return expression.size == 1
    }

    fun getResult(): Int {
        checkCalculationFinished()
        return expression.first().toInt()
    }

    private fun checkCalculationFinished() {
        if (expression.size != 1) {
            throw IllegalArgumentException("계산이 완료되지 않았습니다.")
        }
    }

    companion object {
        private const val DELIMITER = " "
        private const val INVALID_INPUT_ERROR_MESSAGE = "입력 값이 올바르지 않습니다."
    }

    data class OperandAndOperator(
        val operand1: Int,
        val operand2: Int,
        val operator: String,
    )
}

private fun Int.isEven(): Boolean = this % 2 == 0
private fun Int.isOdd(): Boolean = this % 2 == 1
