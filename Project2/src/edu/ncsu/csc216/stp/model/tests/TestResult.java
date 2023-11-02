/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

/**
 * This class contains information about the results of a single execution of a TestCase. 
 * The TestResult knows if it is passing or failing and has details 
 * about the actual results from execution
 * @author Kaushya and Kavya
 *
 */
public class TestResult {
	
	/** String representation for a passing test result */
	public static final String PASS = "PASS";
	/** String representation for a failing test result */
	public static final String FAIL = "FAIL";
	/** Flag indicating whether the test passed or failed */
	private boolean passing;
	/** The actual results from the test execution */
	private String actualResults;
	
	/**
	 * Constructs a TestResult with the given parameters.
	 * Throws an IllegalArgumentException if actualResults is null or an empty string.
	 * 
	 * @param passing true if the test passed, false if it failed
	 * @param actualResults the actual results from the test execution
	 * @throws IllegalArgumentException if actualResults is null or an empty string
	 */
	public TestResult(boolean passing, String actualResults) {
		//
	}
	
	/**
	 * Returns the actual results from the test execution.
	 * 
	 * @return the actual results from the test execution
	 */
	public String getActualResults() {
		return null;
		//
	}
	
	/**
	 * Sets the actual results from the test execution.
	 * Throws an IllegalArgumentException if actualResults is null or an empty string.
	 * 
	 * @param actualResults the actual results from the test execution
	 * @throws IllegalArgumentException if actualResults is null or an empty string
	 */
	private void setActualResults(String actualResults) {
		//
	}
	
	/**
	 * Returns true if the test result indicates a passing test, false otherwise.
	 * 
	 * @return true if the test passed, false if it failed
	 */
	public boolean isPassing() {
		return false;
		
	}
	
	/**
	 * Sets whether the test result indicates a passing or failing test.
	 * 
	 * @param passing true if the test passed, false if it failed
	 */
	private void setPassing(boolean passing) {
		//
	}
	
	/**
	 * Returns a string representation of the TestResult for printing to a file or displaying in the GUI.
	 * 
	 * @return a string representation of the TestResult
	 */
	public String toString() {
		return "";
	}

}
