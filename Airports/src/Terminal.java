package Airports.src;

import java.util.ArrayList;
import java.util.HashMap;

public class Terminal {
    private int terminalNumber;
    private HashMap<Integer, Gate> gates;
    private ArrayList<Passenger> uncheckedPassengers;

    public Terminal(int terminalNumber, int gateCount) {
        this.terminalNumber = terminalNumber;
        this.uncheckedPassengers = new ArrayList<Passenger>();
        this.gates = new HashMap<Integer, Gate>();

        for (int i = 0; i < gateCount; i++) {
            Gate gate = new Gate(i + 1);
            this.gates.put(i + 1, gate);
        }
    }

    public int getTerminalNumber() {
        return terminalNumber;
    }

    public HashMap<Integer, Gate> getAllGates() {
        return gates;
    }

    public Gate getGate(int gateNum) {
        return gates.get(gateNum);
    }

    public void addUncheckedPassenger(Passenger passenger) {
        this.uncheckedPassengers.add(passenger);
    }

    public ArrayList<Passenger> getUncheckedPassengers() {
        return uncheckedPassengers;
    }

    public void sentPassengersToGate(Gate gate, String destination) {
        uncheckedPassengers.forEach(passenger -> {
            if (passenger.getDestination() == destination) {
                gate.addPassenger(passenger);
            }
            // uncheckedPassengers.removeIf(e -> passenger.getDestination() == destination);
        });
    }

    public void sendBaggageToPlane(Passenger passenger, Gate gate) {
        ArrayList<Bag> baggage = passenger.getBags();
        Plane plane = gate.getPlane();
        baggage.forEach(bag -> {
            plane.addBag(bag);
        });
    }
}
