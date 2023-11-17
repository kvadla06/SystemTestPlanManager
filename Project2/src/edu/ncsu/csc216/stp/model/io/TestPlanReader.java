/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * Reads test plans from a file.
 * @author Kaushya and Kavya
 *
 */
public class TestPlanReader {
	
	
	/**
	 * This method receives a File with the file to read from
	 * 
	 * @param file the file to read from
	 * @return a sorted list of TestPlans
	 * @throws IllegalArgumentException if the file cannot be loaded
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file) {
		String fileName = "";
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file)); 
			String line1 = fileReader.nextLine();
			if (line1.charAt(0) != '!') {
				throw new IllegalArgumentException("Unable to load file.");
			} else {
				fileName += line1 + "\n";
			}
		    while (fileReader.hasNextLine()) { 
		            fileName += fileReader.nextLine() + "\n";
		    }    
	    } catch (FileNotFoundException e) {
	    	throw new IllegalArgumentException("Unable to load file.");
	    }   	
		Scanner testPlanReader = new Scanner(fileName);
		testPlanReader.useDelimiter("\\r?\\n?[!] ");
		ISortedList<TestPlan> testPlans = new SortedList<TestPlan>(); 
		while (testPlanReader.hasNext()) {
			String testPlan = testPlanReader.next();
			TestPlan testPlanReturn = processTestPlan(testPlan);
			testPlans.add(testPlanReturn);
			
		}
		testPlanReader.close();
		return testPlans;
	}
	
	/**
     * Processes a test plan token and returns a TestPlan object.
     * 
     * @param testPlanToken the test plan token to process
     * @return a TestPlan object
     */
	private static TestPlan processTestPlan(String testPlanToken) {
		Scanner testReader = new Scanner(testPlanToken);
		String testPlanName = testReader.nextLine();
		TestPlan testPlan = new TestPlan(testPlanName);
		testReader.useDelimiter("\\r?\\n?[#] ");
		while(testReader.hasNext()) {
			String testCase = testReader.next();
			processTest(testPlan, testCase);
		}
		testReader.close();
		return testPlan;
	}
	
	/**
     * Processes a test case token and returns a TestCase object.
     * 
     * @param testPlan the test plan associated with the test case
     * @param testCaseToken the test case token to process
     * @return a TestCase object
     */
	private static TestCase processTest(AbstractTestPlan testPlan, String testCaseToken) {
		Scanner testCaseReader = new Scanner(testCaseToken);
		String idType = testCaseReader.nextLine();
		Scanner testCaseReaderValue = new Scanner(idType);
		testCaseReaderValue.useDelimiter("\\r?\\n?[,]");
		String id = "";
		String type = "";
		String description = "";
		String expected = "";
		try {
			id = testCaseReaderValue.next();
			type = testCaseReaderValue.next();
		} catch (IllegalArgumentException | NoSuchElementException e) {
			testCaseReader.close();
		}
		if (!testCaseReader.hasNext()) {
			testCaseReader.close();
			throw new IllegalArgumentException();
		} else {
			testCaseReader.useDelimiter("\\r?\\n?[-] ");
			try {
				String descExpect = testCaseReader.next();
				Scanner newValue = new Scanner(descExpect);
				newValue.useDelimiter("\\r?\\n?[*] ");
				description = newValue.next();
				expected = newValue.next();
				newValue.close();
			} catch (NoSuchElementException e) {
				//
			}
			
		}
		TestCase testCase = new TestCase(id, type, description, expected);
		try {
			while (testCaseReader.hasNext()) {
				String result = testCaseReader.next();
				Scanner resultReader = new Scanner(result);
				resultReader.useDelimiter(": ");
				String bool = resultReader.next();
				boolean testResult = false;
				
				switch (bool) {
				case "PASS": 
					testResult = true;
					break;
				case "FAIL":
					testResult = false;
					break;
				}
				String results = resultReader.next();
				resultReader.close();
				testCase.addTestResult(testResult, results);
				
			}
		} catch (NoSuchElementException e) {
			//
		}
		testCaseReader.close();
		return testCase;
	}
}
