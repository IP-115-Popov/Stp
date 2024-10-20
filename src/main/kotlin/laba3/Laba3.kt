package laba3

class Laba3 {
    fun max(a:Int, b:Int, c:Int): Int = listOf(a,b,c).max()

    fun getEvenDigitsBackToFront(a: Int) : Int {
        var rez : String = ""
        a.toString().reversed().forEachIndexed{index: Int, c: Char ->
            if (index %2 == 1) rez += c
        }
        return rez.toInt()
    }
    fun getMinDigit(a: Int): Int {
        val minDigitChar = a.toString().minOrNull()
        return minDigitChar?.digitToInt() ?: -1
    }
    fun sumOddBelowMainDiagonal(matrix: Array<IntArray>): Int? {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return null
        var sum = 0

        for (i in matrix.indices) {
            for (j in 0 until i) { // j идет до i, чтобы находиться ниже главной диагонали
                if (matrix[i][j] % 2 != 0) { // проверка от четности
                    sum += matrix[i][j]
                }
            }
        }

        return sum
    }
}