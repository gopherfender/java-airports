package Airports.src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestsPlane {
    @Test

    public void correctSeatCount() {
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        assertEquals(40, plane.getSeats().size());
    }

    @Test
    public void canGetCorrectSeat() {
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        Seat seat = plane.getSeat("4B");
        assertEquals("4B", seat.getSeatNumber());
    }

    @Test
    public void canPassengerSit() {
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        Passenger passenger1 = new Passenger("Bob", "Smith", 8008, "KEF");
        passenger1.checkIn("Keflavik", "Manchester", "1A");
        plane.boardPassenger(passenger1);
        assertEquals(passenger1, plane.getSeat("1A").getPassenger());
    }

    @Test
    public void isSeatTaken() throws Exception {
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        Passenger passenger1 = new Passenger("Bob", "Smith", 8008, "KEF");
        passenger1.checkIn("Keflavik", "Manchester", "1A");
        plane.boardPassenger(passenger1);
        assertEquals(passenger1, plane.getSeat("1A").getPassenger());
        try {
            plane.getSeat("1A").seatPassenger(passenger1);
        } catch (Exception error) {
            assertEquals(error.getMessage(), "Seat Occupied");
        }
    }

    @Test
    public void isNextSeatFree() {
        Plane plane = new Plane("A380", "ABC123", 1, 3);
        Passenger passenger1 = new Passenger("Bob", "Smith", 8008, "KEF");
        Passenger passenger2 = new Passenger("Sue", "Smith", 1234, "KEF");
        passenger1.setBoardingPass(new BoardingPass("KEF", "MAN", "1A"));
        passenger2.setBoardingPass(new BoardingPass("KEF", "MAN", "1C"));
        plane.boardPassenger(passenger1);
        plane.boardPassenger(passenger2);
        String emptySeat = plane.getNextFreeSeat();
        assertEquals("1B", emptySeat);
    }
}
