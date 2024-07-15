package model.room;

public class StandardRoom extends Room {
    
    public StandardRoom(String name, double basePrice) {
        super();
        this.name = name;
        this.multiplier = 1.0;
        this.basePrice = basePrice * multiplier;
    }
}
