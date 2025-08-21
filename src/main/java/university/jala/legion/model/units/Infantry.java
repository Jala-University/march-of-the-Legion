// Represents a single unit of Infantry.
package university.jala.legion.model.units;

import university.jala.legion.model.Character;

/**
 * Infantry class, represents a basic ground troop unit.
 * Rank 4 (Lowest priority)
 */
public class Infantry extends Character {
    public Infantry(String type) {
        super(type);
        this.rank = 4;
        if ("n".equals(type)) {
            this.numericValue = getRandomNumericValue(41, 51);
        } else {
            this.characterValue = getRandomCharacterValue('O', 'X');
        }
    }

    // Helper method to get a random numeric value for Infantry
    private String getRandomNumericValue(int min, int max) {
        return String.valueOf(new java.util.Random().nextInt(max - min) + min);
    }

    // Helper method to get a random character value for Infantry
    private String getRandomCharacterValue(char min, char max) {
        return String.valueOf((char) (new java.util.Random().nextInt(max - min + 1) + min));
    }
}