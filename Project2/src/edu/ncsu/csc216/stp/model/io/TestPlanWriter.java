/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * Writes test plans to a file.
 * @author Kaushya and Kavya
 *
 */
public class TestPlanWriter {
	

	/**
     * Writes the list of TestPlans to a file.
     * 
     * @param file the file to write to
     * @param testPlans the list of TestPlans to write to file
     * @throws IllegalArgumentException if unable to save the file
     */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> testPlans) {
		try {
			PrintStream fileWriter = new PrintStream(file);
			for (int i = 0; i < testPlans.size(); i++) {
				ISwapList<TestCase> testCases = testPlans.get(i).getTestCases();
				fileWriter.println("! " + testPlans.get(i).getTestPlanName());
				for (int j = 0; j < testCases.size(); j++) {
					fileWriter.println(testCases.get(j).toString());
				}
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
