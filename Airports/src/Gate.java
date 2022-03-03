package Airports.src;

import java.util.ArrayList;

public class Gate {
    private int gateNumber;
    public ArrayList<Passenger> passengers;
    private Plane plane;

    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
        this.passengers = new ArrayList<Passenger>();
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void sendPassengersToPlane() {
        passengers.forEach(passenger -> {
            if (plane.boardPassenger(passenger)) {
                passenger.setBoarded(true);
            }
        });
        passengers.removeIf(passenger -> passenger.getBoarded());
    }
}
