/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * This JUnit test class tests the methods of the AbstractTestPlan class
 * @author Kaushya and Kavya
 *
 */
class AbstractTestPlanTest {
	
	private static final String FAILING_TEST_LIST_NAME = "Failing Tests";
	/** String value for test result A*/
	private static final String ACTUAL_RESULT = "The GUI failed to load";
	/** String representing a passing test*/
	public static final String PASS = "PASS";
	/** String representing a failing test*/
	public static final String FAIL = "FAIL";
	/** String value for toString method*/
	private static final String valueToString = "- " + FAIL +": " + ACTUAL_RESULT +"\n";
	
	/** test case ID for test case A*/
	final static private String TESTCASE_ID = "1";
	/** test case 1 test case type*/
	final static String TEST_TYPE = "Boundary Value";
	/** description for test case A*/
	final static private String TEST_DESCRIPTION = "Preconditions: Test 4 has passed +/n Input -1 as a value";
	/** expected result for test case A*/
	final static private String EXPECTED_RESULT = "Invalid value";
	


	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#AbstractTestPlan(java.lang.String)}.
	 */
	@Test
	void testAbstractTestPlan() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestPlan(""),
				"Should throw becuase of invalid actual results");
		assertEquals(e1.getMessage(), "Invalid name.");
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestPlan(null),
				"should throw exception because of invalid actual results");
		assertEquals(e2.getMessage(), "Invalid name.");
		
		AbstractTestPlan ftl = new FailingTestList();
		AbstractTestPlan tp = new TestPlan("Packscheduler");
		assertEquals(FAILING_TEST_LIST_NAME, ftl.getTestPlanName());
		assertEquals("Packscheduler", tp.getTestPlanName());
	}

	
	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#addTestCase(edu.ncsu.csc216.stp.model.tests.TestCase)}.
	 */
	@Test
	void testAddTestCase() {
		AbstractTestPlan tp = new TestPlan("Packscheduler");
		TestCase tptc = new TestCase(TESTCASE_ID, TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc2 = new TestCase("2", TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc3 = new TestCase(TESTCASE_ID, "Requirements", TEST_DESCRIPTION, EXPECTED_RESULT);

		tp.addTestCase(tptc);
		tp.addTestCase(tptc2);
		tp.addTestCase(tptc3);
		
		assertEquals(tptc.toString(), tp.getTestCase(0).toString(),
				"Index out of bounds");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#removeTestCase(int)}.
	 */
	@Test
	void testRemoveTestCase() {
		AbstractTestPlan tp = new TestPlan("Packscheduler");
		TestCase tptc1 = new TestCase(TESTCASE_ID, TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc2 = new TestCase("2", TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc3 = new TestCase(TESTCASE_ID, "Requirements", TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc4 = new TestCase(TESTCASE_ID, TEST_TYPE, "Preconditions: Test 2 passes", EXPECTED_RESULT);
		TestCase tptc5 = new TestCase(TESTCASE_ID, "Requirements", TEST_DESCRIPTION, "Error Message");
		
		tp.addTestCase(tptc1);
		tp.addTestCase(tptc2);
		tp.addTestCase(tptc3);
		tp.addTestCase(tptc4);
		tp.addTestCase(tptc5);
		
		tp.removeTestCase(4);
		assertEquals(tp.getTestCases().get(tp.getTestCases().size() -1).toString(),tptc4.toString());
		
		tp.removeTestCase(0);
		assertEquals(tp.getTestCases().get(0).toString(), tptc2.toString());
		
		tp.removeTestCase(1);
		assertEquals(tp.getTestCases().get(1).toString(), tptc4.toString());
		
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#getNumberOfFailingTests()}.
	 */
	@Test
	void testGetNumberOfFailingTestCases() {
		AbstractTestPlan tp = new TestPlan("Packscheduler");
		TestCase tptc = new TestCase(TESTCASE_ID, TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc2 = new TestCase("2", TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		TestCase tptc3 = new TestCase(TESTCASE_ID, TEST_TYPE, TEST_DESCRIPTION, EXPECTED_RESULT);
		
		tp.addTestCase(tptc);
		tp.addTestCase(tptc2);
		tp.addTestCase(tptc3);
		
		tptc.addTestResult(false, ACTUAL_RESULT);
		tptc2.addTestResult(true, ACTUAL_RESULT);
		tptc3.addTestResult(true, ACTUAL_RESULT);
		assertEquals(tp.getNumberOfFailingTests(), 1);
		tptc2.addTestResult(false, ACTUAL_RESULT);
		assertEquals(tp.getNumberOfFailingTests(), 2);
		tptc3.addTestResult(true, ACTUAL_RESULT);
		assertEquals(tp.getNumberOfFailingTests(), 2);
	} 

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan#addTestResult(int, boolean, java.lang.String)}.
	 */
	@Test
	void testAddTestResult() {
		AbstractTestPlan tp = new TestPlan("PackScheduler");
		TestCase tptc = new TestCase(TESTCASE_ID, TEST_TYPE, TEST_DESCRIPTION,EXPECTED_RESULT);
		
		tp.addTestCase(tptc);
		tp.addTestResult(0, false, ACTUAL_RESULT);
		
		assertEquals(valueToString, tp.getTestCases().get(0).getActualResultsLog());
	}
	
	@Test
	void testErrorHandling() {
	    AbstractTestPlan tp = new TestPlan("Packscheduler");
	    
	    assertThrows(IllegalArgumentException.class, () -> tp.addTestCase(null));
	    assertThrows(IndexOutOfBoundsException.class, () -> tp.removeTestCase(0));
	    
	    assertThrows(IllegalArgumentException.class, () -> tp.setTestPlanName(null));
	    assertThrows(IllegalArgumentException.class, () -> tp.setTestPlanName(""));
	} 

	@Test
	void testHashCode() {
	    AbstractTestPlan plan1 = new TestPlan("Plan1");
	    AbstractTestPlan plan2 = new TestPlan("Plan1");
	    AbstractTestPlan plan3 = new TestPlan("Plan3");

	    assertEquals(plan1.hashCode(), plan2.hashCode());
	    assertNotEquals(plan1.hashCode(), plan3.hashCode());
	}
	
	@Test
    void testGetTestCasesAsArray() {

		AbstractTestPlan testPlan = new AbstractTestPlan("TestPlanName");

        TestCase testCase1 = new TestCase("ID1", "Type1", "Description1", "Expected1");
        TestCase testCase2 = new TestCase("ID2", "Type2", "Description2", "Expected2");
        testPlan.addTestCase(testCase1);
        testPlan.addTestCase(testCase2);

        String[][] testCasesArray = testPlan.getTestCasesAsArray();

        assertNotNull(testCasesArray, "Test cases array should not be null");

        assertEquals("ID1", testCasesArray[0][0], "Mismatch in test case ID for first test case");
        assertEquals("Type1", testCasesArray[0][1], "Mismatch in test type for first test case");
        assertEquals("Description1", testCasesArray[0][2], "Mismatch in test description for first test case");
        assertEquals("Expected1", testCasesArray[0][3], "Mismatch in expected results for first test case");

        assertEquals("ID2", testCasesArray[1][0], "Mismatch in test case ID for second test case");
        assertEquals("Type2", testCasesArray[1][1], "Mismatch in test type for second test case");
        assertEquals("Description2", testCasesArray[1][2], "Mismatch in test description for second test case");
        assertEquals("Expected2", testCasesArray[1][3], "Mismatch in expected results for second test case");
    }
}
