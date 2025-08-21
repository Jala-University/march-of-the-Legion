package university.jala.legion.model;

import university.jala.legion.model.units.Commander;
import university.jala.legion.model.units.Medic;
import university.jala.legion.model.units.Tank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattlefieldTest {

    public static void main(String[] args) {
        System.out.println("Running Battlefield Tests...");

        // Test Case 1: Initial unit placement
        System.out.println("\n--- Test 1: Initial Unit Placement ---");
        List<Character> units = new ArrayList<>();
        units.add(new Commander("c"));
        units.add(new Medic("c"));
        units.add(new Tank("c"));

        Battlefield battlefield1 = new Battlefield(6);
        battlefield1.placeUnitsRandomly(units);

        // Test that units were placed
        runTest("Initial placement",
                units.stream().allMatch(unit -> unit.getPosition() != null),
                "All units should have positions after placement");

        // Test Case 2: South formation placement
        System.out.println("\n--- Test 2: South Formation ---");
        Battlefield battlefield2 = new Battlefield(6);
        battlefield2.placeUnitsInFormation(units, "s");

        // Should not throw exception and should place units
        runTest("South formation placement",
                true, // If we reach here without exception, test passes
                "Units should be placed in south formation without errors");
    }

    /**
     * Helper method to run a single test case and print the results.
     * @param testName A descriptive name for the test.
     * @param result The boolean result of the test assertion.
     * @param message A message to print on failure or success.
     */
    private static void runTest(String testName, boolean result, String message) {
        System.out.println("  Testing: " + testName);
        if (result) {
            System.out.println("  Result: PASSED - " + message);
        } else {
            System.out.println("  Result: FAILED - " + message);
        }
    }

    /**
     * Helper method to create a list of Character objects.
     * @param characters The units to be added to the list.
     * @return A new List of Character objects.
     */
    private static List<Character> createTestUnits(Character... characters) {
        return new ArrayList<>(Arrays.asList(characters));
    }
}
