/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the SwapList class
 * @author Kaushya and Kavya
 *
 */
class SwapListTest {

	
	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#SwapList()}.
	 */
	@Test
	void testSwapList() {
		SwapList<String> test = new SwapList<String>();
		assertEquals(0, test.size());
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		assertEquals("apple", test.get(0));
		assertThrows(NullPointerException.class, () -> test.add(null));
		
		//test growing list
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("apple");
		test.add("banana");
		assertEquals("banana", test.get(10));
		assertEquals(11, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#remove(int)}.
	 */
	@Test
	void testRemove() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		
		assertEquals("carrot", test.remove(2));
		assertThrows(IndexOutOfBoundsException.class, () -> test.remove(-1));
		assertEquals(3, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveUp(int)}.
	 */
	@Test
	void testMoveUp() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		
		test.moveUp(0);
		test.moveUp(3);
		
		assertEquals("apple", test.get(0));
		assertEquals("dragonfruit", test.get(2));
		assertEquals("carrot", test.get(3));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveDown(int)}.
	 */
	@Test
	void testMoveDown() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		
		test.moveDown(3);
		test.moveDown(1);
		
		assertEquals("dragonfruit", test.get(3));
		assertEquals("banana", test.get(2));
		assertEquals("carrot", test.get(1));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveToFront(int)}.
	 */
	@Test
	void testMoveToFront() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		
		test.moveToFront(2);
		assertEquals("carrot", test.get(0));
		test.moveToFront(1);
		assertEquals("apple", test.get(0));
		assertEquals("carrot", test.get(1));
		assertEquals("banana", test.get(2));
		test.moveToFront(0);
		assertEquals("apple", test.get(0));
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveToBack(int)}.
	 */
	@Test
	void testMoveToBack() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		test.add("banana");
		test.add("carrot");
		test.add("dragonfruit");
		
		test.moveToBack(1);
		assertEquals("banana", test.get(3));
		test.moveToBack(1);
		assertEquals("carrot", test.get(3));
		assertEquals("banana", test.get(2));
		assertEquals("dragonfruit", test.get(1));
		test.moveToBack(3);
		assertEquals("carrot", test.get(3));
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.SwapList#moveToBack(int)}.
	 */
	@Test
	void testMoveToBack1() {
		SwapList<String> test = new SwapList<String>();
		
		test.add("apple");
		assertEquals("apple", test.get(0));
		test.add("pear");
		assertEquals("apple", test.get(0));
		assertEquals("pear", test.get(1));
		test.add("banana");
		assertEquals("apple", test.get(0));
		assertEquals("pear", test.get(1));
		assertEquals("banana", test.get(2));
		test.add("cherry");
		assertEquals("apple", test.get(0));
		assertEquals("pear", test.get(1));
		assertEquals("banana", test.get(2));
		assertEquals("cherry", test.get(3));
		test.add("blueberries");
		assertEquals("apple", test.get(0));
		assertEquals("pear", test.get(1));
		assertEquals("banana", test.get(2));
		assertEquals("cherry", test.get(3));
		assertEquals("blueberries", test.get(4));
		
		test.moveToBack(2);
		assertEquals("apple", test.get(0));
		assertEquals("pear", test.get(1));
		assertEquals("cherry", test.get(2));
		assertEquals("blueberries", test.get(3));
		assertEquals("banana", test.get(4));
		
		
	}

		

}
