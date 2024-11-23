package laba9

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.pow

class TMemberTest {

    @Nested
    inner class ReadDegreeTests {
        @Test
        fun `readDegree returns correct degree`() {
            val member = TMember(2.0, 3)
            assertEquals(3, member.readDegree())
        }
    }

    @Nested
    inner class WriteDegreeTests {
        @Test
        fun `writeDegree updates degree correctly`() {
            val member = TMember(2.0, 3)
            member.writeDegree(5)
            assertEquals(5, member.n)
        }
    }

    @Nested
    inner class WriteRatioTests {
        @Test
        fun `writeRatio updates ratio correctly`() {
            val member = TMember(2.0, 3)
            member.writeRatio(4.0)
            assertEquals(4.0, member.c)
        }

    }


    @Nested
    inner class EquallyTests {
        @Test
        fun `equally returns true for equal members`() {
            val member1 = TMember(2.0, 3)
            val member2 = TMember(2.0, 3)
            assertTrue(member1.equally(member2))
        }

        @Test
        fun `equally returns false for unequal members`() {
            val member1 = TMember(2.0, 3)
            val member2 = TMember(3.0, 3)
            assertFalse(member1.equally(member2))

            val member3 = TMember(2.0, 4)
            assertFalse(member1.equally(member3))

        }
        @Test
        fun `equally handles zero correctly`() {
            val member1 = TMember(0.0, 3)
            val member2 = TMember(0.0, 3)
            assertTrue(member1.equally(member2))

        }
    }


    @Nested
    inner class DifferentiateTests {
        @Test
        fun `Differentiate returns correct derivative`() {
            val member = TMember(2.0, 3)
            val derivative = member.Differentiate()
            assertEquals(TMember(6.0, 2), derivative)
        }

        @Test
        fun `Differentiate handles degree 0 correctly`() {
            val member = TMember(2.0, 0)
            val derivative = member.Differentiate()
            assertEquals(TMember(0.0, -1), derivative) //The result is correct mathematically, even if the degree is negative.
        }
    }

    @Nested
    inner class CalculateTests {
        @Test
        fun `Calculate returns correct value`() {
            val member = TMember(2.0, 3)
            val result = member.Calculate(2.0)
            assertEquals(16.0, result)
        }
        @Test
        fun `Calculate handles degree 0 correctly`() {
            val member = TMember(2.0,0)
            val result = member.Calculate(5.0)
            assertEquals(2.0, result)
        }
    }

    @Nested
    inner class TimesOperatorTests {
        @Test
        fun `times operator returns correct product`() {
            val member1 = TMember(2.0, 3)
            val member2 = TMember(3.0, 2)
            val product = member1 * member2
            assertEquals(TMember(6.0, 5), product)
        }

        @Test
        fun `times operator handles zero correctly`(){
            val member1 = TMember(2.0,3)
            val member2 = TMember(0.0,2)
            val product = member1 * member2
            assertEquals(TMember(0.0,5), product)
        }
    }
}
