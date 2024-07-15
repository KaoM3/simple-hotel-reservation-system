package model.room;

public class ExecutiveRoom extends Room {
    
    public ExecutiveRoom(String name, double basePrice) {
        super();
        this.name = name;
        this.multiplier = 1.35;
        this.basePrice = basePrice * multiplier;
    }

}
