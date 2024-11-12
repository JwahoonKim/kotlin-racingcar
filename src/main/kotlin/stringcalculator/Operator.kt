package stringcalculator

interface Operator {
    fun apply(num1: Int, num2: Int): Int
}

class Adder : Operator {
    override fun apply(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

class Subtractor : Operator {
    override fun apply(num1: Int, num2: Int): Int {
        return num1 - num2
    }
}

class Multiplier : Operator {
    override fun apply(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}

class Divider : Operator {
    override fun apply(num1: Int, num2: Int): Int {
        if (num2 == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        return num1 / num2
    }
}
