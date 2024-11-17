package racingcar.domain

class PositionHistory(
    private val history: MutableList<Position>,
) {
    fun add(canMove: Boolean) {
        if (canMove) {
            addMoveHistory()
        } else {
            addStopHistory()
        }
    }

    private fun addMoveHistory() {
        val lastPosition = history.lastOrNull() ?: Position(0)
        history.add(lastPosition.getMovePosition())
    }

    private fun addStopHistory() {
        val lastPosition = history.lastOrNull() ?: Position(0)
        history.add(lastPosition.getStopPosition())
    }

    fun getCurrentPosition(): Position {
        return history.lastOrNull() ?: Position(0)
    }

    fun getPositionOf(round: Int): Position {
        return history.getOrNull(round) ?: Position(0)
    }

    companion object {
        fun initPositionHistory(n: Int = 0): PositionHistory {
            return PositionHistory(mutableListOf(Position(n)))
        }
    }
}
