package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionHistoryTest {

    @Test
    fun `이동 성공 시 currentPosition이 1 증가한다`() {
        val positionHistory = PositionHistory.initPositionHistory()
        positionHistory.add(canMove = true)

        val expectedPosition = Position(1) // Assuming Position(0).getMovePosition() -> Position(1)
        assertEquals(expectedPosition, positionHistory.getCurrentPosition())
    }

    @Test
    fun `이동 실패 시 currentPosition이 변경되지 않는다`() {
        val positionHistory = PositionHistory.initPositionHistory()
        positionHistory.add(canMove = false)

        val expectedPosition = Position(0) // Assuming Position(0).getStopPosition() -> Position(0)
        assertEquals(expectedPosition, positionHistory.getCurrentPosition())
    }

    @Test
    fun `currentPostion이 제대로 반환된다`() {
        val positionHistory = PositionHistory.initPositionHistory(5)
        positionHistory.add(canMove = true)

        val expectedPosition = Position(6) // Assuming Position(5).getMovePosition() -> Position(6)
        assertEquals(expectedPosition, positionHistory.getCurrentPosition())
    }

    @Test
    fun `라운드별로 히스토리가 잘 남는다`() {
        val positionHistory = PositionHistory.initPositionHistory()
        positionHistory.add(canMove = true) // Round 1
        positionHistory.add(canMove = false) // Round 2
        positionHistory.add(canMove = true) // Round 3

        val round1Position = Position(1)
        assertEquals(round1Position, positionHistory.getPositionOf(1))

        val round2Position = Position(1)
        assertEquals(round2Position, positionHistory.getPositionOf(2))

        val round3Position = Position(2)
        assertEquals(round3Position, positionHistory.getPositionOf(3))
    }
}
