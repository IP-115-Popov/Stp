package laba2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Laba2Test {
    val laba2 = Laba2()
    @Test
    fun `max 2 1`() {
        // arrange
        val a = 2.0
        val b = 1.0
        val expected = 2.0
        // act
        val actual = laba2.max(a,b)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `max 1 2`() {
        // arrange
        val a = 1.0
        val b = 2.0
        val expected = 2.0
        // act
        val actual = laba2.max(a,b)
        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `sum Elements On Side Diagonal full`() {
        // arrange
        val a = arrayOf(
            doubleArrayOf(1.0,2.0,3.0),
            doubleArrayOf(1.0,2.0,3.0),
            doubleArrayOf(1.0,2.0,3.0))
        val expected = 6.0
        // act
        val actual = laba2.sumElementsOnSideDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `sum Elements On Side Diagonal empty`() {
        // arrange
        val a = arrayOf(doubleArrayOf())
        val expected = null
        // act
        val actual = laba2.sumElementsOnSideDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `sum Elements On Side Diagonal arrayOf DoubleArray`() {
        // arrange
        val a = arrayOf<DoubleArray>()
        val expected = null
        // act
        val actual = laba2.sumElementsOnSideDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `findMinAboveSecondaryDiagonal matrix empty`() {
        // arrange
        val a = arrayOf(doubleArrayOf())
        val expected = null
        // act
        val actual = laba2.findMinAboveSecondaryDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `findMinAboveSecondaryDiagonal matrix arrayOf DoubleArray`() {
        // arrange
        val a = arrayOf<DoubleArray>()
        val expected = null
        // act
        val actual = laba2.findMinAboveSecondaryDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `findMinAboveSecondaryDiagonal matrix full`() {
        // arrange
        val a = arrayOf(
            doubleArrayOf(1.0,2.0,3.0),
            doubleArrayOf(1.0,2.0,3.0),
            doubleArrayOf(1.0,2.0,3.0))
        val expected = 1.0
        // act
        val actual = laba2.findMinAboveSecondaryDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `findMinAboveSecondaryDiagonal matrix full 2`() {
        // arrange
        val a = arrayOf(
            doubleArrayOf(9.0,0.0,3.0),
            doubleArrayOf(9.0,2.0,3.0),
            doubleArrayOf(1.0,2.0,3.0))
        val expected = 0.0
        // act
        val actual = laba2.findMinAboveSecondaryDiagonal(a)
        // assert
        assertEquals(expected, actual)
    }
}