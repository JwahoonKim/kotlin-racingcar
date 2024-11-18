package racingcar.ui

import racingcar.domain.Cars
import racingcar.service.RacingCarService

object ResultView {

    fun printResult(output: RacingCarService.Output) {
        printStartMessage()
        printStates(output)
        printWinners(output.cars)
    }

    private fun printStartMessage() {
        println("실행 결과")
    }

    private fun printStates(output: RacingCarService.Output) {
        for (i in 1..output.numberOfAttempts) {
            printState(cars = output.cars, round = i)
            println()
        }
    }

    private fun printState(cars: Cars, round: Int) {
        val result = StringBuilder()
        cars.forEach { car ->
            val position = "-".repeat(car.getPositionOf(round).value)
            result.append("${car.name} : $position\n")
        }
        print(result.toString())
    }

    private fun printWinners(cars: Cars) {
        val winners = cars.getWinners()
        println("${winners.joinToString(", ")}가 최종 우승했습니다.")
    }
}
