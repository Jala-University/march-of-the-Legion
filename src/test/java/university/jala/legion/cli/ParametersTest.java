// ParametersTest.java
// This class provides a simple unit test for the Parameters class,
// printing the results to the console without a testing framework.

package university.jala.legion.cli;

import java.util.Arrays;

public class ParametersTest {

    public static void main(String[] args) {
        System.out.println("Running Parameters Tests...");

        // Test Case 1: Valid parameters
        System.out.println("\n--- Test 1: Valid Parameters ---");
        String[] args1 = {"a=i", "u=1,1,1,1,1", "t=c"};
        runValidTest("Valid parameters", () -> {
            Parameters params = new Parameters(args1);
            return params.getType().equals("c") && Arrays.equals(params.getUnitDistribution(), new int[]{1, 1, 1, 1, 1});
        }, "Expected type 'c' and distribution {1,1,1,1,1}");

        // Test Case 2: Missing 'u' parameter
        System.out.println("\n--- Test 2: Missing 'u' parameter ---");
        String[] args2 = {"a=i", "t=c"};
        runExceptionTest("Missing 'u' parameter", args2, "Unit distribution parameter 'u' is required");

        // Test Case 3: Missing 't' parameter
        System.out.println("\n--- Test 3: Missing 't' parameter ---");
        String[] args3 = {"a=i", "u=1,1,1,1,1"};
        runExceptionTest("Missing 't' parameter", args3, "Type parameter 't' is required");

        // Test Case 4: Invalid algorithm 'a' parameter (only 'i' is supported)
        System.out.println("\n--- Test 4: Invalid algorithm 'a' ---");
        String[] args4 = {"a=x", "u=1,1,1,1,1", "t=c"};
        runExceptionTest("Invalid algorithm 'a' parameter", args4, "Only 'a=i' (Insertion Sort) is supported in this version.");

        // Test Case 5: Invalid type 't' parameter (not 'c' or 'n')
        System.out.println("\n--- Test 5: Invalid type 't' ---");
        String[] args5 = {"a=i", "u=1,1,1,1,1", "t=x"};
        runExceptionTest("Invalid type 't' parameter", args5, "Invalid display type code: x");

        // Test Case 6: Unit distribution with too many values
        System.out.println("\n--- Test 6: Unit distribution with too many values ---");
        String[] args6 = {"a=i", "u=1,1,1,1,1,1", "t=c"};
        runExceptionTest("Unit distribution with too many values", args6, "Unit distribution must specify 5 unit types");

        // Test Case 7: Unit distribution with too few values
        System.out.println("\n--- Test 7: Unit distribution with too few values ---");
        String[] args7 = {"a=i", "u=1,1,1,1", "t=c"};
        runExceptionTest("Unit distribution with too few values", args7, "Unit distribution must specify 5 unit types");

        // Test Case 8: Unit distribution with negative count
        System.out.println("\n--- Test 8: Unit distribution with negative count ---");
        String[] args8 = {"a=i", "u=1,-1,1,1,1", "t=c"};
        runExceptionTest("Unit distribution with negative count", args8, "Unit counts cannot be negative");

        // Test Case 9: Unit distribution with total count > 36
        System.out.println("\n--- Test 9: Unit distribution with total count > 36 ---");
        String[] args9 = {"a=i", "u=10,10,10,5,5", "t=c"};
        runExceptionTest("Unit distribution with total count > 36", args9, "Total units exceed battlefield capacity (36)");

        // Test Case 10: Unit distribution with invalid format
        System.out.println("\n--- Test 10: Unit distribution with invalid format ---");
        String[] args10 = {"a=i", "u=1,x,1,1,1", "t=c"};
        runExceptionTest("Unit distribution with invalid format", args10, "Invalid unit count format");
    }

    /**
     * Helper method to run a test that expects a valid outcome.
     * @param testName A descriptive name for the test.
     * @param test The functional interface containing the test logic.
     * @param message A message to print on failure.
     */
    private static void runValidTest(String testName, TestRunnable test, String message) {
        System.out.print("  Testing: " + testName + "...");
        try {
            if (test.run()) {
                System.out.println(" PASSED");
            } else {
                System.out.println(" FAILED - " + message);
            }
        } catch (Exception e) {
            System.out.println(" FAILED - Unexpected exception thrown: " + e.getMessage());
        }
    }

    /**
     * Helper method to run a test that expects an IllegalArgumentException.
     * @param testName A descriptive name for the test.
     * @param args The arguments to pass to the Parameters constructor.
     * @param expectedMessage The expected message of the IllegalArgumentException.
     */
    private static void runExceptionTest(String testName, String[] args, String expectedMessage) {
        System.out.print("  Testing: " + testName + "...");
        boolean passed = false;
        try {
            new Parameters(args);
            System.out.println(" FAILED - Expected IllegalArgumentException, but none was thrown.");
        } catch (IllegalArgumentException e) {
            if (e.getMessage().equals(expectedMessage)) {
                System.out.println(" PASSED");
                passed = true;
            } else {
                System.out.println(" FAILED - Incorrect exception message. Expected: '" + expectedMessage + "', Actual: '" + e.getMessage() + "'");
            }
        } catch (Exception e) {
            System.out.println(" FAILED - Threw an unexpected exception: " + e.getClass().getName());
        }
    }

    @FunctionalInterface
    interface TestRunnable {
        boolean run() throws Exception;
    }
}
