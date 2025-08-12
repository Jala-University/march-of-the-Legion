package university.jala.legion.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Position class.
 */
class PositionTest {

    @Test
    void testPositionInitialization() {
        // Create a new Position instance
        Position position = new Position(5, 10);

        // Assert that the row and column are set correctly
        assertEquals(5, position.getRow());
        assertEquals(10, position.getColumn());
    }

    @Test
    void testEquals() {
        // Create two Position instances with the same coordinates
        Position pos1 = new Position(3, 7);
        Position pos2 = new Position(3, 7);

        // Create a Position instance with different coordinates
        Position pos3 = new Position(5, 7);

        // Assert that two positions with the same coordinates are equal
        assertEquals(pos1, pos2);

        // Assert that two positions with different coordinates are not equal
        assertNotEquals(pos1, pos3);

        // Assert that a position is not equal to null
        assertNotEquals(pos1, null);

        // Assert that a position is not equal to an object of a different class
        assertNotEquals(pos1, new Object());
    }

    @Test
    void testHashCode() {
        // Create two Position instances with the same coordinates
        Position pos1 = new Position(4, 8);
        Position pos2 = new Position(4, 8);

        // Assert that two positions with the same coordinates have the same hash code
        assertEquals(pos1.hashCode(), pos2.hashCode());
    }

    @Test
    void testToString() {
        // Create a Position instance
        Position position = new Position(1, 2);

        // Assert that the toString() method returns the expected string representation
        assertEquals("(1,2)", position.toString());
    }
}
