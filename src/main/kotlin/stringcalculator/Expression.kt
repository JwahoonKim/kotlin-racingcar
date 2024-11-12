package stringcalculator

class Expression(input: String) {
    private val expression = input.split(" ").toMutableList()

    fun getOperandAndOperator(): OperandAndOperator {
        checkEnoughExpression()
        val num1 = getNextNumber()
        val operator = getNextOperator()
        val num2 = getNextNumber()
        return OperandAndOperator(
            operand1 = num1,
            operand2 = num2,
            operator = operator,
        )
    }

    private fun checkEnoughExpression() {
        if (expression.size < 3) {
            throw IllegalArgumentException("입력 값이 올바르지 않습니다.")
        }
    }

    fun getNextNumber(): Int {
        return expression.removeFirst().toInt()
    }

    fun getNextOperator(): String {
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

    data class OperandAndOperator(
        val operand1: Int,
        val operand2: Int,
        val operator: String,
    )
}
