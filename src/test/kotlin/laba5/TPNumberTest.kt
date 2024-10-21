package laba5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TPNumberTest {

    @Test
    fun copy() {

    }

    @Test
    fun plus() {
        // arrange
        val num1 = TPNumber("101", 2)
        val num2 = TPNumber("11", 2)
        val expected = TPNumber("1000",2)
        // act
        val actual = num1 + num2
        // assert
        assertEquals(expected.number, actual.number)
    }

    @Test
    fun testToString() {
    }
}