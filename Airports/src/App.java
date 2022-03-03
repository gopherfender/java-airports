package Airports.src;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public Passenger createPassenger(String forename, String surname, int passportNumber, String destination) {
        Passenger passenger = new Passenger(forename, surname, passportNumber, destination);
        return passenger;
    }
}
