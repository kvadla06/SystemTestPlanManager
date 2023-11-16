/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;
import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Represents a test plan.
 * This class extends AbstractTestPlan and implements Comparable interface.
 * 
 * @author Kaushya and Kavya
 *
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {
	
	/**
     * Constructs a TestPlan with the given name.
     * 
     * @param testPlanName the name of the test plan
     * @throws IllegalArgumentException if the proposed name is the same as FAILING_TEST_LIST_NAME (case insensitive)
     */
	public TestPlan(String testPlanName) {
		super(testPlanName);
		// FailingListTest or FailingTestList
        if (testPlanName.equalsIgnoreCase(FailingTestList.FAILING_TEST_LIST_NAME)) {
            throw new IllegalArgumentException("Invalid name.");
        }
	}
	
	/**
     * Returns a 2D String array representation of the TestCases.
     * The first column is the test case id, the second column is the test type, 
     * and the third column is pass or fail
     * 
     * @return a 2D String array representing the TestCases
     */
	public String[][] getTestCassesAsArray() {
		int size = getTestCases().size();
        String[][] testCasesArray = new String[size][3];
        for (int i = 0; i < size; i++) {
            TestCase testCase = getTestCase(i);
            testCasesArray[i][0] = testCase.getTestCaseId();
            testCasesArray[i][1] = testCase.getTestType();
            testCasesArray[i][2] = testCase.isTestCasePassing() ? "PASS" : "FAIL";
        }
        return testCasesArray;
	}
	
	/** 
	 * Adds a test case to the TestPlan and sets the TestCase
	 *TestPlan to the current TestPlan.
	 *
	 * @param t the TestCase to add
	 */
	@Override
	public void addTestCase(TestCase t) {
		super.addTestCase(t);
        t.setTestPlan(this);
	}
	
	/**
	 * Compares the names of the TestPlans in a case insensitive manner.
	 * 
	 * @param t the TestPlan to compare to
	 * @return 0 integer
	 */
	public int compareTo(TestPlan t) {
		return this.getTestPlanName().compareToIgnoreCase(t.getTestPlanName());
	}

}
