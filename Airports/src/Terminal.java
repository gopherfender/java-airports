package Airports.src;

import java.util.ArrayList;
import java.util.HashMap;

public class Terminal {
    private Airport airport;
    private int terminalNumber;
    private HashMap<Integer, Gate> gates;
    private HashMap<String, Integer> destinationMap = new HashMap<String, Integer>();
    private ArrayList<Passenger> uncheckedPassengers;

    public Terminal(Airport airport, int terminalNumber, int gateCount) {
        this.airport = airport;
        this.terminalNumber = terminalNumber;
        this.uncheckedPassengers = new ArrayList<Passenger>();
        this.gates = new HashMap<Integer, Gate>();
        this.destinationMap.put("KEF", 2);
        this.destinationMap.put("LAX", 3);
        this.destinationMap.put("LGW", 1);
        this.destinationMap.put("LIV", 1);

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

    public void checkInPassenger(Passenger passenger) {
        String destination = passenger.getDestination();
        String departure = airport.getCode();
        Gate departureGate = gates.get(destinationMap.get(destination));
        String seatNumber = departureGate.getPlane().getNextFreeSeat();
        BoardingPass boardingPass = new BoardingPass(destination, departure, seatNumber);
        passenger.setBoardingPass(boardingPass);

    }

    public void sentPassengersToGate(Gate gate, String destination) {
        uncheckedPassengers.forEach(passenger -> {
            if (passenger.getDestination() == destination) {
                checkInPassenger(passenger);
                gate.addPassenger(passenger);
            }
        });
        uncheckedPassengers.removeIf(passenger -> passenger.getDestination() == destination);
    }

    public void sendBaggageToPlane(Passenger passenger, Gate gate) {
        ArrayList<Bag> baggage = passenger.getBags();
        Plane plane = gate.getPlane();
        baggage.forEach(bag -> {
            plane.addBag(bag);
        });
        baggage.clear();
    }
}
