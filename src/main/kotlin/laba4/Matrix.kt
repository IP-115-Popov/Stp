package laba4

import com.sun.org.apache.xpath.internal.operations.Plus

class Matrix  {
    lateinit var matrix : Array<Array<Int>>
    constructor(matrix : Array<Array<Int>>) {
        if (matrix.size > 0 && matrix[0].size > 0)
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
        require(matrix[0].size == matrix2.matrix.size) { "Количество столбцов первой матрицы должно равняться количеству строк второй матрицы" }

        val result :  Matrix = Matrix(matrix.clone())
        for (i in matrix.indices) {
            for (j in matrix2.matrix[0].indices) {
                for (k in 0 until matrix2.matrix.size) {
                    result.matrix[i][j] += matrix[i][k] * matrix2.matrix[k][j]
                }
            }
        }
        return result
    }
    fun equalTo(matrix2: Matrix): Boolean {
        require(matrix.size == matrix2.matrix.size) { "Матрицы должны иметь одинаковое количество строк" }
        require(matrix[0].size == matrix2.matrix[0].size) { "Матрицы должны иметь одинаковое количество столбцов" }
        return matrix.toString() == matrix2.toString()
    }
    fun transp() : Matrix  {
        require(matrix.size == matrix[0].size) { "Матрица должна быть квадратной" }

        val result :  Matrix = Matrix(matrix.clone())
        for (i in matrix.indices) {
            for (j in matrix.indices) {
                result.matrix[j][i] = matrix[i][j]
            }
        }
        return result

    }

    fun min() : Int {
        return matrix.flatMap { it.asIterable() }.minBy { it }
    }

    override fun toString(): String {
        return super.toString()
    }
    fun getOrNull(line: Int, i : Int) : Int {
        require(line > matrix.size || i > matrix[0].size)
        return matrix[line][i]
    }
    fun getnumberOfRows() : Int = matrix.size

    fun getnumberOfColumns() : Int = matrix[0].size
}