package racingcar.service

import racingcar.domain.Cars

class RacingCarService {
    fun run(input: Input): Output {
        val cars = Cars.from(input.carNames)

        for (i in 1..input.numberOfAttempts) {
            cars.move()
        }

        return Output(
            cars = cars,
            numberOfAttempts = input.numberOfAttempts,
        )
    }
}

data class Input(
    val carNames: List<String>,
    val numberOfAttempts: Int,
)

data class Output(
    val cars: Cars,
    val numberOfAttempts: Int,
)
