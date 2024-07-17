package model.room;

/**
 * This abstract class contains the basic functionalities of a room.
 * Note that when setting the basePrice of a room, the price multiplier is set after the
 * function call to {@code setBasePrice}. When getting the basePrice, multiplier is already applied.
 */
public abstract class Room {
    protected String name;
    protected double basePrice;
    protected final double multiplier;

    /**
     * Constructor for class Room
     * @param name is the name of this room
     * @param basePrice is the base price of the room per night
     * @param multiplier is the price multiplier of the room's base price
     */
    public Room(String name, double basePrice, double multiplier) {
        this.name = name;
        this.basePrice = basePrice;
        this.multiplier = multiplier;
    }

    /**
     * @param basePrice is the basePrice of the room
     */
    public final void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * @return name of this room
     */
    public final String getName() {
        return this.name;
    }

    /**
     * @return base price of the room
     */
    public final double getBasePrice() {
        return this.basePrice;
    }

    /**
     * @return price multiplier of the room
     */
    public final double getMultiplier() {
        return this.multiplier;
    }

    /**
     * @return total price per night ({@code basePrice * multiplier})
     */
    public final double getTotalPrice() {
        return this.basePrice * this.multiplier;
    }

}