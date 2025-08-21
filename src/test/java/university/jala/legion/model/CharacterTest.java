package university.jala.legion.model;

import university.jala.legion.model.units.Commander;

public class CharacterTest {

    public static void main(String[] args) {
        System.out.println("Running Character Tests...");

        // Test Case 1: Commander with character type
        System.out.println("\n--- Test 1: Commander with Character Type ---");
        Commander commander = new Commander("c");
        runTest("Character type display",
                commander.getDisplayValue().length() == 1 &&
                        java.lang.Character.isLetter(commander.getDisplayValue().charAt(0)),
                "Character display should be a single letter",
                "Display value: " + commander.getDisplayValue());

        // Test Case 2: Commander with numeric type
        System.out.println("\n--- Test 2: Commander with Numeric Type ---");
        Commander numericCommander = new Commander("n");
        runTest("Numeric type display",
                numericCommander.getDisplayValue().matches("\\d+"),
                "Numeric display should be a number",
                "Display value: " + numericCommander.getDisplayValue());
    }

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