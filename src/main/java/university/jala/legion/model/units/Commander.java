// Represents a single unit of Commander.
package university.jala.legion.model.units;

import university.jala.legion.model.Character;

/**
 * Commander class, represents the highest priority military unit.
 * Rank 0 (Highest priority)
 */
public class Commander extends Character {
    public Commander(String type) {
        super(type);
        this.rank = 0;
        if ("n".equals(type)) {
            this.numericValue = getRandomNumericValue(1, 11);
        } else {
            this.characterValue = getRandomCharacterValue('a', 'j');
        }
    }

    // Helper method to get a random numeric value for Commander
    private String getRandomNumericValue(int min, int max) {
        return String.valueOf(new java.util.Random().nextInt(max - min) + min);
    }

    // Helper method to get a random character value for Commander
    private String getRandomCharacterValue(char min, char max) {
        return String.valueOf((char) (new java.util.Random().nextInt(max - min + 1) + min));
    }
}