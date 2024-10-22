package laba5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class TPNumberTest {

    @Nested
    inner class ConstructorTests {
        @Test
        fun `Constructor 11_11 2 3`() {
            val num1 = TPNumber("11.11", 2, 3)
            val rez = num1.getNumber()
            assertEquals(rez, "11.110")
        }

        @Test
        fun ` Constructor 11 2 3`() {
            val num1 = TPNumber("11", 2, 3)
            val rez = num1.getNumber()
            assertEquals(rez, "11.000")
        }
    }

    @Nested
    inner class GetNumberTests {
        @Test
        fun ` getNumber 11_11`() {
            val num1 = TPNumber("11.11", 2, 3)
            val result = num1.getNumber()
            assertEquals(result, "11.110")
        }
    }

    @Nested
    inner class PlusTests {
        @Test
        fun `plus integers`() {
            // arrange
            val num1 = TPNumber("101", 2, 3)
            val num2 = TPNumber("11", 2, 3)
            val expected = TPNumber("1000.000", 2, 3).getNumber()
            // act
            val a = num1 + num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `plus flat`() {
            // arrange
            val num1 = TPNumber("1.1", 2, 1)
            val num2 = TPNumber("1.1", 2, 1)
            val expected = TPNumber("11.0", 2, 1).getNumber()
            // act
            val a = num1 + num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `plus integers2`() {
            // arrange
            val num1 = TPNumber("102", 3, 3)
            val num2 = TPNumber("12", 3, 3)
            val expected = TPNumber("121.000", 3, 3).getNumber()
            // act
            val a = num1 + num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class MinusTests {
        @Test
        fun `Minus integers`() {
            // arrange
            val num1 = TPNumber("101", 2, 0)
            val num2 = TPNumber("11", 2, 0)
            val expected = TPNumber("010", 2, 0).getNumber()
            // act
            val a = num1 - num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun `Minus flat`() {
            // arrange
            val num1 = TPNumber("11.1", 2, 1)
            val num2 = TPNumber("1.1", 2, 1)
            val expected = TPNumber("10.0", 2, 1).getNumber()
            // act
            val a = num1 - num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun `Minus flat 3`() {
            // arrange
            val num1 = TPNumber("102", 3, 1)
            val num2 = TPNumber("12", 3, 1)
            val expected = TPNumber("020.0", 3, 1).getNumber()
            // act
            val a = num1 - num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class TimesTests {
        @Test
        fun `Times integers`() {
            // arrange
            val num1 = TPNumber("101", 2, 0)
            val num2 = TPNumber("11", 2, 0)
            val expected = TPNumber("1111", 2, 0).getNumber()
            // act
            val a = num1 * num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Times flat`() {
            // arrange
            val num1 = TPNumber("10.1", 2, 1)
            val num2 = TPNumber("1.1", 2, 1)
            val expected = TPNumber("11.11", 2, 2).getNumber()
            // act
            val a = num1 * num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Times flat 3`() {
            // arrange
            val num1 = TPNumber("12", 3, 1)
            val num2 = TPNumber("10", 3, 1)
            val expected = TPNumber("120.00", 3, 2).getNumber()
            // act
            val a = num1 * num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
    }

    @Nested
    inner class DivTests {
        @Test
        fun `Div integers`() {
            // arrange
            val num1 = TPNumber("1000", 2, 0)
            val num2 = TPNumber("10", 2, 0)
            val expected = TPNumber("100", 2, 0).getNumber()
            // act
            val a = num1 / num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)

        }
        @Test
        fun `Div float`() {
            // arrange
            val num1 = TPNumber("10", 2, 3)
            val num2 = TPNumber("100", 2, 3)
            val expected = TPNumber(".100000", 2, 6).getNumber()
            // act
            val a = num1 / num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Div float2`() {
            // arrange
            val num1 = TPNumber("10", 2, 1)
            val num2 = TPNumber("100", 2, 1)
            val expected = TPNumber(".10", 2, 2).getNumber()
            // act
            val a = num1 / num2
            val actual = a.getNumber()
            // assert
            assertEquals(expected, actual)
        }
    }
}