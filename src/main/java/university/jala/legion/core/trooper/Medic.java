package university.jala.legion.core.trooper;

public class Medic extends Troop {
    private static final int RANK = 1;
    public Medic(String id, char symbol) { super(id, RANK, symbol); }
    public Medic(String id, int value) { super(id, RANK, value); }
}