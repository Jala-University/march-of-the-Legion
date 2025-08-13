// BattlefieldTest.java
// This class provides a simple unit test for the Battlefield class,
// printing the results to the console without a testing framework.

package university.jala.legion.model;

import university.jala.legion.model.units.Commander;
import university.jala.legion.model.units.Medic;
import university.jala.legion.model.units.Tank;
import university.jala.legion.model.units.Sniper;
import university.jala.legion.model.units.Infantry;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BattlefieldTest {

    public static void main(String[] args) {
        System.out.println("Running Battlefield Tests...");

        // Test Case 1: Initial unit placement
        System.out.println("\n--- Test 1: Initial Unit Placement ---");
        List<Character> units = createTestUnits(new Commander(), new Medic(), new Tank());
        Battlefield battlefield1 = new Battlefield(6);
        battlefield1.placeUnitsRandomly(units);
        runTest("Initial placement",
                battlefield1.getUnits().size() == 3,
                "The battlefield should contain 3 units after placement.");
        System.out.println("Initial board (symbols): \n" + battlefield1.renderInitial(false));

        // Test Case 2: Final rendering with fixed positions (South orientation)
        System.out.println("\n--- Test 2: Final Render (South Orientation) ---");
        List<Character> sortedUnits = createTestUnits(new Commander(), new Medic(), new Tank(), new Sniper(), new Infantry());
        Battlefield battlefield2 = new Battlefield(6);

        // This is a simplified test. The real sorting would happen before this call.
        battlefield2.placeUnitsRandomly(sortedUnits);
        String finalRenderedBoard = battlefield2.renderFinal(false);
        String expectedFinalBoard = """
* * * * * *
* * * * * *
* * * * * *
C * * * * *
M * * * * *
T S I * * *""";
        // The renderFinal method places sorted units.
        runTest("Final rendering",
                finalRenderedBoard.equals(expectedFinalBoard),
                "The final board should match the expected layout for a South orientation.");
        System.out.println("Final board (symbols): \n" + finalRenderedBoard);
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
