/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import edu.ncsu.csc216.stp.model.io.TestPlanReader;
import edu.ncsu.csc216.stp.model.io.TestPlanWriter;
import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.ISwapList;
import edu.ncsu.csc216.stp.model.util.SortedList;

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
	private ISortedList<TestPlan> testPlans;
	
	/**
	 * TestPlanManager constructor
	 */
	public TestPlanManager() {
		testPlans = new SortedList<>();
        failingTestList = new FailingTestList();
        currentTestPlan = failingTestList;
        isChanged = false;
	}
	
	/**
	 * Loads test plans from file
	 * @param testPlanFile file to load test plans from
	 */
	public void loadTestPlans(File testPlanFile) {
		ISortedList<TestPlan> loadedTestPlans = TestPlanReader.readTestPlansFile(testPlanFile);
	    for (int i = 0; i < loadedTestPlans.size(); i++) {
	        TestPlan plan = loadedTestPlans.get(i);
	        if (!testPlans.contains(plan)) {
	            testPlans.add(plan);
	        }
	    }
	    getFailingTests();

	    setCurrentTestPlan(FailingTestList.FAILING_TEST_LIST_NAME);
	    isChanged = true;
	}
	
	/**
	 * Save test plans to file
	 * @param testPlanFile file to save test plans to
	 */
	public void saveTestPlans(File testPlanFile) {
	TestPlanWriter.writeTestPlanFile(testPlanFile, testPlans);
		isChanged = false;
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
		if (testPlanName == null || testPlanName.trim().isEmpty()) {
	        throw new IllegalArgumentException("Invalid name.");
	    }
	    
	    if (testPlanName.equalsIgnoreCase(FailingTestList.FAILING_TEST_LIST_NAME)) {
	        throw new IllegalArgumentException("Invalid name.");
	    }
	    
	    for (int i = 0; i < testPlans.size(); i++) {
	        TestPlan plan = testPlans.get(i);
	        if (plan.getTestPlanName().equalsIgnoreCase(testPlanName)) {
	            throw new IllegalArgumentException("Invalid name.");
	        }
	    }
	    
	    TestPlan newerTestPlan = new TestPlan(testPlanName);
	    testPlans.add(newerTestPlan);
	    setCurrentTestPlan(newerTestPlan.getTestPlanName());
	    isChanged = true;
	}
	
	/**
	 * Gets the name of the test plans
	 * @return list of names of test plans
	 */
	public String[] getTestPlanNames() {
		String [] names = new String[testPlans.size() +1];
		names[0] = FailingTestList.FAILING_TEST_LIST_NAME;
		for(int i = 0; i < testPlans.size(); i++) { 
			TestPlan tp = testPlans.get(i);
			names[i + 1] = tp.getTestPlanName();
		}
		return names;
	}
	
	/**
	 * Gets failing tests of test plan
	 */
	private void getFailingTests() {
		failingTestList.clearTests();
		for (int i = 0; i < testPlans.size(); i++) {
			TestPlan tp = testPlans.get(i);
	        ISwapList<TestCase> testCases = tp.getTestCases();
	           for (int j = 0; j < testCases.size(); j++) {
	               TestCase tc = testCases.get(j);
	               if (!tc.isTestCasePassing()) {
	                   failingTestList.addTestCase(tc);
	               }
	           }
		}
	}
	           
	
	/**
	 * Sets current test plan to test plan found with the string parameter
	 * @param testPlanName name of test plan
	 * @throws IllegalArgumentException if the name is invalid
	 */
	public void setCurrentTestPlan(String testPlanName) {
		if (testPlanName == null || testPlanName.trim().isEmpty()) {
			throw new IllegalArgumentException("invlid name.");
		}
		boolean isFound = false;
	    for (int i = 0; i < testPlans.size(); i++) {
	    	TestPlan tp = testPlans.get(i);
	        if (tp.getTestPlanName().equalsIgnoreCase(testPlanName)) {
	        	currentTestPlan = tp;
	        	isFound = true;
	            break;
	        }
	    }
	   if (!isFound) {
		   if (testPlanName.equalsIgnoreCase(FailingTestList.FAILING_TEST_LIST_NAME)) {
			   getFailingTests();
		   }
		   currentTestPlan = failingTestList;
	   }
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
		if (currentTestPlan instanceof FailingTestList) {
	           throw new IllegalArgumentException("The Failing Tests list may not be edited.");
	       }
	       if (testPlanName == null || testPlanName.trim().isEmpty() || testPlanName.equalsIgnoreCase(FailingTestList.FAILING_TEST_LIST_NAME)) {
	           throw new IllegalArgumentException("Invalid name.");
	       }
	       
	       int editIndex = -1;
	       for (int i = 0; i <testPlans.size(); i++) {  
	    	   if (testPlans.get(i).getTestPlanName().equalsIgnoreCase(testPlanName)) {
	    		   throw new IllegalArgumentException("Invalid name.");
	    	   }
	    	   if(testPlans.get(i).equals(currentTestPlan)) {
	    		   editIndex = i;
	    	   }
	       }
	       if (editIndex != -1) {
	    	   testPlans.remove(editIndex);
	    	   ((TestPlan)currentTestPlan).setTestPlanName(testPlanName);
	    	   testPlans.add((TestPlan) currentTestPlan);
	       }
	}
	
	/**
	 * Removes the current test plan and is set to the failing test list
	 * @throws if the currentTestPlan is an FailingTestList with the message “The Failing Tests list may not be deleted.”
	 */
	public void removeTestPlan() {
		if (currentTestPlan instanceof FailingTestList) {
            throw new IllegalArgumentException("The Failing Tests list may not be deleted.");
        }
        int indexToRemove = -1;
        for (int i = 0; i < testPlans.size(); i++) {
            if (testPlans.get(i).equals(currentTestPlan)) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1) {
            testPlans.remove(indexToRemove);
            currentTestPlan = failingTestList;
        }
        isChanged = true;
	}
	
	/**
	 * Add test case to the current test plan
	 * @param t test case to be added to the test plan
	 */
	public void addTestCase(TestCase t) {
		if (currentTestPlan instanceof TestPlan) {
			((TestPlan) currentTestPlan).addTestCase(t);
			if(!t.isTestCasePassing()) {
				getFailingTests();
			}
			isChanged = true;
		}
	}
	
	/**
	 * Adds test result to test case at a given index
	 * @param idx index to add the test case 
	 * @param passing if tests are passing or failing
	 * @param actualResult actual result of the test result
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		if (currentTestPlan instanceof TestPlan) {
			TestCase tc = ((TestPlan) currentTestPlan).getTestCases().get(idx);
			tc.addTestResult(passing, actualResult);
			getFailingTests();
		}
	}
	
	/**
	 * Clears the TestPlan Manager
	 */
	public void clearTestPlans() {
		testPlans = new SortedList<>();
        failingTestList = new FailingTestList();
        currentTestPlan = failingTestList;
	}
}
