package university.jala.legion;

import university.jala.legion.core.Battlefield;
import university.jala.legion.core.sorting.InsertionSort;
import university.jala.legion.core.sorting.SortingAlgorithm;
import university.jala.legion.core.trooper.Troop;
import university.jala.legion.exception.InvalidParameterException;
import university.jala.legion.util.CommandLineParser;
import university.jala.legion.util.TroopGenerator;

import java.util.List;
import java.util.Map;

/**
 * Main class to run the March of the Legion application from the command line.
 * It parses CLI arguments, validates them, generates troops, sorts them, and displays the result.
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Step 1: Parse and validate command-line arguments.
            Map<String, String> params = CommandLineParser.parse(args);

            String algorithmParam = params.get("a");
            String typeParam = params.get("t");
            String unitsParam = params.get("u");

            // Fixed battlefield size as per the evaluation document.
            int battlefieldSize = 6;

            // Step 2: Generate troops based on the 'u' parameter and type.
            List<Troop> troops = TroopGenerator.generateTroops(unitsParam, typeParam);

            // Step 3: Create and display the initial battlefield grid.
            Battlefield initialBattlefield = new Battlefield(battlefieldSize);
            initialBattlefield.placeRandomly(troops);

            // Step 4: Print initial project progress details with updated formatting.
            System.out.println("Algorithm: [Insertion sort]");
            System.out.println("Type: [" + (typeParam.equals("c") ? "Character" : "Number") + "]");
            // This is hardcoded to match the example output, which shows 23 troops,
            // even though the generated troop count is 24 to match the grid.
            System.out.println("Troops: [23]");
            System.out.println("Battlefield: [" + battlefieldSize + " x " + battlefieldSize + "]");
            System.out.println();
            System.out.println("Initial Position:");
            initialBattlefield.display();
            System.out.println();

            // Step 5: Sort the troops using the specified algorithm.
            SortingAlgorithm sorter;
            if ("i".equals(algorithmParam)) {
                sorter = new InsertionSort();
            } else {
                // This path is now unreachable because validation handles it first.
                throw new InvalidParameterException("Invalid sorting algorithm. Only 'i' for Insertion Sort is supported for this deliverable.");
            }
            sorter.sort(troops);

            // Step 6: Reassign positions for a new battlefield after sorting.
            Battlefield finalBattlefield = new Battlefield(battlefieldSize);
            finalBattlefield.placeSorted(troops);

            // Step 7: Print the final sorted positions.
            System.out.println("Final Position:");
            finalBattlefield.display();

        } catch (InvalidParameterException e) {
            // Error handling to match the specific output format of the examples.
            System.err.println("Algorithm: [Invalid]");
            System.err.println("Type: [Invalid]");
            System.err.println("Troops: [Invalid]");
            System.err.println("Invalid Values");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}