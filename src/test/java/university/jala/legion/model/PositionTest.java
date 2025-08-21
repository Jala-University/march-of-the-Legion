// This class provides a simple unit test for the Position class,
// printing the results to the console without a testing framework.

package university.jala.legion.model;

public class PositionTest {

    public static void main(String[] args) {
        System.out.println("Running Position Tests...");

        // Test Case 1: Constructor and getters
        System.out.println("\n--- Test 1: Constructor and Getters ---");
        Position pos1 = new Position(2, 3);
        runTest("Constructor and getters",
                pos1.getX() == 2 && pos1.getY() == 3,
                "Position(2, 3)",
                "Expected row: 2, actual row: " + pos1.getX() +
                        " | Expected column: 3, actual column: " + pos1.getY());

        // Test Case 2: Equality with same position
        System.out.println("\n--- Test 2: Equality with Same Position ---");
        Position pos2 = new Position(2, 3);
        runTest("Equality with same position",
                pos1.equals(pos2),
                "Position(2, 3).equals(Position(2, 3))",
                "Positions should be equal");

        // Test Case 3: Inequality with different row
        System.out.println("\n--- Test 3: Inequality with Different Row ---");
        Position pos3 = new Position(5, 3);
        runTest("Inequality with different row",
                !pos1.equals(pos3),
                "Position(2, 3).equals(Position(5, 3))",
                "Positions should not be equal");

        // Test Case 4: Inequality with different column
        System.out.println("\n--- Test 4: Inequality with Different Column ---");
        Position pos4 = new Position(2, 8);
        runTest("Inequality with different column",
                !pos1.equals(pos4),
                "Position(2, 3).equals(Position(2, 8))",
                "Positions should not be equal");

        // Test Case 5: toString method
        System.out.println("\n--- Test 5: toString Method ---");
        runTest("toString method",
                pos1.toString().equals("(2,3)"),
                "Position(2, 3).toString()",
                "Expected string: \"(2,3)\", actual string: \"" + pos1.toString() + "\"");

        // Test Case 6: hashCode consistency
        System.out.println("\n--- Test 6: HashCode Consistency ---");
        runTest("hashCode consistency",
                pos1.hashCode() == pos2.hashCode(),
                "Position(2, 3).hashCode() == Position(2, 3).hashCode()",
                "Hash codes for equal objects should be the same");

        // Test Case 7: Equality with null object
        System.out.println("\n--- Test 7: Equality with Null Object ---");
        Position posNull = null;
        runTest("Equality with null object",
                !pos1.equals(posNull),
                "Position(2, 3).equals(null)",
                "Position should not be equal to null");
    }

    /**
     * Helper method to run a single test case and print the results.
     * @param testName A descriptive name for the test.
     * @param result The boolean result of the test assertion.
     * @param assertion A string describing the assertion.
     * @param message A message to print if the test fails.
     */
    private static void runTest(String testName, boolean result, String assertion, String message) {
        System.out.println("  Testing: " + testName);
        System.out.println("  Assertion: " + assertion);
        if (result) {
            System.out.println("  Result: PASSED");
        } else {
            System.out.println("  Result: FAILED - " + message);
        }
    }
}
