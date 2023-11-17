/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * This JUnit test class tests the methods of the TestPlanWriter class
 * @author Kaushya and Kavya
 *
 */
class TestPlanWriterTest {

	/**
	 * Test method for {@link edu.ncsu.csc216.stp.model.io.TestPlanWriter#writeTestPlanFile(java.io.File, edu.ncsu.csc216.stp.model.util.ISortedList)}.
	 */
	@Test
	void testWriteTestPlanFile() {
		ISortedList<TestPlan> testPlans = new SortedList<TestPlan>();
		TestPlan testPlan = new TestPlan("TestPlan1");
		testPlans.add(testPlan);
		TestCase t1 = new TestCase("ID 0", "type 0", "description 0", "expected results 0");
		t1.addTestResult(false, "actual results 0-1");
		testPlan.addTestCase(t1);
		TestCase t2 = new TestCase("ID 1", "type 1", "description 1", "expected results 1");
		t2.addTestResult(true, "actual results 1-1");
		t2.addTestResult(false, "actual results 1-2");
		testPlan.addTestCase(t2);
		TestCase t3 = new TestCase("ID 2", "type 2", "description 2", "expected results 2");
		t3.addTestResult(true, "actual results 2-1");
		t3.addTestResult(true, "actual results 2-2");
		testPlan.addTestCase(t3);
		
		TestPlan testPlan2 = new TestPlan("TestPlan2");
		testPlans.add(testPlan2);
		
		
		try {
			TestPlanWriter.writeTestPlanFile(new File("test-files/actual_out.txt"), testPlans);
		} catch (IllegalArgumentException e) {
			fail("Cannot write to course records file");
		}
		
		checkFiles("test-files/expected_out.txt", "test-files/actual_out.txt");
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				String one = expScanner.nextLine();
				String two = actScanner.nextLine();
				assertEquals(one, two);
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}

}
