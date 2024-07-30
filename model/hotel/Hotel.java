package model.hotel;

import java.util.*;
import java.util.stream.Collectors;

import model.hotel.room.*;
import model.reservation.*;

/**
 * Object representation of a hotel. Contains its information such as the hotel's name,
 * list of rooms, and reservation manager. Does not contain setter methods. When setting
 * new values for the data, first instantiate a {@code HotelService} object then pass this
 * {@code Hotel} object.
 */
public class Hotel {
    private double              baseRate;
    private String              name;
    private List<Room>          roomList;
    private ReservationManager  reservationManager;

    public Hotel(String name) {
        this.baseRate = 1299;
        this.name = name;
        this.reservationManager = new ReservationManager();
        this.roomList = new ArrayList<>();
    }

    /**
     * @param baseRate new Base Rate (not including price modifiers)
     */
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    /**
     * @return the base rate of the rooms for this hotel
     */
    public double getBaseRate() {
        return this.baseRate;
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

    /**
     * Returns a room in this hotel that matches the given room name
     * @param roomName is the name of the room
     * @return Room that matches {@code roomName}, null if no matches
     */
    public Room getRoomByName(String roomName) {
        for (Room room : this.roomList) {
            if (room.getName().equalsIgnoreCase(roomName)) {
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
        return this.roomList.get(index);
    }

    /**
     * Finds all rooms within this hotel that are available within the specified check in and check out date
     * @param checkIn check in date
     * @param checkOut check out date
     * @return the ArrayList of all rooms that are available within checkIn and checkOut
     */
    public List<Room> filterRooms(int checkIn, int checkOut) {
        return roomList.stream()
                .filter(room -> this.getReservationManager().isRoomAvailableOnDate(room.getName(), checkIn, checkOut))
                .collect(Collectors.toList());
    }
}


