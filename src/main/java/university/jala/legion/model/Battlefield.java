// Represents the battlefield grid and manages unit placement.

package university.jala.legion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Battlefield {
    private final int size;
    private final Character[][] grid;
    private final List<Character> units;
    private final Random random;

    public Battlefield(int size) {
        this.size = size;
        this.grid = new Character[size][size];
        this.units = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Places units randomly on the battlefield.
     * @param units List of units to place
     */
    public void placeUnitsRandomly(List<Character> units) {
        this.units.clear();
        this.units.addAll(units);

        // Clear the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;
            }
        }

        // Place each unit randomly
        for (Character unit : units) {
            Position position;
            do {
                position = new Position(random.nextInt(size), random.nextInt(size));
            } while (!isPositionEmpty(position));
            placeUnit(unit, position);
        }
    }

    private boolean isPositionEmpty(Position position) {
        return grid[position.getRow()][position.getColumn()] == null;
    }

    private void placeUnit(Character unit, Position position) {
        grid[position.getRow()][position.getColumn()] = unit;
        unit.setPosition(position);
    }

    /**
     * Renders the initial battlefield in ASCII format.
     * @param useNumeric Whether to use numeric representation
     * @return String representation of the battlefield
     */
    public String renderInitial(boolean useNumeric) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Character unit = grid[i][j];
                if (unit == null) {
                    sb.append("* ");
                } else {
                    if (useNumeric) {
                        sb.append(unit.getNumericRange()).append(" ");
                    } else {
                        sb.append(unit.getSymbol()).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    /**
     * Renders the final battlefield in ASCII format with the new positions.
     * This method now handles the fixed South orientation.
     * @param useNumeric Whether to use numeric representation
     * @return String representation of the battlefield
     */
    public String renderFinal(boolean useNumeric) {
        StringBuilder sb = new StringBuilder();
        // Clear the grid to place the sorted units
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;
            }
        }

        // Place sorted units. The example shows a South orientation.
        // Units are sorted from lowest rank to highest (e.g., C, M, T, S, I)
        // They are placed from bottom-left to top-right.
        int unitIndex = 0;
        for (int j = 0; j < size; j++) { // Column
            for (int i = size - 1; i >= 0; i--) { // Row (from bottom)
                if (unitIndex < units.size()) {
                    grid[i][j] = units.get(unitIndex);
                    unitIndex++;
                }
            }
        }

        // Render the final grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Character unit = grid[i][j];
                if (unit == null) {
                    sb.append("* ");
                } else {
                    if (useNumeric) {
                        sb.append(unit.getNumericRange()).append(" ");
                    } else {
                        sb.append(unit.getSymbol()).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString().trim();
    }


    public List<Character> getUnits() {
        return new ArrayList<>(units);
    }
}