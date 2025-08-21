package university.jala.legion;

import university.jala.legion.cli.Parameters;
import university.jala.legion.model.Battlefield;
import university.jala.legion.model.Character;
import university.jala.legion.model.units.*;
import university.jala.legion.sorting.SortingStrategy;
import university.jala.legion.sorting.SortingStrategyFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class to run the military unit simulation.
 * It handles command line arguments, sets up the battlefield,
 * and sorts the units based on the provided parameters.
 */
public class Main {

    public static void main(String[] args) {
        try {
            // Parse command line parameters
            Parameters params = new Parameters(args);

            // Get sorting strategy and unit distribution from parameters
            String algorithmCode = params.getAlgorithm();
            String type = params.getType();
            String orientation = params.getOrientation();
            int[] distribution = params.getUnitDistribution();
            int battlefieldSize = params.getBattlefieldSize();

            // Calculate total troops
            int totalTroops = calculateTotalTroops(distribution);

            // Display the program parameters in the requested format
            System.out.println("Algorithm: [" + SortingStrategyFactory.createStrategy(algorithmCode).getName() + "]");
            System.out.println("Type: [" + (type.equals("c") ? "Character" : "Numeric") + "]");
            System.out.println("Orientation: [" + getOrientationName(orientation) + "]");
            System.out.println("Troops: [" + totalTroops + "]");
            System.out.println("Battlefield: [" + battlefieldSize + " x " + battlefieldSize + "]");

            // Create battlefield and units
            Battlefield battlefield = new Battlefield(battlefieldSize);
            List<Character> units = createUnits(distribution, type);

            // Place units randomly
            battlefield.placeUnitsRandomly(units);

            // Display initial battlefield
            System.out.println("\nInitial Position:");
            battlefield.renderInitial(type.equals("n"));

            // Get the correct sorting strategy based on the algorithm parameter
            SortingStrategy sortingStrategy = SortingStrategyFactory.createStrategy(algorithmCode);

            // Sort units based on the selected algorithm
            sortingStrategy.sort(units);

            // Place sorted units on the battlefield according to orientation
            battlefield.placeUnitsInFormation(units, orientation);

            // Display final battlefield
            System.out.println("\nFinal Position:");
            battlefield.renderFinal(type.equals("n"));

        } catch (IllegalArgumentException e) {
            // Catch and print validation errors
            System.err.println("Error: " + e.getMessage());
            System.out.println("Usage: java Troops a=<algo> t=<type> o=<orientation> u=<distribution> f=<size>");
            System.out.println("Example: java Troops a=i t=c o=s u=1,2,5,5,10 f=10");
        }
    }

    /**
     * Calculates the total number of troops from the distribution array.
     * @param distribution The array representing the number of units of each type.
     * @return The total number of units.
     */
    private static int calculateTotalTroops(int[] distribution) {
        return Arrays.stream(distribution).sum();
    }

    /**
     * Helper method to get the full name of the orientation.
     * @param orientation The orientation code (n, s, e, w).
     * @return The full orientation name.
     */
    private static String getOrientationName(String orientation) {
        return switch (orientation.toLowerCase()) {
            case "n" -> "North";
            case "s" -> "South";
            case "e" -> "East";
            case "w" -> "West";
            default -> "Unknown";
        };
    }

    /**
     * Creates a list of military units based on the distribution and type parameters.
     * The unit rank is determined by the order in the distribution array.
     *
     * @param distribution The array with the number of units for each type.
     * @param type The type of units (numeric or character).
     * @return A list of created Character objects.
     */
    private static List<Character> createUnits(int[] distribution, String type) {
        List<Character> units = new ArrayList<>();
        // Commander (Rank 0)
        for (int i = 0; i < distribution[0]; i++) {
            units.add(new Commander(type));
        }
        // Medic (Rank 1)
        for (int i = 0; i < distribution[1]; i++) {
            units.add(new Medic(type));
        }
        // Tank (Rank 2)
        for (int i = 0; i < distribution[2]; i++) {
            units.add(new Tank(type));
        }
        // Sniper (Rank 3)
        for (int i = 0; i < distribution[3]; i++) {
            units.add(new Sniper(type));
        }
        // Infantry (Rank 4)
        for (int i = 0; i < distribution[4]; i++) {
            units.add(new Infantry(type));
        }
        return units;
    }
}