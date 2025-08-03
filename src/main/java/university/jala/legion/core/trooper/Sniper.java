package university.jala.legion.core.trooper;

public class Sniper extends Troop {
    private static final int RANK = 3;
    public Sniper(String id, char symbol) { super(id, RANK, symbol); }
    public Sniper(String id, int value) { super(id, RANK, value); }
}