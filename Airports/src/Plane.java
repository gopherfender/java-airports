package Airports.src;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Plane {
    private String planeType;
    private String registration;
    private ArrayList<Seat> seatList;
    private ArrayList<Bag> holdBaggage;
    private String[] seatColumns = { "A", "B", "C", "D", "E", "F", "G", "H" };

    public Plane(String planeType, String registration, int rows, int columns) {
        this.planeType = planeType;
        this.registration = registration;
        this.seatList = new ArrayList<Seat>();
        this.holdBaggage = new ArrayList<Bag>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seatList.add(new Seat(seatColumns[j], i));
            }
        }
    }

    public ArrayList<Bag> getBaggage() {
        return holdBaggage;
    }

    public void addBag(Bag bag) {
        this.holdBaggage.add(bag);
    }

    public ArrayList<Seat> getSeats() {
        return seatList;
    }
}
