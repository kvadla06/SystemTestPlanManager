package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Holds the failing lists of the test plan
 * 
 * @author Kaushya and Kavya
 *
 */
public class FailingTestList extends AbstractTestPlan {
	
	/** The name used to compare the proposed name*/
	public final static String FAILING_TEST_LIST_NAME = "Failing Tests";
	
	/**
	 * Constructs a FailingTestList with the expected name.
	 * 
	 * @throws IllegalArgumentException if the proposed name is the same as FAILING_TEST_LIST_NAME (case insensitive)
	 */
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
	}
	
	/**
	 * Adds a test case to the FailingTestList 
	 * @param t the TestCase to add
	 */
	@Override
	public void addTestCase(TestCase t) {
		 if (t.isTestCasePassing()) {
		        throw new IllegalArgumentException("Cannot add passing test case.");
		    } else {
		        super.addTestCase(t);
		    }
	}

	/**
	 * Adds a test case to the FailingTestList 
	 * @param testPlanName the TestCase to add
	 */
	@Override
	public void setTestPlanName(String testPlanName) {
		if (!testPlanName.equalsIgnoreCase(FAILING_TEST_LIST_NAME)) {
			throw new IllegalArgumentException("The Failing Tests list cannot be edited.");
		}
		super.setTestPlanName(testPlanName);
	}
	
	/**
	 * Returns a 2D String array of the TestCases.
	 * The first column is the test case id, the second column is the test type, 
	 * and the third column is pass or fail
	 * 
	 * @return a 2D String array representing the TestCases
	 */
	@Override
	public String[][] getTestCasesAsArray() {
		int size = getTestCases().size();
	    String[][] testCasesArray = new String[size][3];
	    for (int i = 0; i < size; i++) {
	        TestCase testCase = getTestCase(i);
	        testCasesArray[i][0] = testCase.getTestCaseId();
	        testCasesArray[i][1] = testCase.getTestType();
	        testCasesArray[i][2] = (testCase.getTestPlan() != null) ? testCase.getTestPlan().getTestPlanName() : "";
	    }
	    return testCasesArray;
	}
	
	/**
	 * Clears all tests from the FailingTestList.
	 */
	public void clearTests() {
		while (getTestCases().size() > 0) {
	        getTestCases().remove(0);
		}
	}
}
