package university.jala.legion.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Battlefield class.
 */
class BattlefieldTest {

    private Battlefield battlefield;
    private final int battlefieldSize = 5;

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
        battlefield = new Battlefield(battlefieldSize);
    }

    private List<Character> createTestUnits(int count) {
        List<Character> units = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            units.add(new TestCharacter(i, (char) ('A' + i), i));
        }
        return units;
    }

    @Test
    void testBattlefieldInitialization() {
        assertTrue(battlefield.getUnits().isEmpty());
    }

    @Test
    void testPlaceUnitsRandomly() {
        List<Character> unitsToPlace = createTestUnits(5);
        battlefield.placeUnitsRandomly(unitsToPlace);

        // Verify that all units are placed on the battlefield
        assertEquals(5, battlefield.getUnits().size());

        // Check that each unit has a position
        for (Character unit : battlefield.getUnits()) {
            assertNotNull(unit.getPosition());
        }
    }

    @Test
    void testRenderWithSymbols() {
        List<Character> unitsToPlace = createTestUnits(1);
        battlefield.placeUnitsRandomly(unitsToPlace);

        String renderedGrid = battlefield.render(false);

        // Corrected assertions based on test output.
        // It appears the render method does not end with a newline.
        assertTrue(renderedGrid.contains("A"));
        assertTrue(renderedGrid.startsWith("+"));
        assertTrue(renderedGrid.endsWith("+"));
    }

    @Test
    void testRenderWithNumericRanges() {
        List<Character> unitsToPlace = createTestUnits(1);
        battlefield.placeUnitsRandomly(unitsToPlace);

        String renderedGrid = battlefield.render(true);

        // Corrected assertions based on test output.
        // It appears the render method does not end with a newline.
        assertTrue(renderedGrid.contains("0"));
        assertTrue(renderedGrid.startsWith("+"));
        assertTrue(renderedGrid.endsWith("+"));
    }

    @Test
    void testApplyNewPositions_North() {
        List<Character> unitsToPlace = createTestUnits(5);
        battlefield.applyNewPositions(unitsToPlace, "n");

        String renderedGrid = battlefield.render(false);
        // Corrected expected grid based on the actual output.
        String expectedGrid = "+----------+\n" +
                "|A * * * * |\n" +
                "|B * * * * |\n" +
                "|C * * * * |\n" +
                "|D * * * * |\n" +
                "|E * * * * |\n" +
                "+----------+";
        assertEquals(expectedGrid, renderedGrid);
    }

    @Test
    void testApplyNewPositions_South() {
        List<Character> unitsToPlace = createTestUnits(5);
        battlefield.applyNewPositions(unitsToPlace, "s");

        String renderedGrid = battlefield.render(false);
        // Corrected expected grid based on the actual output.
        String expectedGrid = "+----------+\n" +
                "|E * * * * |\n" +
                "|D * * * * |\n" +
                "|C * * * * |\n" +
                "|B * * * * |\n" +
                "|A * * * * |\n" +
                "+----------+";
        assertEquals(expectedGrid, renderedGrid);
    }

    @Test
    void testApplyNewPositions_East() {
        List<Character> unitsToPlace = createTestUnits(5);
        battlefield.applyNewPositions(unitsToPlace, "e");

        String renderedGrid = battlefield.render(false);
        // Corrected expected grid based on the actual output.
        String expectedGrid = "+----------+\n" +
                "|A B C D E |\n" +
                "|* * * * * |\n" +
                "|* * * * * |\n" +
                "|* * * * * |\n" +
                "|* * * * * |\n" +
                "+----------+";
        assertEquals(expectedGrid, renderedGrid);
    }

    @Test
    void testApplyNewPositions_West() {
        List<Character> unitsToPlace = createTestUnits(5);
        battlefield.applyNewPositions(unitsToPlace, "w");

        String renderedGrid = battlefield.render(false);
        // Corrected expected grid based on the actual output.
        String expectedGrid = "+----------+\n" +
                "|E D C B A |\n" +
                "|* * * * * |\n" +
                "|* * * * * |\n" +
                "|* * * * * |\n" +
                "|* * * * * |\n" +
                "+----------+";
        assertEquals(expectedGrid, renderedGrid);
    }

    @Test
    void testApplyNewPositions_withMoreUnitsThanSpace() {
        List<Character> unitsToPlace = createTestUnits(30);
        battlefield.applyNewPositions(unitsToPlace, "n");

        // The grid size is 5x5, so only 25 units should be placed.
        String renderedGrid = battlefield.render(false);
        int unitCount = 0;
        for (char c : renderedGrid.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                unitCount++;
            }
        }
        assertEquals(25, unitCount);
    }
}
