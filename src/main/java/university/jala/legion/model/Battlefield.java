package university.jala.legion.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The Battlefield class manages the grid, unit placement, and display logic.
 * It is responsible for creating a square battlefield of a given size,
 * placing units randomly or in a sorted formation, and rendering the grid.
 */
public class Battlefield {
    private final int size;
    private final String[][] grid;
    private final List<Position> availablePositions;
    private final List<Character> currentUnits;

    public Battlefield(int size) {
        this.size = size;
        this.grid = new String[size][size];
        this.availablePositions = new ArrayList<>();
        this.currentUnits = new ArrayList<>();
        initializeGrid();
    }

    /**
     * Fills the battlefield with empty positions.
     */
    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = "*";
                availablePositions.add(new Position(i, j));
            }
        }
    }

    /**
     * Places a list of units randomly on the battlefield grid.
     * @param units The list of units to place.
     */
    public void placeUnitsRandomly(List<Character> units) {
        // Shuffle the available positions to ensure randomness
        Collections.shuffle(availablePositions);

        if (units.size() > availablePositions.size()) {
            throw new IllegalArgumentException("Cannot place more units than the battlefield size allows.");
        }

        for (int i = 0; i < units.size(); i++) {
            Character unit = units.get(i);
            Position pos = availablePositions.get(i);
            grid[pos.getX()][pos.getY()] = unit.getDisplayValue();
            unit.setPosition(pos);
            currentUnits.add(unit);
        }
    }

    /**
     * Places a list of sorted units in a specific formation based on orientation.
     * @param units The list of units, already sorted.
     * @param orientation The formation orientation (n, s, e, w).
     */
    public void placeUnitsInFormation(List<Character> units, String orientation) {
        initializeGrid(); // Clear the battlefield for the final placement

        int unitIndex = 0;
        switch (orientation.toLowerCase()) {
            case "s": // South: Fill from bottom-left, column by column
                for (int col = 0; col < size; col++) {
                    for (int row = size - 1; row >= 0; row--) {
                        if (unitIndex < units.size()) {
                            grid[row][col] = units.get(unitIndex++).getDisplayValue();
                        }
                    }
                }
                break;
            case "n": // North: Fill from top-left, column by column
                for (int col = 0; col < size; col++) {
                    for (int row = 0; row < size; row++) {
                        if (unitIndex < units.size()) {
                            grid[row][col] = units.get(unitIndex++).getDisplayValue();
                        }
                    }
                }
                break;
            case "w": // West: Fill from top-left, row by row
                for (int row = 0; row < size; row++) {
                    for (int col = 0; col < size; col++) {
                        if (unitIndex < units.size()) {
                            grid[row][col] = units.get(unitIndex++).getDisplayValue();
                        }
                    }
                }
                break;
            case "e": // East: Fill from top-right, row by row
                for (int row = 0; row < size; row++) {
                    for (int col = size - 1; col >= 0; col--) {
                        if (unitIndex < units.size()) {
                            grid[row][col] = units.get(unitIndex++).getDisplayValue();
                        }
                    }
                }
                break;
        }
    }

    /**
     * Renders the initial battlefield state to the console.
     * @param isNumeric True if rendering in numeric format, false for character.
     */
    public void renderInitial(boolean isNumeric) {
        render();
    }

    /**
     * Renders the final battlefield state to the console.
     * @param isNumeric True if rendering in numeric format, false for character.
     */
    public void renderFinal(boolean isNumeric) {
        render();
    }

    /**
     * Private helper method to handle the actual grid rendering.
     */
    private void render() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%-4s", grid[i][j]);
            }
            System.out.println();
        }
    }
}