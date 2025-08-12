package university.jala.legion.sorting;

import university.jala.legion.model.Character;
import java.util.List;

public interface SortingStrategy {
    void sort(List<Character> units);
    String getName();
}