package laba5

class TPNumber {
    private var number: String
    var system: Int
    var accuracy: Int
    fun getNumber() : String {
        val length = number.length
        if (accuracy > length || accuracy <= 0) {
            return number // Некорректная позиция, возвращаем исходную строку
        }
        return number.substring(0, length - accuracy) + "." + number.substring(length - accuracy)
    }
    fun setAccuracy(accuracy: Int) : TPNumber {
        this.accuracy = accuracy
        return this
    }
    constructor(number: String = "0", system: Int = 10, accuracy: Int = 0) {
        require(system in 2..16) { "неподходящаяя система счисления" }
        val arr = number.split('.')
        if (arr.size == 1)
        {
            this.number = number + "0".repeat(accuracy)
        } else {
            val fractional = arr[1].take(accuracy)
            this.number = arr[0] + fractional + "0".repeat(accuracy - fractional.length)
        }
        this.system = system
        this.accuracy = accuracy
    }

    operator fun plus(other: TPNumber): TPNumber {

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
        return TPNumber(result, system).setAccuracy(accuracy)

    }

    operator fun minus(other: TPNumber) : TPNumber {

        val maxLength = maxOf(number.length, other.number.length)
        val num1 = number.padStart(maxLength, '0')
        val num2 = other.number.padStart(maxLength, '0')

        var carry = 0
        var result = ""
        for (i in maxLength - 1 downTo 0) {
            var digit1 = charToDigit(num1[i]) - carry
            carry = 0
            var digit2 = charToDigit(num2[i])
            if (digit2 > digit1)
            {
                carry = 1
                digit1 += system
            }
            val sum = digit1 - digit2
            result = digitToChar(sum) + result
        }
        if (carry > 0) {
            result = digitToChar(carry) + result
        }
        return TPNumber(result, system).setAccuracy(accuracy)
    }
    operator fun times(other: TPNumber) : TPNumber {
        //val maxLength = maxOf(number.length, other.number.length)
        val num1 = number//.padStart(maxLength, '0')
        val num2 = other.number//.padStart(maxLength, '0')

        var carry = 0
        var result = ""
        val resArr = arrayOfNulls<TPNumber?>(num2.length)
        for (i in num2.length - 1 downTo 0) {
            for (j in num1.length - 1 downTo 0) {
                val digit1 = charToDigit(num1[j])
                val digit2 = charToDigit(num2[i])
                val sum = digit1 * digit2 + carry
                carry = sum / system
                result = digitToChar(sum % system) + result
            }
            if (carry > 0) {
                result = digitToChar(carry) + result
            }

            val ingexArr = (i-(num2.length-1))*(-1)
            resArr[ingexArr] = TPNumber(result + "0".repeat(ingexArr), system, 0)
            result = ""
        }
        var rez2 = resArr[0]
        for(i in 1 .. resArr.size-1)
        {
            rez2 = rez2!! + resArr[i]!!
        }

        return rez2!!.setAccuracy(accuracy*2)
    }
    //operator fun div(other: TPNumber) : TPNumber {
    //    TODO()
    //}


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
}