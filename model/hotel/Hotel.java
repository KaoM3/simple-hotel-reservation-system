package model.hotel;

import java.util.*;

import model.hotel.room.*;
import model.reservation.*;

public class Hotel {
    private String              name;
    private List<Room>          roomList;
    private ReservationManager  reservationManager;

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


