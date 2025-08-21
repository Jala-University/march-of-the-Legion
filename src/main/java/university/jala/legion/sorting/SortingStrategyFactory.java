// Factory class for creating instances of SortingStrategy.
package university.jala.legion.sorting;

/**
 * Factory class to create instances of SortingStrategy.
 * This class is a key part of the Factory design pattern,
 * providing a centralized way to instantiate different
 * sorting algorithms based on a given code.
 */
public class SortingStrategyFactory {

    /**
     * Creates and returns a SortingStrategy implementation based on the provided code.
     *
     * @param algorithmCode The code for the desired sorting algorithm (e.g., "i" for Insertion Sort).
     * @return A new instance of the specified SortingStrategy.
     * @throws IllegalArgumentException if the provided algorithm code is not recognized.
     */
    public static SortingStrategy createStrategy(String algorithmCode) {
        return switch (algorithmCode.toLowerCase()) {
            case "i" -> new InsertionSort();
            case "q" -> new QuickSort(); // Placeholder for future implementation
            case "c" -> new CountingSort(); // Placeholder for future implementation
            case "r" -> new RadixSort(); // Placeholder for future implementation
            default -> throw new IllegalArgumentException("Invalid algorithm code: " + algorithmCode);
        };
    }
}