class StringCalculator {

    fun calculate(input: String): Int {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력 값이 없습니다.")
        }

        val split = input.split(" ")
        val deque = ArrayDeque<String>().apply { addAll(split) }

        while (true) {
            val num1 = deque.removeFirst().toInt()
            val operator = deque.removeFirst()
            val num2 = deque.removeFirst().toInt()

            when (operator) {
                "+" -> deque.addFirst(add(num1, num2).toString())
                "-" -> deque.addFirst(subtract(num1, num2).toString())
                "*" -> deque.addFirst(multiply(num1, num2).toString())
                "/" -> deque.addFirst(divide(num1, num2).toString())
                else -> throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }

            if (deque.size == 1) {
                return deque.removeFirst().toInt()
            }
        }
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    private fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    private fun divide(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        return a / b
    }
}
