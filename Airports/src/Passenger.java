package Airports.src;

import java.util.ArrayList;

public class Passenger {
    private String surname;
    private String forename;
    private int passportNumber;
    private ArrayList<Bag> baggage;
    private String destination;
    private BoardingPass boardingPass;
    private boolean boarded = false;

    public Passenger(String forename, String surname, int passportNumber, String destination) {
        this.surname = surname;
        this.forename = forename;
        this.passportNumber = passportNumber;
        this.destination = destination;
        this.baggage = new ArrayList<Bag>();
    }

    public boolean getBoarded() {
        return this.boarded;
    }

    public void setBoarded(boolean bool) {
        this.boarded = bool;
    }

    public void addBag(int weight, String bagId) {
        this.baggage.add(new Bag(weight, bagId));
    }

    public ArrayList<Bag> getBags() {
        return this.baggage;
    }

    public String getName() {
        return this.forename + ' ' + this.surname;
    }

    public void checkIn(String destination, String departure, String seatNumber) {
        this.boardingPass = new BoardingPass(destination, departure, seatNumber);
    }

    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    public BoardingPass getBoardingPass() {
        return this.boardingPass;
    }

    public String getDestination() {
        return this.destination;
    }
}
