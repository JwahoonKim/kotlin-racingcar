package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.PositionHistory

class CarsTest {

    @Test
    fun `position이 가장 큰 차들이 winner로 선정된다`() {
        // given
        val cars = Cars(
            listOf(
                Car(name = "a", PositionHistory.initPositionHistory(3)),
                Car(name = "b", PositionHistory.initPositionHistory(4)),
                Car(name = "c", PositionHistory.initPositionHistory(5)),
                Car(name = "d", PositionHistory.initPositionHistory(4)),
                Car(name = "e", PositionHistory.initPositionHistory(5)),
            ),
        )

        // when
        val winners = cars.getWinners()

        // then
        assertThat(winners).size().isEqualTo(2)
        assertThat(winners).contains("c", "e")
    }
}
