package Airports.src;

public class Bag {
    private int weight;
    private String bagId;

    public Bag(int weight, String bagId) {
        this.weight = weight;
        this.bagId = bagId;
    }

    public int getWeight() {
        return this.weight;
    }
}
