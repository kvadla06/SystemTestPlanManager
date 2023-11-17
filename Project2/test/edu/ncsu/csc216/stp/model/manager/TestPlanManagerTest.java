/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;

/**
 * This JUnit test class tests the methods of the TestPlanManager class
 * @author Kaushya and Kavya
 *
 */
class TestPlanManagerTest {
	/**
	 * TestPlanManagerTest class
	 */
	TestPlanManager manager;
	
	@BeforeEach
	public void setUp() {
		manager = new TestPlanManager();
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#TestPlanManager()}.
	 */
	@Test
	void testTestPlanManager() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#loadTestPlans(java.io.File)}.
	 * Tests whether the test plans load
	 */
	@Test
	void testLoadTestPlans() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#saveTestPlans(java.io.File)}.
	 * Tests whether the test plans are saved
	 */
	@Test
	void testSaveTestPlans() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#isChanged()}.
	 * tests whether the test plan undergoes changes
	 */
	@Test
	void testIsChanged() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#addTestPlan(java.lang.String)}.
	 * tests whether a test plan is added
	 */
	@Test
	void testAddTestPlan() {
		String testPlanName = "Test Plan Name 1";
		manager.addTestPlan(testPlanName);
		assertTrue(arrayContains(manager.getTestPlanNames(), testPlanName),
				"Test plan should be added to the list");
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#setCurrentTestPlan(java.lang.String)}.
	 * tests to set current test plan
	 */
	@Test
	void testSetCurrentTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.manager.TestPlanManager#getCurrentTestPlan()}.
	 * tests to get the current test plan
	 */
	@Test
	void testGetCurrentTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * tests to edit test plan
	 */
	@Test
	void testEditTestPlan() {
		manager.addTestPlan("Test Plan A");
		String newTestPlanName = "Edited Test Plan";
		
		manager.setCurrentTestPlan("Test Plan A");
		manager.editTestPlan(newTestPlanName);
		
		assertTrue(manager.arrayContains(manager.getTestPlanNames(), newTestPlanName),  
				"Test plan should be renamed in the list");
	}

	/**
	 * tests to remove the test plan
	 */
	@Test
	void testRemoveTestPlan() {
		manager.addTestPlan("Test Plan A");
		manager.setCurrentTestPlan("Test Plan A");
		manager.removeTestPlan();
		
		assertFalse(arrayContains(manager.getTestPlanNames(), "Test Plan A"),
				"Test Plan should be removed from the list");
		
		assertNotNull(manager.getCurrentTestPlan());
	}

	/**
	 * Test method for adding a test case
	 */
	@Test
	void testAddTestCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for adding test results
	 */
	@Test
	void testAddTestResult() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for clearing test plans
	 */
	@Test
	void testClearTestPlans() {
		fail("Not yet implemented");
	}

}
