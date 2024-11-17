package racingcar.domain

@JvmInline
value class Position(val value: Int) : Comparable<Position> {
    init {
        require(value >= 0) { "위치는 0 이상이어야 합니다." }
    }

    fun getMovePosition(): Position {
        return Position(value + MOVE_STEP)
    }

    fun getStopPosition(): Position {
        return Position(value)
    }

    override fun compareTo(other: Position): Int {
        return value.compareTo(other.value)
    }

    companion object {
        private const val MOVE_STEP = 1
    }
}
