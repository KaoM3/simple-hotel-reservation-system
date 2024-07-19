package model.hotel;

import model.hotel.room.*;
import model.reservation.*;

public class HotelManager {
    private Hotel hotel;

    /**
     * Constructor for class HotelManager
     */
    public HotelManager() {}

    /**
     * @param hotel is the new Hotel
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Creates and adds a new room to this hotel's room list
     */
    public void createAndAddRoom() {
        // TODO: Implement createAndAddRoom
    }

    /**
     * Removes the {@code room} instance from this hotel's room list
     * @param room is the room to be removed
     */
    public void removeRoom(Room room) {
        this.hotel.removeRoom(room);
    }

    /**
     * Renames {@code this.hotel} to {@code name}
     * @param name is the new name
     */
    public void renameHotel(String name) {
        this.hotel.setName(name);
    }

    /** */
    public void updateHotelReservations() {
        // TODO: Implement updateHotelReservations
    }

    /** */
    public void updateDatePriceModifier() {
        // TODO: Implement updateDatePriceModifier
    }

    /**
     * @return Hotel
     */
    public Hotel getHotel() {
        return this.hotel;
    }

    /**
     * @return Total price of all the Reservations in this hotel
     */
    public double getHotelEarnings() {
        double totalEarnings = 0;

        for(Reservation reservation : this.hotel.getReservationManager().getReservationList()) {
            totalEarnings += reservation.getTotalPrice();
        }

        return totalEarnings;
    }

    
}
