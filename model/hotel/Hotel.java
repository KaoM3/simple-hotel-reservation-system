package model.hotel;

import java.util.*;

import model.hotel.room.*;
import model.reservation.*;

public class Hotel {
    private String              name;
    private List<Room>          roomList;
    private ReservationManager  reservationManager;

    // TODO: Identify how ReservationManager and PriceModifier will be utilized inside this class

    public Hotel(String name) {
        this.name = name;
        this.reservationManager = new ReservationManager();
        this.roomList = new ArrayList<>();
    }

    /**
     * @param name is the new name for this hotel.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a new {@code room} to this hotel's roomList
     * @param room is the room to be added
     */
    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    /**
     * Removes a {@code room} object from roomList
     * @param room is the room instance to be removed
     */
    public void removeRoom(Room room) {
        roomList.remove(room);
    }

    /**
     * @return the name of this hotel
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the list of rooms of this hotel
     */
    public List<Room> getRoomList() {
        return this.roomList;
    }

    /**
     * @return this hotel's reservation manager
     */
    public ReservationManager getReservationManager() {
        return this.reservationManager;
    }
}


