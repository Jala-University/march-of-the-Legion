package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

public class InsertionSort implements SortingStrategy {
    @Override
    public void sort(List<Character> units) {
        for (int i = 1; i < units.size(); i++) {
            Character currentUnit = units.get(i);
            int j = i - 1;
            while (j >= 0 && units.get(j).getRank() > currentUnit.getRank()) {
                units.set(j + 1, units.get(j));
                j--;
            }
            units.set(j + 1, currentUnit);
        }
    }

    @Override
    public String getName() {
        return "Insertion sort";
    }
}