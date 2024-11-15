package racingcar.domain

import racingcar.domain.movestrategy.MoveStrategy
import racingcar.domain.movestrategy.RandomMoveStrategy

class Car(
    val name: String,
    position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    var position = position
        private set

    fun move() {
        if (moveStrategy.canMove()) {
            position += 1
        }
    }
}
