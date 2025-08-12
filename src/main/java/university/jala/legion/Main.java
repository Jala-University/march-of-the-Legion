package university.jala.legion;

import university.jala.legion.cli.Parameters;
import university.jala.legion.model.Battlefield;
import university.jala.legion.model.Character;
import university.jala.legion.model.units.*;
import university.jala.legion.sorting.SortingStrategy;
import university.jala.legion.sorting.SortingStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse command line parameters
            Parameters params = new Parameters(args);

            // Get sorting strategy and unit distribution
            SortingStrategy sortingStrategy = SortingStrategyFactory.createStrategy(params.getAlgorithm());
            int[] distribution = params.getUnitDistribution();
            int totalTroops = calculateTotalTroops(distribution);

            // Display the program parameters in the requested format
            System.out.println("Algorithm: [" + sortingStrategy.getName() + "]");
            System.out.println("Type: [" + (params.getType().equals("c") ? "Character" : "Numeric") + "]");
            System.out.println("Orientation: [" + getOrientationName(params.getOrientation()) + "]");
            System.out.println("Troops: [" + totalTroops + "]");
            System.out.println("Battlefield: [" + params.getBattlefieldSize() + " x " + params.getBattlefieldSize() + "]");

            // Create battlefield
            Battlefield battlefield = new Battlefield(params.getBattlefieldSize());

            // Create units based on distribution
            List<Character> units = createUnits(distribution);

            // Place units randomly
            battlefield.placeUnitsRandomly(units);

            // Display initial battlefield
            System.out.println("\nInitial Position:");
            System.out.println(battlefield.render(params.getType().equals("n")));

            System.out.println("\nApplying " + sortingStrategy.getName() + "...");

            long startTime = System.currentTimeMillis();
            sortingStrategy.sort(units);
            long endTime = System.currentTimeMillis();

            // Apply new positions according to orientation
            battlefield.applyNewPositions(units, params.getOrientation());

            // Display final battlefield
            System.out.println("\nFinal Position:");
            System.out.println(battlefield.render(params.getType().equals("n")));

            // Display execution time
            System.out.println("\nExecution time: " + (endTime - startTime) + "ms");

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
        for (int i = 0; i < distribution[0]; i++) {
            units.add(new Commander());
        }
        for (int i = 0; i < distribution[1]; i++) {
            units.add(new Medic());
        }
        for (int i = 0; i < distribution[2]; i++) {
            units.add(new Tank());
        }
        for (int i = 0; i < distribution[3]; i++) {
            units.add(new Sniper());
        }
        for (int i = 0; i < distribution[4]; i++) {
            units.add(new Infantry());
        }

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

    /**
     * Converts a single-character orientation code to its full name.
     * @param orientationCode The single-character code ('n', 's', 'e', 'w').
     * @return The full name of the orientation.
     */
    private static String getOrientationName(String orientationCode) {
        return switch (orientationCode.toLowerCase()) {
            case "n" -> "North";
            case "s" -> "South";
            case "e" -> "East";
            case "w" -> "West";
            default -> orientationCode; // Fallback for invalid codes
        };
    }
}
