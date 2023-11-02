package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * An abstract class at the top of the hierarchy for test plans.
 * The AbstractTestPlan knows the testPlanName and the ISwapList of TestCases.
 */
public class AbstractTestPlan {
	
	/** name of test plan*/
	private static String testPlanName;
	
	/**
     * Constructs an AbstractTestPlan with the given test plan name.
     * Initializes the ISwapList of TestCases.
     * @param testPlanName the name of the test plan
     * @throws IllegalArgumentException if the testPlanName is null or an empty string
     */
	public AbstractTestPlan(String testPlanName) {
		//
	}
	
	/**
     * Sets the test plan name.
     * @param testPlanName the name of the test plan
     * @throws IllegalArgumentException if the testPlanName is null or an empty string
     */
	public void setTestPlanName(String testPlanName) {
		//
	}
	
	/**
     * Gets the test plan name.
     * @return the name of the test plan
     */
	public String getTestPlanName() {
		return null;
	}
	
	/**
	 * Gets the list of TestCases
	 * @return list of TestCases
	 */
	public ISwapList<TestCase> getTestCases() {
		return null;
	}
	
	/**
     * Adds a TestCase to the end of the list.
     * @param t the TestCase to add
     */
	public void addTestCase(TestCase t) {
		//
	}
	
	/**
    * Removes the TestCase at the given index from the list.
    * @param idx the index of the TestCase to remove
    * @return the removed TestCase
    */
	public TestCase removeTestCase(int idx) {
		return null;
	}
	
	/**
     * Gets the TestCase at the given index.
     * @param idx the index of the TestCase to retrieve
     * @return the TestCase at the given index
     */
	public TestCase getTestCase(int idx) {
		return null;
	}
	
	/**
     * Counts the number of TestCases that are failing.
     * @return the number of failing TestCases
     */
	public int getNumberOfFailingTests() {
		return 0;
	}
	
	/**
     * Sends the test result parameters to the TestCase at the given index.
     * @param idx the index of the TestCase
     * @param passing true if the test passed, false otherwise
     * @param actualResults the actual results of the test
     */
	public void addTestResult(int idx, boolean passing, String actualResults) {
		//
	}
	
	/**
     * Returns a 2D String array representation of the TestCases.
     * @return a 2D String array representing the TestCases
     */
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	/**
     * Generates a hash code for the AbstractTestPlan.
     * @return the hash code
     */
    @Override
    public int hashCode() {
		return 0;
	}
	
	/**
     * Compares this AbstractTestPlan to another object for equality.
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
		return false;
	}
}
