package laba4

import com.sun.org.apache.xpath.internal.operations.Plus

class Matrix  {
    lateinit var matrix : Array<Array<Int>>
    constructor(matrix : Array<Array<Int>>) {
        require(matrix.size > 0 && matrix[0].size > 0) {"Число строк и столбцов должно быть больше 0"}
        this.matrix = matrix
    }

    operator fun plus(matrix2 : Matrix): Matrix {
        require(matrix.size == matrix2.matrix.size) { "Матрицы должны иметь одинаковое количество строк" }
        require(matrix[0].size == matrix2.matrix[0].size) { "Матрицы должны иметь одинаковое количество столбцов" }

        val result :  Matrix = Matrix(matrix.clone())
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                result.matrix[i][j] = matrix[i][j] + matrix2.matrix[i][j]
            }
        }
        return result
    }
    operator fun minus(matrix2: Matrix): Matrix {
        require(matrix.size == matrix2.matrix.size) { "Матрицы должны иметь одинаковое количество строк" }
        require(matrix[0].size == matrix2.matrix[0].size) { "Матрицы должны иметь одинаковое количество столбцов" }

        val result :  Matrix = Matrix(matrix.clone())
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                result.matrix[i][j] = matrix[i][j] - matrix2.matrix[i][j]
            }
        }
        return result
    }
    operator fun times(matrix2: Matrix): Matrix {
        require(matrix[0].size == matrix2.matrix.size) {
            "Количество столбцов первой матрицы должно равняться количеству строк второй матрицы"
        }

        val result = Array(matrix.size) { Array(matrix2.matrix[0].size){0} }
        for (i in matrix.indices) {
            for (j in matrix2.matrix[0].indices) {
                for (k in 0 until matrix2.matrix.size) {
                    result[i][j] += matrix[i][k] * matrix2.matrix[k][j]
                }
            }
        }
        return Matrix(result)
    }
    fun equalTo(matrix2: Matrix): Boolean {
        require(matrix.size == matrix2.matrix.size) { "Матрицы должны иметь одинаковое количество строк" }
        require(matrix[0].size == matrix2.matrix[0].size) { "Матрицы должны иметь одинаковое количество столбцов" }
        var rez = ""
        for (i in 0 until  matrix.size) {
            for (j in 0 until  matrix[0].size) {
                if (matrix[i][j] != matrix2.matrix[i][j])
                {
                    return false
                }
            }

        }
        return true
    }
    fun transp() : Matrix  {
        require(matrix.size == matrix[0].size) { "Матрица должна быть квадратной" }

        val arr = Array(matrix.size){Array(matrix[0].size){0} }
        val result = Matrix(arr)
        for (i in matrix.indices) {
            for (j in matrix.indices) {
                val a = matrix[j][i]
                result.matrix[i][j] = a
            }
        }
        return result
    }

    fun min() : Int {
        return matrix.flatMap { it.asIterable() }.minBy { it }
    }

    fun ToString(): String {
        var rez = ""
        for (i in 0 until  matrix.size) {
            for (j in 0 until  matrix[0].size) {
                rez += matrix[i][j].toString() + " "
            }
            rez += "\n"
        }
        return rez
    }
    fun GetOrNull(line: Int, i : Int) : Int? {
        if (line < 0 || i < 0) return null
        if(line > matrix.size || i > matrix[0].size)
            return null
        else
            return matrix[line][i]
    }
    fun getnumberOfRows() : Int = matrix.size

    fun getnumberOfColumns() : Int = matrix[0].size
}