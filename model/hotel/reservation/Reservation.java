package model.hotel.reservation;

import model.room.*;

public class Reservation {
    private Guest   guest;
    private Room    room;
    private int     checkIn;
    private int     checkOut;
    private double  totalPrice;

    /**
     * Constructor for class Reservation
     * @param guestName is the name of the Guest of this reservation
     * @param room      is the Room that this reservation belongs to
     * @param checkIn   is the check-in date (int)
     * @param checkOut  is the check-out date (int)
     * @param totalPrice    is the total price of the stay after discount codes and date price modifiers
     */
    public Reservation(String guestName, Room room, int checkIn, int checkOut, double totalPrice) {
        this.guest = new Guest(guestName);
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
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
    public int getCheckin() {
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
}
