package Airports.src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Plane {
    private String planeType;
    private String registration;
    private HashMap<String, Seat> seatList;
    private ArrayList<Bag> holdBaggage;
    private String[] seatColumns = { "A", "B", "C", "D", "E", "F", "G", "H" };

    public Plane(String planeType, String registration, int rows, int columns) {
        this.planeType = planeType;
        this.registration = registration;
        this.seatList = new HashMap<String, Seat>();
        this.holdBaggage = new ArrayList<Bag>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seatList.put((i + 1) + seatColumns[j], new Seat((i + 1), seatColumns[j]));
            }
        }
    }

    public String getNextFreeSeat() {
        String seatNumber = "";
        for (Seat i : seatList.values()) {
            if (i.getPassenger() == null) {
                seatNumber = i.getSeatNumber();
            }
        }
        return seatNumber;
    }

    public ArrayList<Bag> getBaggage() {
        return holdBaggage;
    }

    public void addBag(Bag bag) {
        this.holdBaggage.add(bag);
    }

    public HashMap<String, Seat> getSeats() {
        return seatList;
    }

    public Seat getSeat(String seatNumber) {
        return seatList.get(seatNumber);
    }

    public boolean boardPassenger(Passenger passenger) {
        try {
            Seat seat = seatList.get(passenger.getBoardingPass().getSeatNumber());
            seat.seatPassenger(passenger);
            return true;
        } catch (Exception err) {
            System.out.println("Seat occupied");
            return false;
        }

    }
}
