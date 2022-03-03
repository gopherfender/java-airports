package Airports.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class TestsPassenger {
    @Test
    public void aPassengerHasaName() {
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        assertEquals(passenger.getName(), "Bob Smith");
    }

    @Test
    public void aPassengerCanHaveABoardingPass() {
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        Seat seat = new Seat("A", 1);
        passenger.checkIn("Keflavik", "Manchester", seat);
        BoardingPass pass = passenger.getBoardingPass();
        assertSame(passenger.getBoardingPass(), pass);
    }
}
