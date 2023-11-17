package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SwapList;

/**
 * An abstract class at the top of the hierarchy for test plans.
 * The AbstractTestPlan knows the testPlanName and the ISwapList of TestCases.
 * 
 * @author Kaushya and Kavya
 */
public class AbstractTestPlan {
	
	/** name of test plan*/
	private String testPlanName;
	/** List of test cases*/
	private ISwapList<TestCase> testCases;
	
	/**
     * Constructs an AbstractTestPlan with the given test plan name.
     * Initializes the ISwapList of TestCases.
     * @param testPlanName the name of the test plan
     * @throws IllegalArgumentException if the testPlanName is null or an empty string
     */
	public AbstractTestPlan(String testPlanName) {
		setTestPlanName(testPlanName);
        testCases = new SwapList<TestCase>();
	}
	
	/**
     * Sets the test plan name.
     * @param testPlanName the name of the test plan
     * @throws IllegalArgumentException if the testPlanName is null or an empty string
     */
	public void setTestPlanName(String testPlanName) {
		if (testPlanName == null || testPlanName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name.");
        }
        this.testPlanName = testPlanName.trim();
	}
	
	/**
     * Gets the test plan name.
     * @return the name of the test plan
     */
	public String getTestPlanName() {
		return testPlanName;
	}
	
	/**
	 * Gets the list of TestCases
	 * @return list of TestCases
	 */
	public ISwapList<TestCase> getTestCases() {
		return testCases;
	}
	
	/**
     * Adds a TestCase to the end of the list.
     * @param t the TestCase to add
     */
	public void addTestCase(TestCase t) {
		if (t == null) {
	        throw new IllegalArgumentException("Cannot add passing test case.");
	    }
		testCases.add(t);
	}
	
	/**
    * Removes the TestCase at the given index from the list.
    * @param idx the index of the TestCase to remove
    * @return the removed TestCase
    */
	public TestCase removeTestCase(int idx) {
		return testCases.remove(idx);
	}
	
	/**
     * Gets the TestCase at the given index.
     * @param idx the index of the TestCase to retrieve
     * @return the TestCase at the given index
     */
	public TestCase getTestCase(int idx) {
		if (idx < 0 || idx >= testCases.size()) {
	        throw new IndexOutOfBoundsException("Invalid index.");
	    }
	    return testCases.get(idx);
	}
	
	/**
     * Counts the number of TestCases that are failing.
     * @return the number of failing TestCases
     */
	public int getNumberOfFailingTests() {
		int count = 0;
        for (int i = 0; i < testCases.size(); i++) {
            if (!testCases.get(i).isTestCasePassing()) {
                count++;
            }
        }
        return count;
	}
	
	/**
     * Sends the test result parameters to the TestCase at the given index.
     * @param idx the index of the TestCase
     * @param passing true if the test passed, false otherwise
     * @param actualResults the actual results of the test
     */
	public void addTestResult(int idx, boolean passing, String actualResults) {
		testCases.get(idx).addTestResult(passing, actualResults);
	}
	
	/**
     * Returns a 2D String array representation of the TestCases.
     * @return a 2D String array representing the TestCases
     */
	public String[][] getTestCasesAsArray() {
		String[][] testCasesArray = new String[testCases.size()][4];
	    for (int i = 0; i < testCases.size(); i++) {
	        testCasesArray[i][0] = testCases.get(i).getTestCaseId();
	        testCasesArray[i][1] = testCases.get(i).getTestType();
	        testCasesArray[i][2] = testCases.get(i).getTestDescription();
	        testCasesArray[i][3] = testCases.get(i).getExpectedResults();
	    }
	    return testCasesArray;
	}
	
	/**
     * Generates a hash code for the AbstractTestPlan.
     * @return the hash code
     */
    @Override
    public int hashCode() {
    	return testPlanName.toLowerCase().hashCode();
	}
	
	/**
     * Compares this AbstractTestPlan to another object for equality.
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractTestPlan other = (AbstractTestPlan) obj;
        return testPlanName.equalsIgnoreCase(other.testPlanName);
	}
}
