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
        fun addDigitRealInteger() {
            // arrange
            val expected = "21.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.real, TEditor.Part.integer, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryInteger() {
            // arrange
            val expected = "1.0+21.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.imaginary, TEditor.Part.integer, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addDigitRealImaginary() {
            // arrange
            val expected = "1.21+1.0i"
            // act
            val tEditor =  TEditor("1.1+1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.real, TEditor.Part.imaginary, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryImaginary() {
            // arrange
            val expected = "1.0+1.21i"
            // act
            val tEditor =  TEditor("1+1.1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.imaginary, TEditor.Part.imaginary, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }



        @Test
        fun addDigitRealIntegerEnd() {
            // arrange
            val expected = "12.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.real, TEditor.Part.integer, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryIntegerEnd() {
            // arrange
            val expected = "1.0+12.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.imaginary, TEditor.Part.integer, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addDigitRealImaginaryEnd() {
            // arrange
            val expected = "1.12+1.0i"
            // act
            val tEditor =  TEditor("1.1+1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.real, TEditor.Part.imaginary, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryImaginaryEnd() {
            // arrange
            val expected = "1.0+1.12i"
            // act
            val tEditor =  TEditor("1+1.1i")
            val actual = tEditor.addDigit(2,TEditor.Mode.imaginary, TEditor.Part.imaginary, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }

    }
    @Nested
    inner class addZeroTests{
        @Test
        fun addZeroRealInteger() {
            // arrange
            val expected = "1.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addZero(TEditor.Mode.real, TEditor.Part.integer, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryInteger() {
            // arrange
            val expected = "1.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addZero(TEditor.Mode.imaginary, TEditor.Part.integer, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addZeroRealImaginary() {
            // arrange
            val expected = "1.01+1.0i"
            // act
            val tEditor =  TEditor("1.1+1i")
            val actual = tEditor.addZero(TEditor.Mode.real, TEditor.Part.imaginary, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryImaginary() {
            // arrange
            val expected = "1.0+1.01i"
            // act
            val tEditor =  TEditor("1+1.1i")
            val actual = tEditor.addZero(TEditor.Mode.imaginary, TEditor.Part.imaginary, TEditor.Position.Start)
            // assert
            assertEquals(expected, actual)
        }



        @Test
        fun addZeroRealIntegerEnd() {
            // arrange
            val expected = "10.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addZero(TEditor.Mode.real, TEditor.Part.integer, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryIntegerEnd() {
            // arrange
            val expected = "1.0+10.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.addZero(TEditor.Mode.imaginary, TEditor.Part.integer, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addZeroRealImaginaryEnd() {
            // arrange
            val expected = "1.1+1.0i"
            // act
            val tEditor =  TEditor("1.1+1i")
            val actual = tEditor.addZero(TEditor.Mode.real, TEditor.Part.imaginary, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryImaginaryEnd() {
            // arrange
            val expected = "1.0+1.1i"
            // act
            val tEditor =  TEditor("1+1.1i")
            val actual = tEditor.addZero(TEditor.Mode.imaginary, TEditor.Part.imaginary, TEditor.Position.End)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class deleteDigitRightTests{
        @Test
        fun deleteDigitRight() {
            // arrange
            val expected = "0.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.deleteDigitRight(TEditor.Mode.real, TEditor.Part.integer)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight2() {
            // arrange
            val expected = "1.0+1.0i"
            // act
            val tEditor =  TEditor("11+1i")
            val actual = tEditor.deleteDigitRight(TEditor.Mode.real, TEditor.Part.integer)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight3() {
            // arrange
            val expected = "1.0+1.0i"
            // act
            val tEditor =  TEditor("1+11i")
            val actual = tEditor.deleteDigitRight(TEditor.Mode.imaginary, TEditor.Part.integer)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight4() {
            // arrange
            val expected = "1.1+1.0i"
            // act
            val tEditor =  TEditor("1.11+1i")
            val actual = tEditor.deleteDigitRight(TEditor.Mode.real, TEditor.Part.imaginary)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight5() {
            // arrange
            val expected = "1.0+1.1i"
            // act
            val tEditor =  TEditor("1+1.11i")
            val actual = tEditor.deleteDigitRight(TEditor.Mode.imaginary, TEditor.Part.imaginary)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class clearTests{
        @Test
        fun clear() {
            // arrange
            val expected = "0.0+0.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.clear()
            // assert
            assertEquals(expected, actual)
        }

    }
    @Nested
    inner class editTests{
        @Test
        fun `edit 0`() {
            // arrange
            val expected = "-1.1-1.1i"
            // act
            val tEditor =  TEditor("1.1+1.1i")
            val actual = tEditor.edit(0)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `edit 1`() {
            // arrange
            val expected = "11.1+1.1i"
            // act
            val tEditor =  TEditor("1.1+1.1i")
            val actual = tEditor.edit(1)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `edit default`() {
            // arrange
            val expected = "0.0+0.0i"
            // act
            val tEditor =  TEditor("1.1+1.1i")
            val actual = tEditor.edit(-1)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class getNumderTests{
        @Test
        fun getNumder() {
            // arrange
            val expected = "1.0+1.0i"
            // act
            val tEditor =  TEditor("1+1i")
            val actual = tEditor.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun getNumder2() {
            // arrange
            val expected = "1.0-1.0i"
            // act
            val tEditor =  TEditor("1-1i")
            val actual = tEditor.getNumder()
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class setStringTests{
        @Test
        fun `setString 1_1+1_1i`() {
            // arrange
            val expected = "1.1 1.1"
            // act
            val tEditor =  TEditor("0.1+0.1i")
            tEditor.setString("1.1+1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `setString 1_1-1_1i`() {
            // arrange
            val expected = "1.1 -1.1"
            // act
            val tEditor =  TEditor("0.1-0.1i")
            tEditor.setString("1.1-1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `setString -1_1+1_1i`() {
            // arrange
            val expected = "-1.1 1.1"
            // act
            val tEditor =  TEditor("-0.1+0.1i")
            tEditor.setString("-1.1+1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `setString -1_1-1_1i`() {
            // arrange
            val expected = "-1.1 -1.1"
            // act
            val tEditor =  TEditor("-0.1-0.1i")
            tEditor.setString("-1.1-1.1i")
            val actual = tEditor.a.toString() + " " + tEditor.b.toString()
            // assert
            assertEquals(expected, actual)
        }
    }
}