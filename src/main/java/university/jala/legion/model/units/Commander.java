package university.jala.legion.model.units;

import university.jala.legion.model.Character;

public class Commander extends Character {
    private static final int RANK = 0;
    private static final char SYMBOL = 'C';
    private static final int NUMERIC_RANGE = 1;

    public Commander() {
        super(RANK, SYMBOL, NUMERIC_RANGE);
    }

    @Override
    public String getType() {
        return "Commander";
    }
}
