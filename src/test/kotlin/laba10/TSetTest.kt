package laba10

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TSetTest {

    @Nested
    inner class EmptyTests {
        @Test
        fun `Empty clears the set`() {
            val set = TSet<Int>()
            set.Add(1)
            set.Empty()
            assertTrue(set.isEmpty())
        }
    }

    @Nested
    inner class AddTests {
        @Test
        fun `Add adds an element to the set`() {
            val set = TSet<Int>()
            set.Add(1)
            assertTrue(set.Belongs(1))
        }
        @Test
        fun `Add does not add duplicate element`(){
            val set = TSet<Int>()
            set.Add(1)
            set.Add(1)
            assertEquals(1, set.size())
        }
    }

    @Nested
    inner class RemoveTests {
        @Test
        fun `Remove removes an element from the set`() {
            val set = TSet<Int>()
            set.Add(1)
            set.Remove(1)
            assertFalse(set.Belongs(1))
        }

        @Test
        fun `Remove does nothing if element is not present`() {
            val set = TSet<Int>()
            set.Remove(1)
            assertTrue(set.isEmpty())
        }

    }

    @Nested
    inner class IsEmptyTests {
        @Test
        fun `isEmpty returns true for an empty set`() {
            val set = TSet<Int>()
            assertTrue(set.isEmpty())
        }

        @Test
        fun `isEmpty returns false for a non-empty set`() {
            val set = TSet<Int>()
            set.Add(1)
            assertFalse(set.isEmpty())
        }
    }

    @Nested
    inner class BelongsTests {
        @Test
        fun `Belongs returns true if element is present`() {
            val set = TSet<Int>()
            set.Add(1)
            assertTrue(set.Belongs(1))
        }

        @Test
        fun `Belongs returns false if element is not present`() {
            val set = TSet<Int>()
            assertFalse(set.Belongs(1))
        }
    }

    @Nested
    inner class JoinTests {
        @Test
        fun `Join combines two sets`() {
            val set1 = TSet<Int>()
            set1.Add(1)
            set1.Add(2)
            val set2 = TSet<Int>()
            set2.Add(2)
            set2.Add(3)
            val joinedSet = set1.Join(set2)
            assertEquals(3, joinedSet.size())
            assertTrue(joinedSet.Belongs(1))
            assertTrue(joinedSet.Belongs(2))
            assertTrue(joinedSet.Belongs(3))
        }
    }

    @Nested
    inner class SubtractTests {
        @Test
        fun `Subtract removes elements from the set`() {
            val set1 = TSet<Int>()
            set1.Add(1)
            set1.Add(2)
            val set2 = TSet<Int>()
            set2.Add(2)
            val subtractedSet = set1.Subtract(set2)
            assertEquals(1, subtractedSet.size())
            assertTrue(subtractedSet.Belongs(1))
            assertFalse(subtractedSet.Belongs(2))
        }
    }

    @Nested
    inner class MultiplyTests {
        @Test
        fun `4' combines two sets without duplicates`() {
            val set1 = TSet<Int>()
            set1.Add(1)
            set1.Add(2)
            val set2 = TSet<Int>()
            set2.Add(2)
            set2.Add(3)
            val multipliedSet = set1.Multiply(set2)
            assertEquals(1, multipliedSet.size())
            assertTrue(!multipliedSet.Belongs(1))
            assertTrue(multipliedSet.Belongs(2))
            assertTrue(!multipliedSet.Belongs(3))
        }
    }

    @Nested
    inner class SizeTests {
        @Test
        fun `size returns correct size`() {
            val set = TSet<Int>()
            set.Add(1)
            set.Add(2)
            assertEquals(2, set.size())
        }

        @Test
        fun `size returns 0 for an empty set`() {
            val set = TSet<Int>()
            assertEquals(0, set.size())
        }
    }

    @Nested
    inner class ElementTests {
        @Test
        fun `Element returns correct element`() {
            val set = TSet<Int>()
            set.Add(1)
            set.Add(2)
            assertEquals(2, set.Element(1))
        }

        @Test
        fun `Element throws exception for out of bounds index`() {
            val set = TSet<Int>()
            assertThrows<IndexOutOfBoundsException> { set.Element(0) }
        }
    }
}
