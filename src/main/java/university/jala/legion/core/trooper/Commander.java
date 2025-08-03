package university.jala.legion.core.trooper;

public class Commander extends Troop {
    private static final int RANK = 0;
    public Commander(String id, char symbol) { super(id, RANK, symbol); }
    public Commander(String id, int value) { super(id, RANK, value); }
}