package service;

import model.hotel.Hotel;
import model.hotel.room.*;
import model.reservation.*;

public class HotelService {
    private Hotel hotel;

    /**
     * Constructor for class HotelService
     */
    public HotelService(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Creates and adds a new room to this hotel's room list
     * @param room is the room object to be added
     */
    public void createAndAddRoom(Room room) {
        this.hotel.getRoomList().add(room);
    }

    /**
     * Removes the {@code room} instance from this hotel's room list
     * @param room is the room to be removed
     */
    public void removeRoom(Room room) {
        this.hotel.getRoomList().remove(room);
    }

    /**
     * Renames {@code this.hotel} to {@code name}
     * @param name is the new name
     */
    public void renameHotel(String name) {
        this.hotel.setName(name);
    }

    /**
     * Returns a room in this hotel that matches the given room name
     * @param roomName is the name of the room
     * @return Room that matches {@code roomName}, null if no matches
     */
    public Room getRoomByName(String roomName) {
        for(Room room : this.hotel.getRoomList()) {
            if(room.getName().contentEquals(roomName)) {
                return room;
            }
        }
        return null;
    }

    /**
     * Returns a room in this hotel's room list with the specified index
     * @param index is the index of the room
     * @return Room at index {@code index}
     */
    public Room getRoomByIndex(int index) {
        return this.hotel.getRoomList().get(index);
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
