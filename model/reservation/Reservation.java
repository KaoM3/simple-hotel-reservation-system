package model.reservation;

import java.util.HashMap;

import model.hotel.room.Room;

/**
 * Object representation of a reservation. All required information should be set upon
 * creation.
 */
public class Reservation {
    private final HashMap<Integer, Double> priceBreakdown;
    private final Guest   guest;
    private final Room    room;
    private final int     checkIn;
    private final int     checkOut;
    private final double  totalPrice;

    /**
     * Constructor for class Reservation
     * @param guestName is the name of the Guest of this reservation
     * @param room      is the Room that this reservation belongs to
     * @param checkIn   is the check-in date (int)
     * @param checkOut  is the check-out date (int)
     * @param totalPrice    is the total price of the stay after discount codes and date price modifiers
     */
    public Reservation(String guestName, Room room, int checkIn, int checkOut, double totalPrice, HashMap<Integer, Double> priceBreakdown) {
        this.guest = new Guest(guestName);
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.priceBreakdown = priceBreakdown;
    }

    /**
     * @return name of the guest (that made this reservation)
     */
    public String getGuestName() {
        return this.guest.getName();
    }

    /**
     * @return room (that this reservation belongs to)
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * @return check-in date
     */
    public int getCheckIn() {
        return this.checkIn;
    }

    /**
     * @return check-out date
     */
    public int getCheckOut() {
        return this.checkOut;
    }

    /**
     * @return total price of the stay after discount codes and date price modifiers
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * @return price per night of the reservation
     */
    public HashMap<Integer, Double> getPriceBreakdown() {
        return this.priceBreakdown;
    }
}
