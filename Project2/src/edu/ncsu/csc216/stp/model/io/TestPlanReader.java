/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Reads test plans from a file.
 * @author Kaushya and Kavya
 *
 */
public class TestPlanReader {
	
	public TestPlanReader() {	
	}
	
	/**
	 * This method receives a File with the file to read from
	 * 
	 * @param file the file to read from
	 * @return a sorted list of TestPlans
	 * @throws IllegalArgumentException if the file cannot be loaded
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file) {
		return null;
	}
	
	/**
     * Processes a test plan token and returns a TestPlan object.
     * 
     * @param testPlanToken the test plan token to process
     * @return a TestPlan object
     */
	private static TestPlan processTestPlan(String testPlanToken) {
		return null;
	}
	
	/**
     * Processes a test case token and returns a TestCase object.
     * 
     * @param testPlan the test plan associated with the test case
     * @param testCaseToken the test case token to process
     * @return a TestCase object
     */
	private static TestCase processTest(AbstractTestPlan testPlan, String testCaseToken) {
		return null;
	}
}
