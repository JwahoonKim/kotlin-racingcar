import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `named arguments`() {
        val person = Person(
            name = "Alice",
            age = 29,
            nickname = "Ali",
        )

        assertThat(person.name).isEqualTo("Alice")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("Ali")
    }

    @Test
    fun `default arguments`() {
        val person = Person(
            name = "Alice",
            age = 29,
        )

        assertThat(person.name).isEqualTo("Alice")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("Alice")
    }

    @Test
    fun `data class equals`() {
        val person1 = Person(
            name = "Alice",
            age = 29,
        )

        val person2 = Person(
            name = "Alice",
            age = 29,
        )

        assertThat(person1).isEqualTo(person2)
    }
}
