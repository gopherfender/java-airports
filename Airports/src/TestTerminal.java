package Airports.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.xml.crypto.dsig.SignatureMethod;

import org.junit.Test;

public class TestTerminal {
    @Test
    public void passengerSentToGate() {
        Terminal terminal = new Terminal(1, 3);
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        terminal.addUncheckedPassenger(passenger);
        Gate gate = terminal.getGate(2);
        terminal.sentPassengersToGate(gate, "KEF");
        assertTrue(gate.passengers.contains(passenger));
    }

    @Test
    public void bagSentToPlane() {
        Terminal terminal = new Terminal(1, 3);
        Gate gate = terminal.getGate(2);
        Plane plane = new Plane("A380", "ABC123", 10, 4);
        gate.setPlane(plane);
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        passenger.addBag(20, "Totally not drugs");
        terminal.sendBaggageToPlane(passenger, gate);
        ArrayList<Bag> holdBags = plane.getBaggage();
        assertEquals(1, holdBags.size());
        // assertEquals(0, passenger.getBags().size());
    }
}
