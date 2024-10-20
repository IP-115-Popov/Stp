package laba3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Laba3Test {
    val laba3 = Laba3()
    @Test
    fun max() {
        // arrange
        val a = 12345
        val b = 1
        val c = 2
        val expected = 12345
        // act
        val actual = laba3.max(a,b,c)
        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun getEvenDigitsBackToFront() {
        // arrange
        val a = 12345
        val expected = 42
        // act
        val actual = laba3.getEvenDigitsBackToFront(a)
        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun getMinDigit() {
        // arrange
        val a = 12345
        val expected = 1
        // act
        val actual = laba3.getMinDigit(a)
        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun sumOddBelowMainDiagonal(){
        // arrange
        val a = arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(1,2,3),
            intArrayOf(1,2,3),
        )
        val expected = 2
        // act
        val actual = laba3.sumOddBelowMainDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `sumOddBelowMainDiagonal empty`(){
        // arrange
        val a = arrayOf(
            intArrayOf()
        )
        val expected = null
        // act
        val actual = laba3.sumOddBelowMainDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `sumOddBelowMainDiagonal arrayOf DoubleArray`(){
        // arrange
        val a = arrayOf<IntArray>()
        val expected = null
        // act
        val actual = laba3.sumOddBelowMainDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
}