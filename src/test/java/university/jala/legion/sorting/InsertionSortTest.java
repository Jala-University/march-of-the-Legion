// InsertionSortTest.java
// This class provides a simple unit test for the InsertionSort class,
// printing the results to the console without a testing framework.

package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import university.jala.legion.model.units.Commander;
import university.jala.legion.model.units.Medic;
import university.jala.legion.model.units.Tank;
import university.jala.legion.model.units.Sniper;
import university.jala.legion.model.units.Infantry;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class InsertionSortTest {

    public static void main(String[] args) {
        System.out.println("Running InsertionSort Tests...");

        // Test Case 1: Unsorted list
        System.out.println("\n--- Test 1: Unsorted List ---");
        List<Character> units1 = createTestUnits(new Infantry(), new Commander(), new Sniper(), new Medic(), new Tank());
        List<Character> expected1 = createTestUnits(new Commander(), new Medic(), new Tank(), new Sniper(), new Infantry());
        runTest(units1, expected1);

        // Test Case 2: Already sorted list
        System.out.println("\n--- Test 2: Already Sorted List ---");
        List<Character> units2 = createTestUnits(new Commander(), new Medic(), new Tank(), new Sniper(), new Infantry());
        List<Character> expected2 = createTestUnits(new Commander(), new Medic(), new Tank(), new Sniper(), new Infantry());
        runTest(units2, expected2);

        // Test Case 3: List with duplicate ranks
        System.out.println("\n--- Test 3: List with Duplicates ---");
        List<Character> units3 = createTestUnits(new Sniper(), new Commander(), new Sniper(), new Medic(), new Medic(), new Tank());
        List<Character> expected3 = createTestUnits(new Commander(), new Medic(), new Medic(), new Tank(), new Sniper(), new Sniper());
        runTest(units3, expected3);

        // Test Case 4: Empty list
        System.out.println("\n--- Test 4: Empty List ---");
        List<Character> units4 = new ArrayList<>();
        List<Character> expected4 = new ArrayList<>();
        runTest(units4, expected4);
    }

    /**
     * Helper method to run a single test case and print the results.
     * @param units The list of units to be sorted.
     * @param expected The expected sorted list.
     */
    private static void runTest(List<Character> units, List<Character> expected) {
        System.out.println("Initial List (Ranks): " + getRanks(units));

        InsertionSort sorter = new InsertionSort();
        sorter.sort(units);

        System.out.println("Sorted List (Ranks): " + getRanks(units));
        System.out.println("Expected List (Ranks): " + getRanks(expected));

        boolean passed = compareLists(units, expected);
        if (passed) {
            System.out.println("Test PASSED!");
        } else {
            System.out.println("Test FAILED!");
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

    /**
     * Helper method to extract ranks from a list of units for easy printing.
     * @param units The list of units.
     * @return A string representation of the ranks.
     */
    private static String getRanks(List<Character> units) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < units.size(); i++) {
            sb.append(units.get(i).getRank());
            if (i < units.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Helper method to compare two lists of units based on their ranks.
     * @param list1 The first list.
     * @param list2 The second list.
     * @return True if the lists are equal, false otherwise.
     */
    private static boolean compareLists(List<Character> list1, List<Character> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        // It is sufficient to compare ranks since the sorting is based on them.
        List<Integer> ranks1 = new ArrayList<>();
        list1.forEach(unit -> ranks1.add(unit.getRank()));
        List<Integer> ranks2 = new ArrayList<>();
        list2.forEach(unit -> ranks2.add(unit.getRank()));
        return ranks1.equals(ranks2);
    }
}
