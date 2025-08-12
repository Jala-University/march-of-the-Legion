package university.jala.legion.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import university.jala.legion.model.Character;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the InsertionSort class.
 */
class InsertionSortTest {

    private SortingStrategy insertionSort;

    // A concrete subclass of Character for testing.
    static class TestCharacter extends Character {
        public TestCharacter(int rank, char symbol, int numericRange) {
            super(rank, symbol, numericRange);
        }
        @Override
        public String getType() {
            return "TestType";
        }
    }

    @BeforeEach
    void setUp() {
        insertionSort = new InsertionSort();
    }

    /**
     * Creates a list of test characters with specified ranks.
     * @param ranks The ranks for the characters to be created.
     * @return A list of TestCharacter instances.
     */
    private List<Character> createTestUnits(Integer... ranks) {
        List<Character> units = new ArrayList<>();
        for (int rank : ranks) {
            units.add(new TestCharacter(rank, 'X', rank));
        }
        return units;
    }

    @Test
    void testSort_emptyList() {
        List<Character> units = new ArrayList<>();
        insertionSort.sort(units);
        assertTrue(units.isEmpty());
    }

    @Test
    void testSort_singleElementList() {
        List<Character> units = createTestUnits(10);
        insertionSort.sort(units);
        assertEquals(1, units.size());
        assertEquals(10, units.get(0).getRank());
    }

    @Test
    void testSort_alreadySortedList() {
        List<Character> units = createTestUnits(1, 2, 3, 4, 5);
        List<Character> expected = createTestUnits(1, 2, 3, 4, 5);
        insertionSort.sort(units);
        for (int i = 0; i < units.size(); i++) {
            assertEquals(expected.get(i).getRank(), units.get(i).getRank());
        }
    }

    @Test
    void testSort_reverseSortedList() {
        List<Character> units = createTestUnits(5, 4, 3, 2, 1);
        List<Character> expected = createTestUnits(1, 2, 3, 4, 5);
        insertionSort.sort(units);
        for (int i = 0; i < units.size(); i++) {
            assertEquals(expected.get(i).getRank(), units.get(i).getRank());
        }
    }

    @Test
    void testSort_unsortedList() {
        List<Character> units = createTestUnits(5, 2, 8, 1, 9, 4);
        List<Character> expected = createTestUnits(1, 2, 4, 5, 8, 9);
        insertionSort.sort(units);
        for (int i = 0; i < units.size(); i++) {
            assertEquals(expected.get(i).getRank(), units.get(i).getRank());
        }
    }

    @Test
    void testSort_listWithDuplicates() {
        List<Character> units = createTestUnits(5, 2, 8, 5, 1, 9, 4, 2);
        List<Character> expected = createTestUnits(1, 2, 2, 4, 5, 5, 8, 9);
        insertionSort.sort(units);
        for (int i = 0; i < units.size(); i++) {
            assertEquals(expected.get(i).getRank(), units.get(i).getRank());
        }
    }

    @Test
    void testSort_withNullUnits() {
        List<Character> units = null;
        // The sort method should handle this without throwing an exception.
        try {
            insertionSort.sort(units);
            assertTrue(true, "Sort should not throw an exception for a null list.");
        } catch (Exception e) {
            assertTrue(false, "Sort threw an exception: " + e.getMessage());
        }
    }

    @Test
    void testGetName() {
        assertEquals("Insertion Sort", insertionSort.getName());
    }
}
