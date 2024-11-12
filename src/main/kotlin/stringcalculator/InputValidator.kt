package stringcalculator

class InputValidator {
    companion object {
        fun validate(input: String) {
            if (input.isBlank()) {
                throw IllegalArgumentException("입력 값이 없습니다.")
            }
        }
    }
}
