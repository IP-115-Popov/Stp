import laba9.TMember
import laba9.TPoly
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TPolyTest {

    @Nested
    inner class DegreeTests {
        @Test
        fun `Degree returns correct degree for non-empty polynomial`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, 1))
            assertEquals(3, poly.Degree())
        }

        @Test
        fun `Degree returns 0 for empty polynomial`() {
            val poly = TPoly(0.0, 0)
            assertEquals(0, poly.Degree())
        }

        @Test
        fun `Degree handles negative degrees correctly`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, -1)) //Negative degree
            assertEquals(3, poly.Degree())
        }

    }

    @Nested
    inner class RatioTests {
        @Test
        fun `Ratio returns correct ratio for existing degree`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, 1))
            assertEquals(1.0, poly.Ratio(1))
        }

        @Test
        fun `Ratio returns 0 for non-existing degree`() {
            val poly = TPoly(2.0, 3)
            assertEquals(0.0, poly.Ratio(1))
        }
        @Test
        fun `Ratio throws exception for zero polynomial`() {
            val poly = TPoly(0.0, 0)
            assertThrows<IllegalArgumentException> { poly.Ratio(0) }
        }
    }


    @Nested
    inner class ClearTests {
        @Test
        fun `Clear clears the polynomial`() {
            val poly = TPoly(2.0, 3)
            poly.Clear()
            assertTrue(poly.poly.isEmpty())
        }
    }


    @Nested
    inner class PlusOperatorTests {
        @Test
        fun `plus operator adds polynomials correctly`() {
            val poly1 = TPoly(2.0, 3)
            poly1.poly.add(TMember(1.0, 1))
            val poly2 = TPoly(3.0, 2)
            poly2.poly.add(TMember(2.0, 1))

            val sum = poly1 + poly2

            val rez = listOf(TMember(3.0, 1), TMember(3.0, 2), TMember(2.0, 3)).toSet()
            assertEquals(rez, sum.poly.toSet())

        }

        @Test
        fun `plus operator handles empty polynomials correctly`() {
            val poly1 = TPoly(2.0, 3)
            val poly2 = TPoly(0.0, 0)
            poly2.Clear()
            val sum = poly1 + poly2
            assertEquals(listOf(TMember(2.0, 3)), sum.poly)
        }
    }


    @Nested
    inner class MinusOperatorTests {
        @Test
        fun `minus operator subtracts polynomials correctly`() {
            val poly1 = TPoly(2.0, 3)
            poly1.poly.add(TMember(1.0, 1))
            val poly2 = TPoly(3.0, 2)
            poly2.poly.add(TMember(2.0, 1))

            val diff = poly1 - poly2


            assertEquals(listOf(TMember(-1.0, 1), TMember(-3.0, 2), TMember(2.0, 3)).toSet(), diff.poly.toSet())
        }
    }

    @Nested
    inner class TimesOperatorTests {
        @Test
        fun `times operator multiplies polynomials correctly`() {
            val poly1 = TPoly(2.0, 1)
            val poly2 = TPoly(3.0, 2)
            val product = poly1 * poly2
            assertEquals(listOf(TMember(6.0, 3)), product.poly)
        }
        @Test
        fun `times operator handles complex polynomials`(){
            val poly1 = TPoly(2.0,2)
            poly1.poly.add(TMember(1.0,1))
            val poly2 = TPoly(3.0,1)
            poly2.poly.add(TMember(1.0,0))
            val product = poly1 * poly2










            assertEquals(listOf(TMember(6.0,3),TMember(2.0,2),TMember(3.0,2), TMember(1.0,1)).toSet(), product.poly.toSet())
        }

    }

    @Nested
    inner class TimesMinusTests {
        @Test
        fun `timesMinus negates the polynomial`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, 1))
            val negatedPoly = poly.timesMinus()
            assertEquals(listOf(TMember(-2.0, 3), TMember(-1.0, 1)), negatedPoly.poly)
        }
    }

    @Nested
    inner class EquallyTests {
        @Test
        fun `equally returns true for equal polynomials`() {
            val poly1 = TPoly(2.0, 3)
            poly1.poly.add(TMember(1.0, 1))
            val poly2 = TPoly(2.0, 3)
            poly2.poly.add(TMember(1.0, 1))
            assertTrue(poly1.equally(poly2))
        }
        @Test
        fun `equally returns false for unequal polynomials`() {
            val poly1 = TPoly(2.0, 3)
            poly1.poly.add(TMember(1.0, 1))
            val poly2 = TPoly(2.0, 3)
            poly2.poly.add(TMember(2.0, 1))
            assertFalse(poly1.equally(poly2))
        }
    }

    @Nested
    inner class DifferentiateTests {
        @Test
        fun `Differentiate returns correct derivative`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, 1))
            val derivative = poly.Differentiate()
            assertEquals(listOf(TMember(6.0, 2), TMember(1.0, 0)), derivative.poly)
        }
    }

    @Nested
    inner class CalculateTests {
        @Test
        fun `Calculate returns correct value`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, 1))
            val result = poly.Calculate(2.0)
            assertEquals(18.0, result)
        }
    }

    @Nested
    inner class ElementTests {
        @Test
        fun `Element returns correct element`() {
            val poly = TPoly(2.0, 3)
            poly.poly.add(TMember(1.0, 1))
            assertEquals(TMember(1.0, 1), poly.Element(1))
        }
        @Test
        fun `Element throws exception for out of bounds index`() {
            val poly = TPoly(2.0, 3)
            assertThrows<IndexOutOfBoundsException> { poly.Element(1) }
        }
    }
}
