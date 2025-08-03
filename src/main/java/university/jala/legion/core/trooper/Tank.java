package university.jala.legion.core.trooper;

public class Tank extends Troop {
    private static final int RANK = 2;
    public Tank(String id, char symbol) { super(id, RANK, symbol); }
    public Tank(String id, int value) { super(id, RANK, value); }
}