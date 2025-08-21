package university.jala.legion.model.units;

import university.jala.legion.model.Character;

import java.util.Random;

/**
 * Sniper class, represents a long-range precision unit.
 * Rank 3 (Low priority)
 */
public class Sniper extends Character {
    public Sniper(String type) {
        super(type);
        this.rank = 3;
        if ("n".equals(type)) {
            this.numericValue = getRandomNumericValue(31, 41);
        } else {
            // Characters u-z continue with A-J
            String charValue = getRandomCharacterValue('u', 'z', 'A', 'J');
            this.characterValue = charValue;
        }
    }

    // Helper method to get a random numeric value for Sniper
    private String getRandomNumericValue(int min, int max) {
        return String.valueOf(new java.util.Random().nextInt(max - min) + min);
    }

    // Helper method to get a random character value for Sniper
    private String getRandomCharacterValue(char min1, char max1, char min2, char max2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            return String.valueOf((char) (random.nextInt(max1 - min1 + 1) + min1));
        } else {
            return String.valueOf((char) (random.nextInt(max2 - min2 + 1) + min2));
        }
    }
}