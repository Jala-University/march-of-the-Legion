package university.jala.legion.model.units;

import university.jala.legion.model.Character;

public class Infantry extends Character {
    private static final int RANK = 4;
    private static final char SYMBOL = 'I';
    private static final int NUMERIC_RANGE = 5;

    public Infantry() {
        super(RANK, SYMBOL, NUMERIC_RANGE);
    }

    @Override
    public String getType() {
        return "Infantry";
    }
}
