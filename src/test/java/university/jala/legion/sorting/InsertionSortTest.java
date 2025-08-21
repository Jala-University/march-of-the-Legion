package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import university.jala.legion.model.units.Commander;
import university.jala.legion.model.units.Medic;
import university.jala.legion.model.units.Infantry;
import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest {

    public static void main(String[] args) {
        System.out.println("Running InsertionSort Tests...");

        // Test Case 1: Sort by rank
        System.out.println("\n--- Test 1: Sort by Rank ---");
        List<Character> units = new ArrayList<>();
        units.add(new Infantry("c")); // rank 4
        units.add(new Commander("c")); // rank 0
        units.add(new Medic("c")); // rank 1

        InsertionSort sorter = new InsertionSort();
        sorter.sort(units);

        boolean passed = units.get(0).getRank() == 0 &&
                units.get(1).getRank() == 1 &&
                units.get(2).getRank() == 4;

        System.out.println("  Testing: Sort by rank");
        System.out.println("  Assertion: Units should be sorted by rank in ascending order");
        if (passed) {
            System.out.println("  Result: PASSED");
        } else {
            System.out.println("  Result: FAILED - Units not sorted correctly. Ranks: " +
                    units.get(0).getRank() + ", " +
                    units.get(1).getRank() + ", " +
                    units.get(2).getRank());
        }
    }
}
