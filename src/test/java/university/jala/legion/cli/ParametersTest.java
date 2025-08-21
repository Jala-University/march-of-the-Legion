package university.jala.legion.cli;

import java.util.Arrays;

public class ParametersTest {

    public static void main(String[] args) {
        System.out.println("Running Parameters Tests...");

        // Test Case 1: Valid parameters with all options
        System.out.println("\n--- Test 1: Valid Parameters ---");
        String[] args1 = {"a=i", "u=1,1,1,1,1", "t=c", "o=s", "f=6"};
        runValidTest("Valid parameters", () -> {
            Parameters params = new Parameters(args1);
            return params.getType().equals("c") &&
                    Arrays.equals(params.getUnitDistribution(), new int[]{1, 1, 1, 1, 1}) &&
                    params.getOrientation().equals("s") &&
                    params.getBattlefieldSize() == 6;
        }, "Expected type 'c', distribution {1,1,1,1,1}, orientation 's', size 6");

        // Additional test cases for new parameters...
        // Test orientation validation
        String[] args11 = {"a=i", "u=1,1,1,1,1", "t=c", "o=x"};
        runExceptionTest("Invalid orientation", args11, "Orientation parameter 'o' is required and must be 'n', 's', 'e', or 'w'.");

        // Test battlefield size validation
        String[] args12 = {"a=i", "u=1,1,1,1,1", "t=c", "f=3"};
        runExceptionTest("Invalid battlefield size", args12, "Battlefield size must be between 5 and 1000.");
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
