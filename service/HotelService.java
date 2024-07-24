package service;

import model.hotel.Hotel;
import model.hotel.room.*;
import model.reservation.Reservation;

/**
 * Contains all the business logic for editing the data inside a {@code Hotel} object.
 * This class should be instantiated to manipulate the data of this.hotel.
 */
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
        double  basePriceOfRoom = this.hotel.getBaseRate();

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
     * Creates and adds a new room to this hotel's room list with basePrice equal to this hotel's base rate
     * @param roomName is the name of the new room
     * @param roomType is the type of the new room
     * @return true if room can be created, false otherwise
     */
    public boolean createAndAddRoom(String roomName, String roomType) {
        Room    newRoom;
        double basePriceOfRoom = this.hotel.getBaseRate();

        if(roomType == null) {
            return false;
        }

        for(RoomType type : RoomType.values()) {
            if(type.name().contentEquals(roomType)) {
                newRoom = type.constructRoom(roomName, basePriceOfRoom);
                this.hotel.getRoomList().add(newRoom);
                return true;
            }
        }

        return false;
    }

    /**
     * Removes the {@code room} object from this hotel's room list if the room has no reservations
     * @param room is the room to be removed
     * @return true if successful, false otherwise
     */
    public boolean removeRoom(Room room) {

        for(Reservation reservation : this.hotel.getReservationManager().getReservationList()) {
            if(reservation.getRoom().getName().contentEquals(room.getName())) {
                return false;
            }
        }

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
     * Sets the base rate of this.hotel if {@code baseRate} is valid and updates the base price of all rooms
     * in this.hotel
     * @param baseRate is the new base rate (baseRate >= 100)
     * @return true if baseRate is valid, false otherwise
     */
    public boolean updateBaseRate(double baseRate) {
        
        if(baseRate < 100) {
            return false;
        }
        
        this.hotel.setBaseRate(baseRate);
        for(Room room : this.hotel.getRoomList()) {
            room.setBasePrice(baseRate);
        }

        return true;
    }
    
}
