package Airports.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

public class TestTerminal {
    @Test
    public void passengerSentToGate() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        airport.createPlane("A380", "ABC123", 10, 6, 2, 2);
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        airport.getTerminal(2).addUncheckedPassenger(passenger);
        Gate gate = airport.getTerminal(2).getGate(2);
        airport.getTerminal(2).sentPassengersToGate(gate, "KEF");
        assertTrue(gate.passengers.contains(passenger));
        assertFalse(airport.getTerminal(2).getUncheckedPassengers().contains(passenger));
    }

    @Test
    public void bagSentToPlane() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        Gate gate = airport.getTerminal(2).getGate(2);
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        gate.setPlane(plane);
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        passenger.addBag(20, "Totally not drugs");
        airport.getTerminal(2).sendBaggageToPlane(passenger, gate);
        ArrayList<Bag> holdBags = plane.getBaggage();
        assertEquals(1, holdBags.size());
        assertEquals(0, passenger.getBags().size());
    }
}
