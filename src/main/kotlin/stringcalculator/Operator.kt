package stringcalculator

enum class Operator(
    val symbol: String,
    val operation: (Int, Int) -> Int,
) {
    ADDER("+", { num1, num2 -> num1 + num2 }),
    SUBTRACTOR("-", { num1, num2 -> num1 - num2 }),
    MULTIPLIER("*", { num1, num2 -> num1 * num2 }),
    DIVIDER("/", { num1, num2 ->
        if (num2 == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        } else {
            num1 / num2
        }
    }),
    ;

    fun operate(num1: Int, num2: Int): Int {
        return operation(num1, num2)
    }

    companion object {
        fun fromSymbol(operator: String): Operator {
            return entries.firstOrNull { it.symbol == operator }
                ?: throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }
}
