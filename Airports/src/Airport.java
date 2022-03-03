package Airports.src;

import java.util.HashMap;

public class Airport {
    private String name;
    private String code;
    private HashMap<Integer, Terminal> terminals;
    private HashMap<String, Integer> departureMap;

    public Airport(String name, String code, int terminalCount, HashMap<String, Integer> departureMap) {
        this.name = name;
        this.code = code;
        this.departureMap = departureMap;
        this.terminals = new HashMap<Integer, Terminal>();

        for (int i = 0; i < terminalCount; i++) {
            Terminal terminal = new Terminal(i + 1, 10);
            this.terminals.put(i + 1, terminal);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public Terminal getTerminal(int terminalNumber) {
        return terminals.get(terminalNumber);
    }

    public HashMap<Integer, Terminal> getAllTerminals() {
        return terminals;
    }

    public HashMap<String, Integer> getDepartureMap() {
        return this.departureMap;
    }

    public int getCorrectTerminal(Passenger passenger) {
        return departureMap.get(passenger.getDestination());
    }

    public void sendPassengerToTerminal(Passenger passenger) {
        this.terminals.get(getCorrectTerminal(passenger)).addUncheckedPassenger(passenger);
    }

    public void createPlane(String planeType, String registration, Gate gate) {
        Plane newPlane = new Plane(planeType, registration);
        gate.setPlane(newPlane);

    }
}
