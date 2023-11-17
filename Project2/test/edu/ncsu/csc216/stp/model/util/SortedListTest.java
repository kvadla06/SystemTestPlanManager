/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the SortedList class
 * 
 * @author Kaushya and Kavya
 */
class SortedListTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#SortedList()}.
	 */
	@Test
	void testSortedList() {
		SortedList<String> test = new SortedList<String>();
		assertEquals(0, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#add(java.lang.Comparable)}.
	 */
	@Test
	void testAdd() {
		SortedList<String> test = new SortedList<String>();
		
		test.add("banana");
		
		assertEquals("banana", test.get(0));
		assertThrows(NullPointerException.class, () -> test.add(null));
		assertThrows(IllegalArgumentException.class, () -> test.add("banana"));
		
		test.add("carrot");
		assertEquals("carrot", test.get(1));
		test.add("apple");
		assertEquals("apple", test.get(0));
		test.add("eggplant");
		test.add("dragonfruit");
		assertEquals("dragonfruit", test.get(3));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SortedList<String> test = new SortedList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		assertThrows(IndexOutOfBoundsException.class, () -> test.remove(-1));
		assertEquals("carrot", test.remove(2));
		assertEquals(3, test.size());
		assertEquals("apple", test.remove(0));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SortedList#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContains() {
		SortedList<String> test = new SortedList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		
		assertTrue(test.contains("dragonfruit"));
		assertFalse(test.contains("eggplant"));
	}

}
