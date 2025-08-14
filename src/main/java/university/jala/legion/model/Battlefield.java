package university.jala.legion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the battlefield grid and manages unit placement.
 */
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
     * Renders the battlefield in ASCII format.
     * @param useNumeric Whether to use numeric representation
     * @return String representation of the battlefield
     */
    public String render(boolean useNumeric) {
        StringBuilder sb = new StringBuilder();
        
        // Add top border
        sb.append("+");
        for (int i = 0; i < size; i++) sb.append("--");
        sb.append("+\n");

        // Add grid content
        for (int i = 0; i < size; i++) {
            sb.append("|");
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
            sb.append("|\n");
        }

        // Add bottom border
        sb.append("+");
        for (int i = 0; i < size; i++) sb.append("--");
        sb.append("+");

        return sb.toString();
    }

    public List<Character> getUnits() {
        return new ArrayList<>(units);
    }

    public void applyNewPositions(List<Character> sortedUnits, String orientation) {
        // Clear the grid
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = null;
            }
        }

        int unitIndex = 0;
        switch (orientation.toLowerCase()) {
            case "n": // North - top to bottom
                for (int j = 0; j < size && unitIndex < sortedUnits.size(); j++) {
                    for (int i = 0; i < size && unitIndex < sortedUnits.size(); i++) {
                        Position pos = new Position(i, j);
                        placeUnit(sortedUnits.get(unitIndex++), pos);
                    }
                }
                break;
            case "s": // South - bottom to top
                for (int j = 0; j < size && unitIndex < sortedUnits.size(); j++) {
                    for (int i = size - 1; i >= 0 && unitIndex < sortedUnits.size(); i--) {
                        Position pos = new Position(i, j);
                        placeUnit(sortedUnits.get(unitIndex++), pos);
                    }
                }
                break;
            case "e": // East - left to right
                for (int i = 0; i < size && unitIndex < sortedUnits.size(); i++) {
                    for (int j = 0; j < size && unitIndex < sortedUnits.size(); j++) {
                        Position pos = new Position(i, j);
                        placeUnit(sortedUnits.get(unitIndex++), pos);
                    }
                }
                break;
            case "w": // West - right to left
                for (int i = 0; i < size && unitIndex < sortedUnits.size(); i++) {
                    for (int j = size - 1; j >= 0 && unitIndex < sortedUnits.size(); j--) {
                        Position pos = new Position(i, j);
                        placeUnit(sortedUnits.get(unitIndex++), pos);
                    }
                }
                break;
        }
    }
}
