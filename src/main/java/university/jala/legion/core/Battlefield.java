package university.jala.legion.core;

import university.jala.legion.core.trooper.Troop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Represents the battlefield grid.
 * Adheres to SRP by managing the grid state and display logic.
 */
public class Battlefield {
    private final int size;
    private final Troop[][] grid;
    private final Random random = new Random();

    public Battlefield(int size) {
        this.size = size;
        this.grid = new Troop[size][size];
    }

    /**
     * Places troops randomly on the grid without overlapping.
     * This method is used for the initial display.
     *
     * @param troops The list of troops to place.
     */
    public void placeRandomly(List<Troop> troops) {
        List<Position> availablePositions = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                availablePositions.add(new Position(i, j));
            }
        }
        Collections.shuffle(availablePositions, random);

        for (int i = 0; i < troops.size(); i++) {
            if (i < availablePositions.size()) {
                Position p = availablePositions.get(i);
                grid[p.getX()][p.getY()] = troops.get(i);
                troops.get(i).setPosition(p);
            }
        }
    }

    /**
     * Places troops in a sorted order on the grid.
     * This is a specific placement method for the final display to match the new example.
     * It fills the grid from the bottom-left corner, moving rightward and then upward.
     *
     * @param troops The list of sorted troops.
     */
    public void placeSorted(List<Troop> troops) {
        int troopIndex = 0;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                if (troopIndex < troops.size()) {
                    grid[i][j] = troops.get(troopIndex);
                    troopIndex++;
                }
            }
        }
    }

    /**
     * Displays the current state of the battlefield grid with clean formatting.
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != null) {
                    Troop troop = grid[i][j];
                    if (troop.getSymbol() != '\0') {
                        System.out.printf("%-4s", troop.getSymbol());
                    } else {
                        System.out.printf("%-4s", troop.getValue());
                    }
                } else {
                    System.out.printf("%-4s", "*");
                }
            }
            System.out.println();
        }
    }
}