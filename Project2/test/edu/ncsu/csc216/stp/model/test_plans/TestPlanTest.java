/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * This JUnit test class tests the methods of the TestPlan class
 * @author Kaushya and Kavya
 *
 */
class TestPlanTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.TestPlan#addTestCase(edu.ncsu.csc216.stp.model.tests.TestCase)}.
	 */
	@Test
	void testAddTestCase() {
		TestPlan testPlan = new TestPlan("TestPlanName");
	    TestCase testCase = new TestCase("ID1", "Type", "Description", "Expected");
	    testPlan.addTestCase(testCase);
	    ISwapList<TestCase> testCases = testPlan.getTestCases();

	    assertEquals(1, testCases.size(), "Test case added to the test plan");
	    assertEquals("ID1", testCases.get(0).getTestCaseId(), "Test case ID matches");
	    assertEquals(testPlan, testCases.get(0).getTestPlan(), "Test plan set correctly for the test case");
	}

	/**
	 * Test method for testing to get test cases as a 2D array
	 */
	@Test
	void testGetTestCasesAsArray() {
	    TestPlan testPlan = new TestPlan("SampleTestPlan");
	    TestCase testCase1 = new TestCase("ID1", "Type1", "Description1", "Expected1");
	    TestCase testCase2 = new TestCase("ID2", "Type2", "Description2", "Expected2");
	    testPlan.addTestCase(testCase1);
	    testPlan.addTestCase(testCase2);

	    String[][] testCasesArray = testPlan.getTestCasesAsArray();
	    assertEquals(2, testCasesArray.length, "Expected number of rows");

	    assertEquals("ID1", testCasesArray[0][0], "TestCase ID at [0][0]");
	    assertEquals("Type1", testCasesArray[0][1], "Test type at [0][1]");
	    assertEquals("FAIL", testCasesArray[0][2], "Test case status at [0][2]");
	    assertEquals("ID2", testCasesArray[1][0], "TestCase ID at [1][0]");
	    assertEquals("Type2", testCasesArray[1][1], "Test type at [1][1]");
	    assertEquals("FAIL", testCasesArray[1][2], "Test case status at [1][2]");
	}

	/**
	 * Test method for comparing test method names
	 */
	@Test
	void testCompareTo() {
		TestPlan testPlan1 = new TestPlan("TestPlanA");
	    TestPlan testPlan2 = new TestPlan("TestPlanB");
	    TestPlan testPlan3 = new TestPlan("TestPlanC");

	    assertEquals(0, testPlan1.compareTo(testPlan1), "Equal plans should return 0");
	    assertTrue(testPlan1.compareTo(testPlan2) < 0, "Plan 1 should come before Plan 2");
	    assertTrue(testPlan2.compareTo(testPlan1) > 0, "Plan 2 should come after Plan 1");

	    assertEquals(0, testPlan2.compareTo(new TestPlan("testplanb")), "Plans with the same name should return 0");
	    assertTrue(testPlan1.compareTo(testPlan3) < 0, "Plan 1 should come before Plan 3");
	    assertTrue(testPlan3.compareTo(testPlan1) > 0, "Plan 3 should come after Plan 1");
	}

}
