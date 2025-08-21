// Represents a single unit of Tank.
package university.jala.legion.model.units;

import university.jala.legion.model.Character;

import java.util.Random;

/**
 * Tank class, represents a heavy armored assault unit.
 * Rank 2 (Medium priority)
 */
public class Tank extends Character {
    public Tank(String type) {
        super(type);
        this.rank = 2;
        if ("n".equals(type)) {
            this.numericValue = getRandomNumericValue(21, 31);
        } else {
            // Characters u-z continue with A-J
            String charValue = getRandomCharacterValue('u', 'z', 'A', 'J');
            this.characterValue = charValue;
        }
    }

    // Helper method to get a random numeric value for Tank
    private String getRandomNumericValue(int min, int max) {
        return String.valueOf(new java.util.Random().nextInt(max - min) + min);
    }

    // Helper method to get a random character value for Tank
    private String getRandomCharacterValue(char min1, char max1, char min2, char max2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            return String.valueOf((char) (random.nextInt(max1 - min1 + 1) + min1));
        } else {
            return String.valueOf((char) (random.nextInt(max2 - min2 + 1) + min2));
        }
    }
}