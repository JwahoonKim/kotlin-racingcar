package racingcar.random

class FixIntGenerator(
    private val fixedInt: Int,
) : RandomGenerator {
    override fun generate(): Int {
        return fixedInt
    }
}
