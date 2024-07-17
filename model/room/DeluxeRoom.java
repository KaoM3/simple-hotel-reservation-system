package model.room;

public class DeluxeRoom extends Room {

    /**
     * Constructor for class StandardRoom
     * @param name is the name of the room
     * @param basePrice is the basePrice of the room
     */
    public DeluxeRoom(String name, double basePrice) {
        super(name, basePrice, 1.2);
    }

}
