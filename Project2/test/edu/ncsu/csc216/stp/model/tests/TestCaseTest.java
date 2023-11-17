/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * This JUnit test class tests the methods of the TestCaseTest class
 * @author Kaushya and Kavya
 *
 */
class TestCaseTest {


	/**
	 * Test method for getting the test case Id
	 */
	@Test
    void testGetTestCaseId() {
        TestCase testCase = new TestCase("ID001", "Type", "Description", "Expected");
        assertEquals("ID001", testCase.getTestCaseId(), "Initial test case ID");
    }

	/**
	 * Test method for getting test type
	 */
	@Test
	void testGetTestType() {
        TestCase testCase = new TestCase("ID001", "TypeABC", "DescriptionXYZ", "Expected");
        assertEquals("TypeABC", testCase.getTestType(), "Test case type");
	}

	/**
	 * Test method for getting test description
	 */
	@Test
	void testGetTestDescription() {
		TestCase testCase = new TestCase("ID001", "TypeABC", "DescriptionXYZ", "Expected");
        assertEquals("DescriptionXYZ", testCase.getTestDescription(), "Test case description");
	}

	/**
	 * Test method for getting expected results
	 */
	@Test
	void testGetExpectedResults() {
        TestCase testCase = new TestCase("ID001", "TypeABC", "DescriptionXYZ", "Expected");
        assertEquals("Expected", testCase.getExpectedResults(), "Expected results of the test case");
	}

	/**
	 * Test method for adding test results
	 */
	@Test
	void testAddTestResult() {
        TestCase testCase = new TestCase("ID001", "TypeABC", "DescriptionXYZ", "Expected");
        testCase.addTestResult(true, "Actual");
        assertEquals("PASS", testCase.getStatus(), "Status of the test case after adding result");
        testCase.addTestResult(false, "Failure");
        assertEquals("FAIL", testCase.getStatus(), "Status of the test case after adding failure");
	}


	/**
	 * Test method for getting the pass or fail status
	 */
	@Test
	void testGetStatus() {
        TestCase testCase = new TestCase("ID001", "TypeABC", "DescriptionXYZ", "Expected");
        testCase.addTestResult(true, "Actual Pass");
        
        assertEquals("PASS", testCase.getStatus(), "Status should be PASS for a passing test case");
        testCase.addTestResult(false, "Actual Fail");
        assertEquals("FAIL", testCase.getStatus(), "Status should be FAIL for a failing test case");
	}


	/**
	 * Test method for getting test plan
	 */
	@Test
	void testGetTestPlan() {
		TestCase testCaseWithoutPlan = new TestCase("ID001", "TypeABC", "DescriptionXYZ", "Expected");
		
        assertNull(testCaseWithoutPlan.getTestPlan(), "Test plan should be null initially");
        TestPlan testPlan = new TestPlan("TestPlan1");

        testCaseWithoutPlan.setTestPlan(testPlan);
        assertEquals(testPlan, testCaseWithoutPlan.getTestPlan(), "Test plan should match the one set");
	}

}
