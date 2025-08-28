package university.jala.legion.sorting.placement;

import university.jala.legion.model.Position;
import university.jala.legion.model.interfaces.ICharacter;

import java.util.List;

/**
 * Places units on the battlefield starting from the north and moving south.
 * Units are arranged row by row, from left to right.
 */
public class SouthPlacementStrategy implements PlacementStrategy {
    @Override
    public void place(List<ICharacter> units, int battlefieldSize) {
        if (units.isEmpty()) {
            return;
        }

        int currentRow = 0;
        int currentCol = 0;
        int currentRank = units.get(0).getRank();

        for (ICharacter unit : units) {
            if (unit.getRank() != currentRank) {
                currentRow++;
                currentCol = 0;
                currentRank = unit.getRank();
            }

            if (currentRow >= battlefieldSize) {
                throw new IllegalArgumentException("Not enough space on the battlefield for all units.");
            }

            if (currentCol >= battlefieldSize) {
                throw new IllegalArgumentException("A unit group exceeds the battlefield width.");
            }

            unit.setPosition(new Position(currentRow, currentCol));
            currentCol++;
        }
    }
}
