package university.jala.legion.core.trooper;

public class Infantry extends Troop {
    private static final int RANK = 4;
    public Infantry(String id, char symbol) { super(id, RANK, symbol); }
    public Infantry(String id, int value) { super(id, RANK, value); }
}