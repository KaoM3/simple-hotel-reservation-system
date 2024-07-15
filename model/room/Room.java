package model.room;

public abstract class Room {
    protected String name;
    protected double multiplier;
    protected double basePrice;

    public Room() {}

    public final void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public final String getName() {
        return this.name;
    }

    public final double getBasePrice() {
        return this.basePrice;
    }

}