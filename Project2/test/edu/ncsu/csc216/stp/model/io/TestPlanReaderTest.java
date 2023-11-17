/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * This JUnit test class tests the methods of the TestPlanReader class
 * @author Kaushya and Kavya
 *
 */
class TestPlanReaderTest {
	
	/** Valid course records */
	private final String validTestFile = "test-files/test-plans0.txt";
	/** Invalid course records */
	private final String invalidTestFile = "test-files/test-plans3.txt";
	/** Array to hold expected results */
	private ISortedList<TestPlan> testPlans = new SortedList<TestPlan>();
	
	/**
	 * adds valid testPlans to list before each test
	 * 
	 */
	@Before
	public void setUp() {
		TestPlan testPlan = new TestPlan("WolfScheduler");
		testPlans.add(testPlan);
		TestCase t1 = new TestCase("test1", "Equivalence Class", "description\n"
				+ "with multiple lines", "expected results\n" + "with multiple lines");
		t1.addTestResult(true, "actual results");
		t1.addTestResult(false, "actual results on\n" + "multiple lines");
		t1.addTestResult(true, "actual results" + "on three\n" + "lines");
		testPlan.addTestCase(t1);
		TestCase t2 = new TestCase("test2", "Boundary Value", "description", "expected results");
		testPlan.addTestCase(t2);
		TestCase t3 = new TestCase("test3", "Requirements", "description\n" + "on multiple lines", "expected results");
		t3.addTestResult(false, "actual results");
		testPlan.addTestCase(t3);
		
		TestPlan testPlan2 = new TestPlan("PackScheduler");
		testPlans.add(testPlan2);
		TestCase t1P = new TestCase("test0", "Invalid", "description", "expected results\n" + "with multiple lines");
		t1P.addTestResult(true, "actual results");
		t1P.addTestResult(false, "actual results");
		testPlan.addTestCase(t1);
		TestCase t2P = new TestCase("test1", "Equivalence Class", "description", "expected results");
		t2P.addTestResult(true, "actual results");
		testPlan.addTestCase(t2);
	
	}

	/**
	 * Test method for reading the test cases file
	 */
	@Test
	void testReadTestPlansFile() {
		ISortedList<TestPlan> test = TestPlanReader.readTestPlansFile(new File(validTestFile));
		assertEquals(2, test.size());
		
		for (int i = 0; i < testPlans.size(); i++) {
			assertEquals(testPlans.get(i), test.get(i));
		}
		
		try {
			TestPlanReader.readTestPlansFile(new File(invalidTestFile));
			fail("Unexpected error reading " + invalidTestFile);
		} catch (IllegalArgumentException e) {
			//if true
		}
	}

}
