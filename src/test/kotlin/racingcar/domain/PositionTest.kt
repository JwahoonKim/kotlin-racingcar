package racingcar.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositionTest {

    @Test
    fun `Position 초기화 - 값이 0 이상이면 성공`() {
        // Given & When
        val position = Position(0)

        // Then
        assertEquals(0, position.value)
    }

    @Test
    fun `Position 초기화 - 값이 음수면 예외 발생`() {
        // Given & When & Then
        val exception = assertThrows<IllegalArgumentException> {
            Position(-1)
        }
        assertEquals("위치는 0 이상이어야 합니다.", exception.message)
    }

    @Test
    fun `getMovePosition - 위치를 1 증가시킨 새 Position을 반환`() {
        // Given
        val position = Position(5)

        // When
        val movedPosition = position.getMovePosition()

        // Then
        assertEquals(6, movedPosition.value)
    }

    @Test
    fun `getStopPosition - 동일한 값을 가진 새 Position 반환`() {
        // Given
        val position = Position(5)

        // When
        val stoppedPosition = position.getStopPosition()

        // Then
        assertEquals(5, stoppedPosition.value)
    }

    @Test
    fun `compareTo - 비교 결과가 올바르게 동작`() {
        // Given
        val position1 = Position(3)
        val position2 = Position(5)

        // When & Then
        assertTrue(position1 < position2)
        assertTrue(position2 > position1)
        assertEquals(0, position1.compareTo(Position(3)))
    }
}
