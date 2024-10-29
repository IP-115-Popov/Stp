package laba6

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import kotlin.test.Test

class TEditorStringTest {
    @Nested
    inner class ConstructorTests {
        @Test
        fun `Constructor 1_1+1_1i`() {
            // arrange
            val expected = "1.1+1.1i"
            // act
            val tEditorString =  TEditorString("1.1+1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor 1_1-1_1i`() {
            // arrange
            val expected = "1.1-1.1i"
            // act
            val tEditorString =  TEditorString("1.1-1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor -1_1+1_1i`() {
            // arrange
            val expected = "-1.1+1.1i"
            // act
            val tEditorString =  TEditorString("-1.1+1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor -1_1-1_1i`() {
            // arrange
            val expected = "-1.1-1.1i"
            // act
            val tEditorString =  TEditorString("-1.1-1.1i")
            val actual = tEditorString.getNumder()
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
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.isZero()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `isZero 0+0i`() {
            // arrange
            val expected = true
            // act
            val tEditorString =  TEditorString("0+0i")
            val actual = tEditorString.isZero()
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class addMinusTests{
        @Test
        fun addMinusReal() {
            // arrange
            val expected = "-1+1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addMinus(TEditorString.Mode.real)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addMinusImaginary() {
            // arrange
            val expected = "1-1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addMinus(TEditorString.Mode.imaginary)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class addDigitTests{
        @Test
        fun addDigitRealInteger() {
            // arrange
            val expected = "21+1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.real, TEditorString.Part.integer, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryInteger() {
            // arrange
            val expected = "1+21i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.imaginary, TEditorString.Part.integer, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addDigitRealImaginary() {
            // arrange
            val expected = "1.21+1i"
            // act
            val tEditorString =  TEditorString("1.1+1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.real, TEditorString.Part.imaginary, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryImaginary() {
            // arrange
            val expected = "1+1.21i"
            // act
            val tEditorString =  TEditorString("1+1.1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.imaginary, TEditorString.Part.imaginary, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }



        @Test
        fun addDigitRealIntegerEnd() {
            // arrange
            val expected = "12+1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.real, TEditorString.Part.integer, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryIntegerEnd() {
            // arrange
            val expected = "1+12i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.imaginary, TEditorString.Part.integer, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addDigitRealImaginaryEnd() {
            // arrange
            val expected = "1.12+1i"
            // act
            val tEditorString =  TEditorString("1.1+1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.real, TEditorString.Part.imaginary, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addDigitImaginaryImaginaryEnd() {
            // arrange
            val expected = "1+1.12i"
            // act
            val tEditorString =  TEditorString("1+1.1i")
            val actual = tEditorString.addDigit(2,TEditorString.Mode.imaginary, TEditorString.Part.imaginary, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }

    }
    @Nested
    inner class addZeroTests{
        @Test
        fun addZeroRealInteger() {
            // arrange
            val expected = "01+1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addZero(TEditorString.Mode.real, TEditorString.Part.integer, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryInteger() {
            // arrange
            val expected = "1+01i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addZero(TEditorString.Mode.imaginary, TEditorString.Part.integer, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addZeroRealImaginary() {
            // arrange
            val expected = "1.01+1i"
            // act
            val tEditorString =  TEditorString("1.1+1i")
            val actual = tEditorString.addZero(TEditorString.Mode.real, TEditorString.Part.imaginary, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryImaginary() {
            // arrange
            val expected = "1+1.01i"
            // act
            val tEditorString =  TEditorString("1+1.1i")
            val actual = tEditorString.addZero(TEditorString.Mode.imaginary, TEditorString.Part.imaginary, TEditorString.Position.Start)
            // assert
            assertEquals(expected, actual)
        }



        @Test
        fun addZeroRealIntegerEnd() {
            // arrange
            val expected = "10+1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addZero(TEditorString.Mode.real, TEditorString.Part.integer, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryIntegerEnd() {
            // arrange
            val expected = "1+10i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.addZero(TEditorString.Mode.imaginary, TEditorString.Part.integer, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }

        @Test
        fun addZeroRealImaginaryEnd() {
            // arrange
            val expected = "1.10+1i"
            // act
            val tEditorString =  TEditorString("1.1+1i")
            val actual = tEditorString.addZero(TEditorString.Mode.real, TEditorString.Part.imaginary, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun addZeroImaginaryImaginaryEnd() {
            // arrange
            val expected = "1+1.10i"
            // act
            val tEditorString =  TEditorString("1+1.1i")
            val actual = tEditorString.addZero(TEditorString.Mode.imaginary, TEditorString.Part.imaginary, TEditorString.Position.End)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class deleteDigitRightTests{
        @Test
        fun deleteDigitRight() {
            // arrange
            val expected = "1+1i"
            // act
            val tEditorString =  TEditorString("11+1i")
            val actual = tEditorString.deleteDigitRight(TEditorString.Mode.real, TEditorString.Part.integer)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight2() {
            // arrange
            val expected = "1+1i"
            // act
            val tEditorString =  TEditorString("11+1i")
            val actual = tEditorString.deleteDigitRight(TEditorString.Mode.real, TEditorString.Part.integer)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight3() {
            // arrange
            val expected = "1+1i"
            // act
            val tEditorString =  TEditorString("1+11i")
            val actual = tEditorString.deleteDigitRight(TEditorString.Mode.imaginary, TEditorString.Part.integer)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight4() {
            // arrange
            val expected = "1.1+1i"
            // act
            val tEditorString =  TEditorString("1.11+1i")
            val actual = tEditorString.deleteDigitRight(TEditorString.Mode.real, TEditorString.Part.imaginary)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun deleteDigitRight5() {
            // arrange
            val expected = "1+1.1i"
            // act
            val tEditorString =  TEditorString("1+1.11i")
            val actual = tEditorString.deleteDigitRight(TEditorString.Mode.imaginary, TEditorString.Part.imaginary)
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
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.clear()
            // assert
            assertEquals(expected, actual)
        }

    }
    @Nested
    inner class editTests{
        @Test
        fun `edit 0`() {
            // arrange
            val expected = "-1.1+1.1i"
            // act
            val tEditorString =  TEditorString("1.1+1.1i")
            val actual = tEditorString.edit(0)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `edit 1`() {
            // arrange
            val expected = "11.1+1.1i"
            // act
            val tEditorString =  TEditorString("1.1+1.1i")
            val actual = tEditorString.edit(1)
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `edit default`() {
            // arrange
            val expected = "0.0+0.0i"
            // act
            val tEditorString =  TEditorString("1.1+1.1i")
            val actual = tEditorString.edit(-1)
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class getNumderTests{
        @Test
        fun getNumder() {
            // arrange
            val expected = "1+1i"
            // act
            val tEditorString =  TEditorString("1+1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun getNumder2() {
            // arrange
            val expected = "1-1i"
            // act
            val tEditorString =  TEditorString("1-1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
    }
    @Nested
    inner class setStringTests{
        @Test
        fun `Constructor 1_1+1_1i`() {
            // arrange
            val expected = "1.1+1.1i"
            // act
            val tEditorString =  TEditorString("")
            tEditorString.setString( "1.1+1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor 1_1-1_1i`() {
            // arrange
            val expected = "1.1-1.1i"
            // act
            val tEditorString =  TEditorString("")
            tEditorString.setString("1.1-1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor -1_1+1_1i`() {
            // arrange
            val expected = "-1.1+1.1i"
            // act
            val tEditorString =  TEditorString("")
            tEditorString.setString("-1.1+1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
        @Test
        fun `Constructor -1_1-1_1i`() {
            // arrange
            val expected = "-1.1-1.1i"
            // act
            val tEditorString =  TEditorString("")
            tEditorString.setString("-1.1-1.1i")
            val actual = tEditorString.getNumder()
            // assert
            assertEquals(expected, actual)
        }
    }
}