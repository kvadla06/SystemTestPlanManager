/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * This class manages the information about each individual test case
 * @author Kaushya and Kavya
 *
 */
public class TestCase {
	
	/** The unique ID of the test case */
	private String testCaseId;
	/** The type of the test case */
	private String testType;
	/** The description of the test case */
	private String testDescription;
	/** The expected results of the test case */
	private String expectedResults;
	/** The associated test plan */
	private TestPlan testPlan;
	
	/**
	 * Constructs a TestCase with the given parameters
	 * 
	 * @param testCaseId the unique ID of the test case
	 * @param testType the type of the test case
	 * @param testDescription the description of the test case
	 * @param expectedResults the expected results of the test case
	 */
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		//
	}
	
	/**
	 * Returns the unique ID of the test case.
	 * 
	 * @return the test case ID
	 */
	public String getTestCaseId() {
		return null;
	}
	
	/**
	 * Sets the unique ID of the test case.
	 * 
	 * @param testCaseId the test case ID to set
	 * @throws IllegalArgumentException if the ID is null or empty
	 */
	private void setTestCaseId(String testCaseId) {
		//
	}
	
	/**
	 * Returns the type of the test case.
	 * 
	 * @return the test case type
	 */
	public String getTestType() {
		return null;
		//
	}
	
	/**
	 * Sets the type of the test case.
	 * 
	 * @param testType the test case type to set
	 * @throws IllegalArgumentException if the type is null or empty
	 */
	private void setTestType(String testType) {
		//
	}
	
	/**
	 * Returns the description of the test case.
	 * 
	 * @return the test case description
	 */
	public String getTestDescription() {
		return null;
		//
	}
	
	/**
	 * Sets the description of the test case.
	 * 
	 * @param testDescription the test case description to set
	 * @throws IllegalArgumentException if the description is null or empty
	 */
	private void setTestdescription(String testDescription) {
		//
	}
	
	/**
	 * Returns the expected results of the test case.
	 * 
	 * @return the expected results
	 */

	public String getExpectedResults() {
		return null;
		//
	}
	
	/**
	 * Sets the expected results of the test case.
	 * 
	 * @param expectedResults the expected results to set
	 * @throws IllegalArgumentException if the expected results are null or empty
	 */
	private void setExpectedResults(String expectedResults) {
		//
	}
	
	/**
	 * Creates a TestResult from the given values and adds the TestResult to the end of the testResults log.
	 * 
	 * @param passing whether the test case passed or not
	 * @param actualResults the actual results of the test case
	 * @throws IllegalArgumentException if the TestResult cannot be constructed
	 */
	public void addTestResult(boolean passing,String actualResults) {
		//
	}
	
	/**
	 * Returns true if the last TestResult in the Log is passing.
	 * If there are no TestResults in the Log the test is considered failing since it has not yet run and false is returned.
	 * 
	 * @return true if the test case is passing, false otherwise
	 */
	public boolean isTestCasePassing() {
		return false;
		//
	}
	
	/**
	 * Returns the status of the TestCase pass or fail
	 * Use the constants from TestResult.
	 * 
	 * @return the status of the test case, as pass or fail
	 */
	public String getStatus() {
		return null;
		//
	}
	
	/**
	 * Returns a string representation of the actual results log.
	 * Each TestResult is preceded by a "- " and followed by a newline character.
	 * 
	 * @return a string representation of the actual results log
	 */
	public String getActualResultsLog() {
		return null;
		//
	}
	
	/**
	 * Sets the test plan associated with this test case.
	 * 
	 * @param testPlan the test plan to associate with this test case
	 * @throws IllegalArgumentException if the provided test plan is null
	 */
	public void setTestPlan(TestPlan testPlan) {
		//
	}
	
	/**
	 * Returns the test plan associated with this test case.
	 * 
	 * @return the test plan associated with this test case
	 */
	public TestPlan getTestPlan() {
		return null;
		//
	}
	
	/**
	 * Returns a string representation of the test case for printing to a file.
	 * 
	 * @return a string representation of the test case
	 */
	public String toString() {
		return null;
		//
	}
	
}
