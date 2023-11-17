/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * This JUnit test class tests the methods of the FailingTestList class
 * @author Kaushya and Kavya
 *
 */
class FailingTestListTest {
	
	/** constructor for failing test case*/
	private TestCase failingCase;
	
	/**
	 * Sets up and builds the failing test list to be tested
	 */
	@BeforeEach
	public void setUp() {
		FailingTestList list = new FailingTestList();
		failingCase = new TestCase("failA", "Normal", "Test should fail", "Failing");
	}


	@Test
    void testAddPassingTestCase() {
        FailingTestList list = new FailingTestList();
        TestCase passingTestCase = new TestCase("1", "Type", "Description", "Expected");
        passingTestCase.addTestResult(true, "Actual");
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            list.addTestCase(passingTestCase);
        });
        
        assertEquals("Cannot add passing test case.", exception.getMessage());
        assertEquals(0, list.getTestCases().size());
	}


	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.FailingTestList#FailingTestList()}.
	 */
	@Test
	void testFailingTestCase() {
	    FailingTestList list = new FailingTestList();
	    TestCase failingCase = new TestCase("1", "Type", "Description", "Expected");
	    list.addTestCase(failingCase);
	    assertEquals(1, list.getTestCases().size(), "Failing test added");
	}
	
	/**
	 * Test the test plan set to be with the correct name
	 */
	@Test
	void testSetTestPlanNameCorrect() {
	    FailingTestList list = new FailingTestList();
	    list.setTestPlanName(FailingTestList.FAILING_TEST_LIST_NAME);
	    assertEquals(FailingTestList.FAILING_TEST_LIST_NAME, list.getTestPlanName(),
	            "Test plan name is set correctly");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.test_plans.FailingTestList#clearTests()}.
	 */
	@Test
    void testClearTests() {
        FailingTestList list = new FailingTestList();
        
        TestCase failingTestCase1 = new TestCase("1", "Type", "Description", "Expected");
        TestCase failingTestCase2 = new TestCase("2", "Type", "Description", "Expected");
        failingTestCase1.addTestResult(false, "Actual");
        failingTestCase2.addTestResult(false, "Actual");
        list.addTestCase(failingTestCase1);
        list.addTestCase(failingTestCase2);
        
        assertEquals(2, list.getTestCases().size(), "Initial number of test cases added");

        list.clearTests();
        assertEquals(0, list.getTestCases().size(), "Test cases cleared");
	}
	
	/**
	 * Tests whether a 2D array is returned
	 */
	@Test
    void testGetTestCasesAsArray() {
		FailingTestList list = new FailingTestList();

	    TestCase testCase1 = new TestCase("ID1", "Type1", "Description1", "Expected1");
	    TestCase testCase2 = new TestCase("ID2", "Type2", "Description2", "Expected2");
	    list.addTestCase(testCase1);
	    list.addTestCase(testCase2);

	    TestPlan testPlan = new TestPlan("TestPlan1");
	    testCase1.setTestPlan(testPlan);

	    String[][] testCasesArray = list.getTestCasesAsArray();

	    assertEquals(2, testCasesArray.length, "Correct number of test cases in the array");

	    assertEquals("ID1", testCasesArray[0][0], "Test case ID matches");
	    assertEquals("Type1", testCasesArray[0][1], "Test type matches");
	    assertEquals("TestPlan1", testCasesArray[0][2], "Test plan name matches");

	    assertEquals("ID2", testCasesArray[1][0], "Test case ID matches");
	    assertEquals("Type2", testCasesArray[1][1], "Test type matches");
	    assertEquals("", testCasesArray[1][2], "Test plan name should be empty");
	}

}
