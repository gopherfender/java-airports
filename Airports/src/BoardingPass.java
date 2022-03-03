package Airports.src;

public class BoardingPass {
    private String destination;
    private String departure;
    private String seatNumber;

    public BoardingPass(String destination, String departure, String seatNumber) {
        this.destination = destination;
        this.departure = departure;
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

}
