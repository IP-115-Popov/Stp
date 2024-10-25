package laba4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows

class MatrixTest {
    @Nested
    inner class ConstructorTests {
        @Test
        fun `constructor`() {
            // arrange
            val expected = arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(1, 2, 3)
            )
            // act
            val actual = Matrix(expected).matrix
            // assert
            assertTrue(expected.contentEquals(actual))
        }

        @Test
        fun `constructor throws exception for empty matrix`() {
            val emptyMatrix = arrayOf<Array<Int>>()
            assertThrows<IllegalArgumentException> {
                Matrix(emptyMatrix)
            }
        }
    }
    @Nested
    inner class PlusTests {
        @Test
        fun `plus throws exception for matrices with different number of rows`() {
            val matrix1 = arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            )
            val matrix2 = arrayOf(
                arrayOf(7, 8, 9)
            )
            assertThrows<IllegalArgumentException> {
                Matrix(matrix1) + Matrix(matrix2)
            }
        }

        @Test
        fun `plus throws exception for matrices with different number of columns`() {
            val matrix1 = arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            )
            val matrix2 = arrayOf(
                arrayOf(7, 8),
                arrayOf(9, 10)
            )
            assertThrows<IllegalArgumentException> {
                Matrix(matrix1) + Matrix(matrix2)
            }
        }

        @Test
        fun `plus returns correct result for valid matrices`() {
            val matrix1 = arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            )
            val matrix2 = arrayOf(
                arrayOf(7, 8, 9),
                arrayOf(10, 11, 12)
            )
            val expectedMatrix = arrayOf(
                arrayOf(8, 10, 12),
                arrayOf(14, 16, 18)
            )
            val result = Matrix(matrix1) + Matrix(matrix2)
            assertTrue(result.matrix.contentEquals(expectedMatrix))
        }
    }
    @Nested
    inner class MinusTest {
        @Test
        fun `minus - matrices with same size`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(9, 8, 7),
                arrayOf(6, 5, 4),
                arrayOf(3, 2, 1)
            ))

            val expected = Matrix(arrayOf(
                arrayOf(-8, -6, -4),
                arrayOf(-2, 0, 2),
                arrayOf(4, 6, 8)
            ))

            val result = matrix1 - matrix2

            assert(result.matrix.contentDeepEquals(expected.matrix))
        }

        @Test
        fun `minus - matrices with different number of rows`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(9, 8, 7),
                arrayOf(6, 5, 4),
                arrayOf(3, 2, 1)
            ))

            assertThrows<IllegalArgumentException> {
                matrix1 - matrix2
            }
        }

        @Test
        fun `minus - matrices with different number of columns`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(9, 8),
                arrayOf(6, 5),
                arrayOf(3, 2)
            ))

            assertThrows<IllegalArgumentException> {
                matrix1 - matrix2
            }
        }
    }
    @Nested
    inner class TimesTest {
        @Test
        fun `times - matrices with compatible sizes`() {
            val matrix1 = Matrix(
                arrayOf(
                    arrayOf(1, 2, 3),
                    arrayOf(4, 5, 6)
                )
            )
            val matrix2 = Matrix(
                arrayOf(
                    arrayOf(7, 8),
                    arrayOf(9, 10),
                    arrayOf(11, 12)
                )
            )

            val expected = Matrix(
                arrayOf(
                    arrayOf(58, 64),
                    arrayOf(139, 154)
                )
            )

            val result = matrix1 * matrix2

            assert(result.matrix.contentDeepEquals(expected.matrix))
        }

        @Test
        fun `times - matrices with incompatible sizes`() {
            val matrix1 = Matrix(
                arrayOf(
                    arrayOf(1, 2, 3),
                    arrayOf(4, 5, 6)
                )
            )
            val matrix2 = Matrix(
                arrayOf(
                    arrayOf(7, 8, 9),
                    arrayOf(10, 11, 12)
                )
            )

            assertThrows<IllegalArgumentException> {
                matrix1 * matrix2
            }
        }
    }
    @Nested
    inner class EqualToTest {
        @Test
        fun `equalTo - matrices with same size and content`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))

            assert(matrix1.equalTo(matrix2))
        }

        @Test
        fun `equalTo - matrices with same size but different content`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(7, 8, 9),
                arrayOf(10, 11, 12)
            ))

            assert(!matrix1.equalTo(matrix2))
        }

        @Test
        fun `equalTo - matrices with different number of rows`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(1, 2, 3)
            ))

            assertThrows<IllegalArgumentException> {
                matrix1.equalTo(matrix2)
            }
        }
        @Test
        fun `equalTo - throw 2`() {
            val matrix1 = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val matrix2 = Matrix(arrayOf(
                arrayOf(1, 2),
                arrayOf(4, 5)
            ))

            assertThrows<IllegalArgumentException> {
                matrix1.equalTo(matrix2)
            }
        }
    }
    @Nested
    inner class TranspTest {
        @Test
        fun `transp - square matrix`() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 9)
            ))

            val expected = Matrix(arrayOf(
                arrayOf(1, 4, 7),
                arrayOf(2, 5, 8),
                arrayOf(3, 6, 9)
            ))

            val result = matrix.transp()

            assert(result.matrix.contentDeepEquals(expected.matrix))
        }

        @Test
        fun `transp - non-square matrix`() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))

            assertThrows<IllegalArgumentException> {
                matrix.transp()
            }
        }
    }
    @Nested
    inner class MinTest {
        @Test
        fun `transp - square matrix`() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6),
                arrayOf(7, 8, 0)
            ))

            val expected = 0

            val result = matrix.min()

            assertEquals(expected, result)
        }
    }
    @Nested
    inner class ToStringTest {
        @Test
        fun `ToString - matrix with multiple rows and columns`() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val expected = "1 2 3 \n4 5 6 \n"
            val result = matrix.ToString()
            assertEquals(expected, result)
        }
    }
    @Nested
    inner class GetOrNullTest {
        @Test
        fun getOrNull() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val expected = 1
            val result = matrix.GetOrNull(0,0)
            assertEquals(expected, result)
        }
        @Test
        fun getOrNull1() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val expected = null
            val result = matrix.GetOrNull(-1,0)
            assertEquals(expected, result)
        }
        @Test
        fun getOrNullnull() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2, 3),
                arrayOf(4, 5, 6)
            ))
            val expected = null
            val result = matrix.GetOrNull(100,0)
            assertEquals(expected, result)
        }
    }

    @Nested
    inner class getnumberOfRowsTest {
        @Test
        fun getnumberOfRows() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2),
                arrayOf(4, 5)
            ))
            val expected = 2
            val result = matrix.getnumberOfRows()
            assertEquals(expected, result)
        }
    }
    @Nested
    inner class getnumberOfColumnsTest {
        @Test
        fun getnumberOfColumns() {
            val matrix = Matrix(arrayOf(
                arrayOf(1, 2),
                arrayOf(4, 5)
            ))
            val expected = 2
            val result = matrix.getnumberOfColumns()
            assertEquals(expected, result)
        }
    }

    fun <T> Array<Array<T>>.contentEquals(other: Array<Array<T>>): Boolean {
        if (this.size != other.size) return false
        for (i in this.indices) {
            if (!this[i].contentEquals(other[i])) return false
        }
        return true
    }
}