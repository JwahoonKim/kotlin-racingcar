package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy
import racingcar.domain.movestrategy.RandomMoveStrategy

class Car(
    val name: String,
    private val positionHistory: PositionHistory = PositionHistory.initPositionHistory(),
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) : Comparable<Car> {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move() {
        positionHistory.add(moveStrategy.canMove())
    }

    fun getPositionOf(round: Int): Position {
        return positionHistory.getPositionOf(round)
    }

    fun getCurrentPosition(): Position {
        return positionHistory.getCurrentPosition()
    }

    override fun compareTo(other: Car): Int {
        return getCurrentPosition() compareTo other.getCurrentPosition()
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
