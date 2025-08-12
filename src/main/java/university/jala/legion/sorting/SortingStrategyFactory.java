package university.jala.legion.sorting;

public class SortingStrategyFactory {
    public static SortingStrategy createStrategy(String algorithmCode) {
        return switch (algorithmCode) {
            case "i" -> new InsertionSort();
            default -> throw new IllegalArgumentException("Invalid sorting algorithm code: " + algorithmCode);
        };
    }
}