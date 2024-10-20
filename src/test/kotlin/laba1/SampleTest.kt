package laba1

import org.junit.jupiter.api.Assertions.*
import ru.sergey.learn2.laba1.Sample
import kotlin.test.Test
class SampleTest {

    private val testSample: Sample = Sample()

    @Test
    fun `test Sum 1 2 3 + 1 2 3`() {
        // arrange
        val a = intArrayOf(1,2,3)
        val b = intArrayOf(1,2,3)
        val expected = listOf(2,4,6)

        // act
        val actual = testSample.sum(a,b)
        // assert
        assertEquals(expected, actual)
    }
    @Test
    fun `test Sum aArrey empty`() {
        val a = intArrayOf(1,2,3)
        val b = intArrayOf(1,2,3)
        val expected = listOf(2,4,6)
        val actual = testSample.sum(a,b)
        assertEquals(expected, actual)
    }
    @Test
    fun `test Sum aArrey size not equal to aArrey size`() {
        val a = intArrayOf(1,2,3)
        val b = intArrayOf(1,2,3)
        val expected = listOf(2,4,6)
        val actual = testSample.sum(a,b)
        assertEquals(expected, actual)
    }


    @Test
    fun `shift LeftTest 1 2 3 4 5 shift 2`() {
        val array = doubleArrayOf(1.0,2.0,3.0,4.0,5.0)
        val shift = 2
        val expected = doubleArrayOf(3.0,4.0,5.0,1.0,2.0)
        val actual = testSample.shiftLeft(array,shift)
        assertTrue(expected.contentEquals(actual), "Массивы не совпадают")
    }
    @Test
    fun `shift LeftTest empty Arrey shift 2`() {
        val array = doubleArrayOf()
        val shift = 2
        val expected = doubleArrayOf()
        val actual = testSample.shiftLeft(array,shift)
        assertTrue(expected.contentEquals(actual), "Массивы не совпадают")
    }
    @Test
    fun `shift LeftTest  shift  = arrey size `() {
        val array = doubleArrayOf(1.0,2.0,3.0,4.0,5.0)
        val shift = 5
        val expected = array
        val actual = testSample.shiftLeft(array,shift)
        assertTrue(expected.contentEquals(actual), "Массивы не совпадают")
    }

    @Test
    fun `test Empty Sequence 2 in 1 2 3`() {
        val vec = intArrayOf(1, 2, 3)
        val seq = intArrayOf(2)
        val expected = 1
        val actual = testSample.findSubsequenceIndex(vec, seq)
        assertEquals(expected, actual)
    }
    @Test
    fun `test Empty Sequence seq is Empty`() {
        val vec = intArrayOf(1, 2, 3)
        val seq = intArrayOf()
        val expected = 0
        val actual = testSample.findSubsequenceIndex(vec, seq)
        assertEquals(expected, actual)
    }
    @Test
    fun `test Empty Sequence vec size less seq size`() {
        val vec = intArrayOf(1, 2, 3)
        val seq = intArrayOf(1, 2, 3, 1, 2, 3)
        val expected = -1
        val actual = testSample.findSubsequenceIndex(vec, seq)
        assertEquals(expected, actual)
    }
}