package racingcar.domain

class Cars(
    private val cars: List<Car>,
) : List<Car> by cars {

    fun move() {
        cars.forEach(Car::move)
    }

    companion object {
        fun from(carNames: List<String>): Cars {
            val cars = carNames.map { Car(name = it) }
            return Cars(cars)
        }
    }
}
