package stringcalculator

class StringCalculator {
    fun calculate(input: String): Int {
        InputValidator.validate(input)

        val expression = Expression(input)

        while (expression.isEnd().not()) {
            val (operand1, operand2, operator) = expression.getOperandAndOperator()
            val operation = OperatorFactory.getOperation(operator)
            val result = operation.apply(operand1, operand2)
            expression.setResult(result)
        }

        return expression.getResult()
    }
}
