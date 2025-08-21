// Represents a single unit of Medic.
package university.jala.legion.model.units;

import university.jala.legion.model.Character;

/**
 * Medic class, represents a medical support unit.
 * Rank 1 (High priority)
 */
public class Medic extends Character {
    public Medic(String type) {
        super(type);
        this.rank = 1;
        if ("n".equals(type)) {
            this.numericValue = getRandomNumericValue(11, 21);
        } else {
            this.characterValue = getRandomCharacterValue('k', 't');
        }
    }

    // Helper method to get a random numeric value for Medic
    private String getRandomNumericValue(int min, int max) {
        return String.valueOf(new java.util.Random().nextInt(max - min) + min);
    }

    // Helper method to get a random character value for Medic
    private String getRandomCharacterValue(char min, char max) {
        return String.valueOf((char) (new java.util.Random().nextInt(max - min + 1) + min));
    }
}