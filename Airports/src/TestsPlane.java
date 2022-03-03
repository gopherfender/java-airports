package Airports.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestsPlane {
    @Test

    public void correctSeatCount() {
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        assertEquals(40, plane.getSeats().size());
    }
}
