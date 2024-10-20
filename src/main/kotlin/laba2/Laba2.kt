package laba2

class Laba2 {
    fun max(a: Double, b: Double) = if (a > b) a else b
    fun  sumElementsOnSideDiagonal(matrix: Array<DoubleArray>) : Double?{
        if (matrix.isEmpty() || matrix[0].isEmpty()) return null
        var rez : Double = 0.0
        matrix.forEachIndexed{index, line ->
            rez += line[line.size -1 - index]
        }
        return rez
    }
    fun findMinAboveSecondaryDiagonal(matrix: Array<DoubleArray>): Double? {
        // Проверяем, что матрица не пустая
        if (matrix.isEmpty() || matrix[0].isEmpty()) return null

        val rows = matrix.size
        val cols = matrix[0].size

        // Инициализируем переменную для хранения минимального значения
        var rez: Double? = null

        // Проходим по элементам, находящимся на и выше побочной диагонали
        for (i in 0 until rows) {
            for (j in cols - 1 - i downTo 0) {
                // Проверяем текущий элемент
                val value = matrix[i][j]
                // Обновляем минимальное значение, если это необходимо
                if (rez == null || value < rez) {
                    rez = value
                }
            }
        }
        return rez
    }

}