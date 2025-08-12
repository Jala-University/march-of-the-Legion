package university.jala.legion.model.units;

import university.jala.legion.model.Character;

public class Medic extends Character {
    private static final int RANK = 1;
    private static final char SYMBOL = 'M';
    private static final int NUMERIC_RANGE = 2;

    public Medic() {
        super(RANK, SYMBOL, NUMERIC_RANGE);
    }

    @Override
    public String getType() {
        return "Medic";
    }
}
