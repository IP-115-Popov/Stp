package laba5

class TPNumber {
    var number: String
    var system: Int
    var accuracy: Int

    constructor(number: String = "0", system: Int = 10, accuracy: Int = 0) {
        require(system in 2..16) { "неподходящаяя система счисления" }
        this.number = number
        this.system = system
        this.accuracy = accuracy
    }

    constructor(number: String, system: String, accuracy: String) :
            this(
                number,
                system.toInt(),
                accuracy.toInt()
            )

    fun copy(): TPNumber {
        return TPNumber(
            number = this.number,
            system = this.system,
            accuracy = this.accuracy
        )
    }

    operator fun plus(other: TPNumber): TPNumber {
        require(system == other.system) { "Системы счисления должны быть одинаковыми" }
        require(accuracy == other.accuracy) { "точности разные" }

        val maxLength = maxOf(number.length, other.number.length)
        val num1 = number.padStart(maxLength, '0')
        val num2 = other.number.padStart(maxLength, '0')

        var carry = 0
        var result = ""
        for (i in maxLength - 1 downTo 0) {
            val digit1 = charToDigit(num1[i])
            val digit2 = charToDigit(num2[i])
            val sum = digit1 + digit2 + carry
            carry = sum / system
            result = digitToChar(sum % system) + result
        }
        if (carry > 0) {
            result = digitToChar(carry) + result
        }
        return TPNumber(result, system )

    }
    private fun charToDigit(char: Char): Int =
        when (char) {
            in '0'..'9' -> char.digitToInt()
            'A' -> 10
            'B' -> 11
            'C' -> 12
            'D' -> 13
            'E' -> 14
            'F' -> 15
            else -> throw Exception("не подходяший символ")
        }

    private fun digitToChar(digit: Int): Char =
        when (digit) {
            in 0..9 -> digit.digitToChar()
            10 -> 'A'
            11 -> 'B'
            12 -> 'C'
            13 -> 'D'
            14 -> 'E'
            15 -> 'F'
            else -> throw Exception("не подходяшее число")
        }
    override fun toString(): String {
        return "${number} (system $system)"
    }
}