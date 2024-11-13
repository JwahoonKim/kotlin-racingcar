package racingcar

object ResultView {

    fun printStartMessage() {
        println("실행 결과")
    }

    fun printState(cars: Cars) {
        cars.forEach(::printPosition)
        println()
    }

    private fun printPosition(car: Car) {
        "-".repeat(car.position).also { println(it) }
    }
}
