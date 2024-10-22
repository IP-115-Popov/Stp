package laba6

import laba5.TPNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TEditorTest
{
    @Nested
    inner class ConstructorTests {
        @Test
        fun `Constructor 1_1+1_1i`() {
            // arrange
            val expected = "1.1 1.1"
            // act
            val tEditor =  TEditor("1.1+1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor 1_1-1_1i`() {
            // arrange
            val expected = "1.1 -1.1"
            // act
            val tEditor =  TEditor("1.1-1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor -1_1+1_1i`() {
            // arrange
            val expected = "-1.1 1.1"
            // act
            val tEditor =  TEditor("-1.1+1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor -1_1-1_1i`() {
            // arrange
            val expected = "-1.1 -1.1"
            // act
            val tEditor =  TEditor("-1.1-1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }

    }
    @Nested
    inner class IsZeroTests {
        @Test
        fun `isZero 1+1i`() {
            // arrange
            val expected = false
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.isZero()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `isZero 0+0i`() {
            // arrange
            val expected = true
            // act
            val tEditor =  TEditor("0+0i")
            val actual = tEditor.isZero()
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class addMinusTests{
        @Test
        fun addMinus() {
            // arrange
            val expected = "-1.0-1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addMinus()
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class addDigitTests{
        @Test
        fun addDigitReal() {
            // arrange
            val expected = "-1.0-1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addDigit(1,TEditor.Mode.real)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginary() {
            // arrange
            val expected = "-1.0-1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addDigit(1,TEditor.Mode.imaginary)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class addZeroTests{

    }
    @Nested
    inner class deleteDigitRightTests{

    }
    @Nested
    inner class clearTests{

    }
    @Nested
    inner class editTests{

    }
    @Nested
    inner class getNumderTests{

    }
    @Nested
    inner class setStringTests{

    }
}