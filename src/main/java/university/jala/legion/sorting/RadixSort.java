package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;
import java.util.Collections;

/**
 * Implements the Radix Sort algorithm.
 * Radix sort is a non-comparative integer sorting algorithm that sorts data
 * with integer keys by grouping keys by the individual digits which share the same
 * significant position and value.
 * <p>
 * This implementation assumes the 'Character' class has a getRank() method
 * that returns an integer rank.
 */
public class RadixSort implements SortingStrategy {

    @Override
    public void sort(List<Character> units) {
        if (units == null || units.size() <= 1) {
            return;
        }

        // Find the maximum rank to know the number of digits
        int maxRank = 0;
        for (Character unit : units) {
            if (unit.getRank() > maxRank) {
                maxRank = unit.getRank();
            }
        }

        // Perform counting sort for every digit, starting from the least significant digit
        for (int exp = 1; maxRank / exp > 0; exp *= 10) {
            countingSortByDigit(units, exp);
        }
    }

    private void countingSortByDigit(List<Character> units, int exp) {
        int n = units.size();
        Character[] output = new Character[n];
        int[] count = new int[10];

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(units.get(i).getRank() / exp) % 10]++;
        }

        // Change count[i] so that it contains the actual position of the digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (units.get(i).getRank() / exp) % 10;
            output[count[digit] - 1] = units.get(i);
            count[digit]--;
        }

        // Copy the output array to the original list
        for (int i = 0; i < n; i++) {
            units.set(i, output[i]);
        }
    }

    @Override
    public String getName() {
        return "Radix Sort";
    }
}
