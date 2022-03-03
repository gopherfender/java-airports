package Airports.src;

public class Seat {
    private String seatColumn;
    private int seatRow;
    private String seatType;
    private Passenger passenger;

    public Seat(int seatRow, String seatColumn) {
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.passenger = null;
    }

    public void seatPassenger(Passenger passenger) throws Exception {
        if (this.passenger != null) {
            throw new Exception("Seat Occupied");
        } else {
            this.passenger = passenger;
        }
    }

    public String getSeatNumber() {
        return this.seatRow + this.seatColumn;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}