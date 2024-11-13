package stringcalculator

class StringCalculator {
    fun calculate(input: String): Int {
        val expression = Expression(input)

        while (expression.isEnd().not()) {
            val (operand1, operand2, operator) = expression.getOperandAndOperator()
            val operation = Operator.fromSymbol(operator)
            val result = operation.operate(operand1, operand2)
            expression.setResult(result)
        }

        return expression.getResult()
    }
}
