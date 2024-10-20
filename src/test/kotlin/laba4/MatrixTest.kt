package laba4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MatrixTest {

    @Test
    fun `constructor`() {
        // arrange
        val matrix = arrayOf(
            arrayOf(1,2,3),
            arrayOf(1,2,3)
        )

        // act
        val expected = arrayOf(
            arrayOf(1,2,3),
            arrayOf(1,2,3)
        )
        // assert
        assertTrue(expected.contentEquals(matrix))
    }
}