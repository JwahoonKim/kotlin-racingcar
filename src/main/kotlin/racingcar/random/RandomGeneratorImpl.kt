package racingcar.random

import kotlin.random.Random

class RandomGeneratorImpl : RandomGenerator {
    override fun generate(): Int {
        return Random.nextInt(0, 10)
    }
}
