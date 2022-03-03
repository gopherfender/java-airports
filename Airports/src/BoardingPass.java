package Airports.src;

public class BoardingPass {
    private String destination;
    private String departure;
    private Seat seat;

    public BoardingPass(String destination, String departure, Seat seat) {
        this.destination = destination;
        this.departure = departure;
        this.seat = seat;
    }

    public Seat getSeat() {
        return this.seat;
    }

}
