package racingcar

import racingcar.random.RandomGenerator
import racingcar.random.RandomGeneratorImpl

class Car(
    var position: Int = 0,
    private val randomGenerator: RandomGenerator = RandomGeneratorImpl(),
) {
    fun move() {
        val randomInt = randomGenerator.generate()
        if (randomInt >= 4) {
            position += 1
        }
    }
}
