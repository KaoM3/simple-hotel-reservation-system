package model.room;

public class StandardRoom extends Room {
    
    /**
     * Constructor for class StandardRoom
     * @param name is the name of the room
     * @param basePrice is the basePrice of the room
     */
    public StandardRoom(String name, double basePrice) {
        super(name, basePrice, 1.0);
    }
}
