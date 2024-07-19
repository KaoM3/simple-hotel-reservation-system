package model.hotel.room;

public class ExecutiveRoom extends Room {
    
    /**
     * Constructor for class ExecutiveRoom
     * @param name is the name of the room
     * @param basePrice is the basePrice of the room
     */
    public ExecutiveRoom(String name, double basePrice) {
        super(name, basePrice, 1.35);
    }

}
