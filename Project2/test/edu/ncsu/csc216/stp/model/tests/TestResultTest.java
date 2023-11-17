/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the TestResult class
 * 
 * @author Kaushya and Kavya
 */
class TestResultTest {

	/**
	 * Test method for the test results
	 */
	@Test
	void testTestResult() {
		TestResult passingResult = new TestResult(true, "Test passed");
        assertEquals("PASS: Test passed", passingResult.toString(), "Passing result should match");

        TestResult failingResult = new TestResult(false, "Test failed");
        assertEquals("FAIL: Test failed", failingResult.toString(), "Failing result should match");

        //null or empty actualResults
        assertThrows(IllegalArgumentException.class, () -> new TestResult(true, null),
                "Null actualResults should throw IllegalArgumentException");
        
        assertThrows(IllegalArgumentException.class, () -> new TestResult(false, ""),
                "Empty actualResults should throw IllegalArgumentException");
	}

	/**
	 * Test method for getting actual results
	 */
	@Test
	void testGetActualResults() {
		String expectedResult = "Expected result";
        TestResult result = new TestResult(true, expectedResult);
        assertEquals(expectedResult, result.getActualResults(), "Actual result should match the expected result");
        
        String differentResult = "Different result";
        TestResult different = new TestResult(false, differentResult);
        assertEquals(differentResult, different.getActualResults(), "Different actual result should be retrieved correctly");
	}
	
	/**
	 * Test method for if test is passing
	 */
	@Test
	void testIsPassing() {
		TestResult passingResult = new TestResult(true, "Test passed");
        assertTrue(passingResult.isPassing(), "Passing result should return true for isPassing");

        TestResult failingResult = new TestResult(false, "Test failed");
        assertFalse(failingResult.isPassing(), "Failing result should return false for isPassing");
	}

}
