package university.jala.legion.model.units;

import university.jala.legion.model.Character;

public class Sniper extends Character {
    private static final int RANK = 3;
    private static final char SYMBOL = 'S';
    private static final int NUMERIC_RANGE = 4;

    public Sniper() {
        super(RANK, SYMBOL, NUMERIC_RANGE);
    }

    @Override
    public String getType() {
        return "Sniper";
    }
}
