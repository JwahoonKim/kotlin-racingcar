package stringcalculator

class OperatorFactory {
    companion object {
        fun getOperation(operator: String): Operator {
            return when (operator) {
                "+" -> Adder()
                "-" -> Subtractor()
                "*" -> Multiplier()
                "/" -> Divider()
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }
    }
}
