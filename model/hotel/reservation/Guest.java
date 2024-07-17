package model.hotel.reservation;

public class Guest {
    private String name;

    /**
     * Constructor for class Guest
     * @param name is the name of the guest
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     * @return guest name
     */
    public String getName() {
        return this.name;
    }
}
