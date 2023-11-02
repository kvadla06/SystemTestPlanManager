/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Manages the test plan program
 * @author Kavya and Kaushya
 * @param <E> type for SortedList; must implement Comparable
 */
public class TestPlanManager<E extends Comparable<E>> {
	/** checks if TestPlanManager has been changed since last save */
	private boolean isChanged;
	/** Current test plan */
	private AbstractTestPlan currentTestPlan;
	/** Failing tests in current test plan */
	private FailingTestList failingTestList;
	/** Sorted list of test plans */
	private ISortedList<E> testPlans;
	
	/**
	 * TestPlanManager constructor
	 */
	public TestPlanManager() {
		
	}
	
	/**
	 * Loads test plans from file
	 * @param testPlanFile file to load test plans from
	 */
	public void loadTestPlans(File testPlanFile) {
		
	}
	
	/**
	 * Save test plans to file
	 * @param testPlanFile file to save test plans to
	 */
	public void saveTestPlans(File testPlanFile) {
		
	}
	
	/**
	 * Returns if TestPlanManager has been changed since last save
	 * @return false if TestPlanManager has not been changed, true if TestPlanManager has been changed
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Adds test plan to test plan list
	 * @param testPlanName name of test plan
	 * @throws IllegalArgumentException "Invalid name." if the new TestPlan’s name is FAILING_TESTS_LIST_NAME 
	 * or a duplicate of an existing TestPlan 
	 */
	public void addTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Gets the name of the test plans
	 * @return list of names of test plans
	 */
	public String[] getTestPlanNames() {
		return null;
	}
	
	/**
	 * Gets failing tests of test plan
	 */
	private void getFailingTests() {
		
	}
	
	/**
	 * Sets current test plan to test plan found with the string parameter
	 * @param testPlanName name of test plan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Get the current test plan
	 * @return current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	/**
	 * Edits name of test plan
	 * @param testPlanName new name of test plan
	 * @throws IllegalArgumentException if:
	 *  the currentTestPlan is an FailingTestList (message “The Failing Tests list may not be edited.”)
	 *  the new name matches “Failing Tests” (case insensitive) (message “Invalid name.”)
	 *  or is a duplicate of the name of another TestPlan (case insensitive and including if the name is the same as the list that will be renamed) (message “Invalid name.”)
	 */
	public void editTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Removes the current test plan and is set to the failing test list
	 * @throws if the currentTestPlan is an FailingTestList with the message “The Failing Tests list may not be deleted.”
	 */
	public void removeTestPlan() {
		
	}
	
	/**
	 * Add test case to the current test plan
	 * @param t test case to be added to the test plan
	 */
	public void addTestCase(TestCase t) {
		
	}
	
	/**
	 * Adds test result to test case at a given index
	 * @param idx index to add the test case 
	 * @param passing if tests are passing or failing
	 * @param actualResult actual restult of the test result
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		
	}
	
	/**
	 * Clears the TestPlan Manager
	 */
	public void clearTestPlans() {
		
	}
}
