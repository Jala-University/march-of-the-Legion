// Application entry point for the March of the Legion simulator.

package university.jala.legion;

import university.jala.legion.cli.Parameters;
import university.jala.legion.model.Battlefield;
import university.jala.legion.model.Character;
import university.jala.legion.model.units.*;
import university.jala.legion.sorting.InsertionSort;
import university.jala.legion.sorting.SortingStrategy;
import university.jala.legion.sorting.SortingStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse command line parameters
            Parameters params = new Parameters(args);

            // Get sorting strategy and unit distribution. Only InsertionSort is used.
            SortingStrategy sortingStrategy = new InsertionSort();
            int[] distribution = params.getUnitDistribution();
            int totalTroops = calculateTotalTroops(distribution);

            // Display the program parameters in the requested format
            System.out.println("Algorithm: [" + sortingStrategy.getName() + "]");
            System.out.println("Type: [" + (params.getType().equals("c") ? "Character" : "Numeric") + "]");
            System.out.println("Troops: [" + totalTroops + "]");
            System.out.println("Battlefield: [6 x 6]");

            // Create battlefield and units with a fixed size of 6
            Battlefield battlefield = new Battlefield(6);
            List<Character> units = createUnits(distribution);

            // Place units randomly
            battlefield.placeUnitsRandomly(units);

            // Display initial battlefield
            System.out.println("\nInitial Position:");
            System.out.println(battlefield.renderInitial(params.getType().equals("n")));

            // Sort units using the fixed Insertion Sort
            sortingStrategy.sort(units);

            // Display final battlefield. The rendering logic now handles the final placement.
            System.out.println("\nFinal Position:");
            System.out.println(battlefield.renderFinal(params.getType().equals("n")));

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Creates a list of military units based on the given distribution.
     * @param distribution An array of integers representing the number of units of each type.
     * @return A list of Character objects.
     */
    private static List<Character> createUnits(int[] distribution) {
        List<Character> units = new ArrayList<>();

        // Create units in order: Commander, Medic, Tank, Sniper, Infantry
        // 0: Commander, 1: Medic, 2: Tank, 3: Sniper, 4: Infantry
        for (int i = 0; i < distribution[0]; i++) units.add(new Commander());
        for (int i = 0; i < distribution[1]; i++) units.add(new Medic());
        for (int i = 0; i < distribution[2]; i++) units.add(new Tank());
        for (int i = 0; i < distribution[3]; i++) units.add(new Sniper());
        for (int i = 0; i < distribution[4]; i++) units.add(new Infantry());

        return units;
    }

    /**
     * Calculates the total number of troops from a distribution array.
     * @param distribution The unit distribution array.
     * @return The total number of units.
     */
    private static int calculateTotalTroops(int[] distribution) {
        int total = 0;
        for (int count : distribution) {
            total += count;
        }
        return total;
    }
}