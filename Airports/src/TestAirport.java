package Airports.src;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import org.junit.Test;

public class TestAirport {
    @Test
    public void hasAllTerminals() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        HashMap<Integer, Terminal> terminals = airport.getAllTerminals();
        assertEquals(terminals.size(), 3);

    }

    @Test
    public void canGetDepartureTerminal() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        HashMap<String, Integer> departures = airport.getDepartureMap();
        int termValue = departures.get("KEF");
        assertEquals(termValue, 2);
    }

    @Test
    public void hasPassengerGonetoTerminal() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        Passenger passenger = new Passenger("Bob", "Smith", 8008, "KEF");
        airport.sendPassengerToTerminal(passenger);
        Terminal terminal = airport.getTerminal(2);
        assertTrue(terminal.getUncheckedPassengers().contains(passenger));

    }

    @Test
    public void canGetName() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        assertEquals("Manchester", airport.getName());
    }

    @Test
    public void canGetCode() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        assertEquals("MAN", airport.getCode());
    }

    @Test
    public void canGetTerminal() {
        HashMap<String, Integer> locations = new HashMap<String, Integer>();
        locations.put("LHR", 1);
        locations.put("MAD", 2);
        locations.put("KEF", 2);
        locations.put("LAX", 2);
        locations.put("NEW", 2);
        Airport airport = new Airport("Manchester", "MAN", 3, locations);
        assertEquals(2, airport.getTerminal(2).getTerminalNumber());
    }
}
// Do all tests need to be self contained, or can they access details from tests
// above?