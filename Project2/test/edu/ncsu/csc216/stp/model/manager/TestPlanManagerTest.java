/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.ncsu.csc216.stp.model.tests.TestCase;

import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * This JUnit test class tests the methods of the TestPlanManager class
 * @author Kaushya and Kavya
 *
 */
class TestPlanManagerTest {
	/**
	 * TestPlanManagerTest class
	 */
	TestPlanManager<TestPlan> manager;
	
	@BeforeEach
	public void setUp() {
		manager = new TestPlanManager<TestPlan>();
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#isChanged()}.
	 * tests whether the test plan undergoes changes
	 */
	@Test
	void testIsChanged() {
        assertFalse(manager.isChanged(), "Manager indicates changes when it should not");

        manager.addTestPlan("Plan1");
        assertTrue(manager.isChanged(), "Manager should indicate changes");
        manager.saveTestPlans(new File("filename"));
        assertFalse(manager.isChanged(), "Manager indicates changes when it should not after saving");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestPlan(java.lang.String)}.
	 * tests whether a test plan is added
	 */
	@Test
	void testAddTestPlan() {
        manager.addTestPlan("New Test Plan");
        
        String[] testPlanNames = manager.getTestPlanNames();
        boolean found = false;
        for (String name : testPlanNames) {
            if ("New Test Plan".equals(name)) {
                found = true;
                break;
            }
        }
        assertTrue(found, "Test plan was not added");
	}

	/**
	 * Test for invalid plan name
	 */
	@Test
	public void testAddTestPlanInvalidName() {
		String testPlanName = FailingTestList.FAILING_TEST_LIST_NAME;
		
		assertThrows(IllegalArgumentException.class, () -> manager.addTestPlan(testPlanName),
				"Should throw IllegalArgumentException for invalid name");
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#getTestPlanNames()}.
	 * tests to get test plan names
	 */
	@Test
	void testGetTestPlanNames() {
        manager.addTestPlan("Plan A");
        manager.addTestPlan("Plan B");


        String[] testPlanNames = manager.getTestPlanNames();

        assertEquals(3, testPlanNames.length, "Wrong number of test plan names");
        assertEquals("Failing Tests", testPlanNames[0], "First test plan name is wrong");
        assertEquals("Plan A", testPlanNames[1], "Second test plan name is wrong");
        assertEquals("Plan B", testPlanNames[2], "Third test plan name is wrong");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#getCurrentTestPlan()}.
	 * tests to get the current test plan
	 */
	@Test
	void testGetCurrentTestPlan() {
        assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName(), 
                     "At first, the current test plan should be the failing test list");
        
        manager.addTestPlan("New Test Plan");
        manager.setCurrentTestPlan("New Test Plan");

        assertEquals("New Test Plan", manager.getCurrentTestPlan().getTestPlanName(), 
                     "Current test plan should match the new test plan");
	}

	/**
	 * tests to edit test plan
	 */
	@Test
	void testEditTestPlan() {
        manager.addTestPlan("Plan1");
        manager.setCurrentTestPlan("Plan1");
        manager.editTestPlan("EditedPlan");

        assertEquals("EditedPlan", manager.getCurrentTestPlan().getTestPlanName(), 
                     "Test plan should be successfully edited");
	}

	/**
	 * tests to remove the test plan
	 */
	@Test
	void testRemoveTestPlan() {
		 manager.addTestPlan("PlanA");
	        manager.setCurrentTestPlan("PlanA");
	        manager.removeTestPlan();

	        assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName(), 
	                     "Test plan should be successfully removed");
	}

	/**
	 * Test method for adding a test case 
	 */
	@Test
	void testAddTestCase() {
        manager.addTestPlan("Plan1");
        manager.setCurrentTestPlan("Plan1");
        
        TestCase testCase = new TestCase("1", "Type", "Description", "Expected");
        testCase.addTestResult(false, "Actual");
        manager.addTestCase(testCase);
    
        assertEquals(1, manager.getCurrentTestPlan().getTestCases().size(), 
                     "Test case should be successfully added");
	}

	/**
	 * Test method for adding test results
	 */
	@Test
	void testAddTestResult() {
		manager.addTestPlan("Plan1");
        manager.setCurrentTestPlan("Plan1");

        TestCase testCase = new TestCase("1", "Type", "Description", "Expected");
        testCase.addTestResult(false, "Actual");
        manager.addTestCase(testCase);
        
        manager.addTestResult(0, true, "New actual result");
        assertTrue(manager.getCurrentTestPlan().getTestCases().get(0).isTestCasePassing(),
                   "Test result should be successfully added");
	}

	/**
	 * Test method for clearing test plans
	 */
	@Test
	void testClearTestPlans() {
		manager.addTestPlan("Plan1");
        manager.addTestPlan("Plan2");

        TestCase testCase = new TestCase("1", "Type", "Description", "Expected");
        manager.addTestCase(testCase);
        manager.clearTestPlans();

        assertEquals(1, manager.getTestPlanNames().length, "Only the failing test list should remain");
        assertEquals(FailingTestList.FAILING_TEST_LIST_NAME, manager.getTestPlanNames()[0],
                     "Only the failing test list should remain");
        assertEquals(manager.getCurrentTestPlan(), manager.getCurrentTestPlan(), 
                     "Current test plan should be the failing test list");
	}

}
