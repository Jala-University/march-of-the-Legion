package university.jala.legion.model.units;

import university.jala.legion.model.Character;

public class Tank extends Character {
    private static final int RANK = 2;
    private static final char SYMBOL = 'T';
    private static final int NUMERIC_RANGE = 3;

    public Tank() {
        super(RANK, SYMBOL, NUMERIC_RANGE);
    }

    @Override
    public String getType() {
        return "Tank";
    }
}
