import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import stringcalculator.StringCalculator

class StringCalculatorTest {

    private val calculator = StringCalculator()

    @ParameterizedTest
    @CsvSource(
        value = [
            "1 + 2 : 3",
            "1 - 2 : -1",
            "1 * 2 : 2",
            "2 / 2 : 1",
            "2 + 3 * 4 / 2 : 10",
            "2 * 3 - 4 / 2 : 1",
        ],
        delimiterString = " : ",
    )
    fun `계산기가 정상적으로 동작한다`(input: String, answer: Int) {
        val result = calculator.calculate(input)
        assertThat(result).isEqualTo(answer)
    }

    @Test
    fun `입력이 비어있으면 에러가 난다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("  ")
        }
    }

    @Test
    fun `사칙연산 기호가 아닌 경우 에러가 난다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("1 & 2")
        }
    }

    @Test
    fun `0으로 나누면 에러가 난다`() {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate("1 / 0")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 +", "1 2", "1 + +", "1 + 2 *", "1 x 3"])
    fun `잘못된 입력이 들어오면 에러가 난다`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            calculator.calculate(input)
        }
    }
}
