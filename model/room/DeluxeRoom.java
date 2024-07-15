package model.room;

public class DeluxeRoom extends Room {
    
    public DeluxeRoom(String name, double basePrice) {
        super();
        this.name = name;
        this.multiplier = 1.2;
        this.basePrice = basePrice * multiplier;
    }

}
