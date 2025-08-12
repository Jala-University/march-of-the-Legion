// CharacterTest.java
// This class provides a simple unit test for the Character class and its concrete subclass,
// printing the results to the console without a testing framework.

package university.jala.legion.model;

import university.jala.legion.model.units.Commander;

public class CharacterTest {

    public static void main(String[] args) {
        System.out.println("Running Character Tests...");

        // Test Case 1: Constructor and getters
        System.out.println("\n--- Test 1: Constructor and Getters ---");
        Commander commander = new Commander();
        runTest("Constructor and getters",
                commander.getRank() == 0 && commander.getSymbol() == 'C' && commander.getNumericRange() == 40,
                "new Commander()",
                "Expected rank: 0, actual rank: " + commander.getRank() +
                        " | Expected symbol: C, actual symbol: " + commander.getSymbol() +
                        " | Expected numeric range: 40, actual range: " + commander.getNumericRange());

        // Test Case 2: setPosition and getPosition
        System.out.println("\n--- Test 2: setPosition and getPosition ---");
        Position position = new Position(5, 5);
        commander.setPosition(position);
        runTest("setPosition and getPosition",
                commander.getPosition() != null && commander.getPosition().equals(position),
                "commander.setPosition(new Position(5, 5))",
                "Expected position: (5,5), actual position: " + (commander.getPosition() != null ? commander.getPosition().toString() : "null"));

        // Test Case 3: toString method
        System.out.println("\n--- Test 3: toString Method ---");
        runTest("toString method",
                commander.toString().equals("C"),
                "commander.toString()",
                "Expected string: \"C\", actual string: \"" + commander.toString() + "\"");
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
