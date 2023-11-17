/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Log class
 * @author Kaushya and Kavya
 *
 */
class LogTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.Log#Log()}.
	 */
	@Test
	void testLog() {
		Log<String> test = new Log<String>();
		assertEquals(0, test.size());
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.Log#add(java.lang.Object)}.
	 */
	@Test
	void testAdd() {
		Log<String> test = new Log<String>();
		
		assertThrows(NullPointerException.class, () -> test.add(null));
		
		test.add("apple");
		assertEquals("apple", test.get(0));
		//test growing array
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
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.util.Log#get(int)}.
	 */
	@Test
	void testGet() {
		Log<String> test = new Log<String>();
		
		assertThrows(IndexOutOfBoundsException.class, () -> test.get(-1));
	}
	
}
