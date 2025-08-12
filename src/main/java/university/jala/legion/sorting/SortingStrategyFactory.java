package university.jala.legion.sorting;

/**
 * Factory class for creating sorting strategy instances.
 */
public class SortingStrategyFactory {
    public static SortingStrategy createStrategy(String code) {
        return switch (code.toLowerCase()) {
            // Updated to include only the required algorithms
            case "c" -> new CountingSort();  // Counting Sort
            case "r" -> new RadixSort();     // Radix Sort
            case "q" -> new QuickSort();     // Quick Sort
            case "i" -> new InsertionSort(); // Insertion Sort
            default -> throw new IllegalArgumentException("Invalid sorting algorithm code. Valid codes are: c (Counting), r (Radix), q (Quick), i (Insertion)");
        };
    }
}
