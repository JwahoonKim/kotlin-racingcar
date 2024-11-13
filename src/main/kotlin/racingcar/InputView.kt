package racingcar

object InputView {
    fun getUserInput(): Input {
        println("자동차 대수는 몇 대 인가요?")
        val numberOfCars = readln().toInt()
        println("시도할 회수는 몇 회 인가요?")
        val numberOfAttempts = readln().toInt()
        return Input(numberOfCars, numberOfAttempts)
    }
}

data class Input(
    val numberOfCars: Int,
    val numberOfAttempts: Int,
)
