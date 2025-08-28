package university.jala.legion.sorting.placement;

import university.jala.legion.model.Position;
import university.jala.legion.model.interfaces.ICharacter;

import java.util.List;

/**
 * Places units on the battlefield starting from the west and moving east.
 * Units are arranged column by column, from top to bottom.
 */
public class EastPlacementStrategy implements PlacementStrategy {
    @Override
    public void place(List<ICharacter> units, int battlefieldSize) {
        if (units.isEmpty()) {
            return;
        }

        int currentCol = 0;
        int currentRow = 0;
        int currentRank = units.get(0).getRank();

        for (ICharacter unit : units) {
            if (unit.getRank() != currentRank) {
                currentCol++;
                currentRow = 0;
                currentRank = unit.getRank();
            }

            if (currentCol >= battlefieldSize) {
                throw new IllegalArgumentException("Not enough space on the battlefield for all units.");
            }

            if (currentRow >= battlefieldSize) {
                throw new IllegalArgumentException("A unit group exceeds the battlefield height.");
            }

            unit.setPosition(new Position(currentRow, currentCol));
            currentRow++;
        }
    }
}
