package service;

import model.hotel.Hotel;
import model.hotel.room.*;
import model.reservation.*;

public class HotelService {
    private Hotel hotel;
    public static final int STANDARD = 1;
    public static final int DELUXE = 2;
    public static final int EXECUTIVE = 3;

    /**
     * Constructor for class HotelService
     */
    public HotelService(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * Creates and adds a new room to this hotel's room list with basePrice equal to this hotel's base rate
     * @param roomName is the name of the new room
     * @param roomType is the type of the new room
     * You must specify the room type:
     * <br><br>
     * <ul>
     * <li><code>STANDARD</code>
     * Creates a new standard room
     *
     * <li><code>DELUXE</code>
     * Creates a new deluxe room
     * 
     * <li><code>EXECUTIVE</code>
     * Creates a new executive room
     * </ul>
     * @return true if room can be created, false otherwise
     */
    public boolean createAndAddRoom(String roomName, int roomType) {
        Room    newRoom;
        double  basePriceOfRoom = this.hotel.getReservationManager().getBaseRate();

        if(roomType == STANDARD) {
            newRoom = new StandardRoom(roomName, basePriceOfRoom);
            this.hotel.getRoomList().add(newRoom);
        }
        else if(roomType == DELUXE) {
            newRoom = new DeluxeRoom(roomName, basePriceOfRoom);
            this.hotel.getRoomList().add(newRoom);
        }
        else if(roomType == EXECUTIVE) {
            newRoom = new ExecutiveRoom(roomName, basePriceOfRoom);
            this.hotel.getRoomList().add(newRoom);
        }
        else {
            return false;
        }
        return true;
    }

    /**
     * Removes the {@code room} object from this hotel's room list
     * @param room is the room to be removed
     * @return true if successful, false otherwise
     */
    public boolean removeRoom(Room room) {
        try {
            return this.hotel.getRoomList().remove(room);
        } catch (NullPointerException error) {
            System.out.println(error);
            return false;
        }
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
