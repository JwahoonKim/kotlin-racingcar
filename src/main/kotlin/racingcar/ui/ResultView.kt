package racingcar.ui

import racingcar.domain.Cars
import racingcar.service.Output

object ResultView {

    fun printResult(output: Output) {
        printStartMessage()
        printStates(output)
        printWinners(output.cars)
    }

    private fun printStartMessage() {
        println("실행 결과")
    }

    private fun printStates(output: Output) {
        for (i in 1..output.numberOfAttempts) {
            printState(cars = output.cars, round = i)
            println()
        }
    }

    private fun printState(cars: Cars, round: Int) {
        cars.forEach { car ->
            val position = "-".repeat(car.getPositionOf(round).value)
            println("${car.name} : $position")
        }
    }

    private fun printWinners(cars: Cars) {
        val winners = cars.getWinners()
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
