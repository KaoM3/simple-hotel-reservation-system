package model;

import java.util.*;
import model.hotel.*;
import service.HotelManager;

public class HotelReservationSystem {
    private List<Hotel>     hotelList;
    private HotelManager    hotelManager;

    /**
     * Constructor for class HotelReservationSystem
     */
    public HotelReservationSystem() {
        this.hotelList = new ArrayList<>();
        this.hotelManager = new HotelManager();
    }

    /**
     * Creates a new {@code Hotel} with param {@code hotelName} and adds it to
     * this system's hotelList
     * @param hotelName is the name of the new hotel
     */
    public void addHotel(String hotelName) {
        hotelList.add(new Hotel(hotelName));
    }

    /**
     * Removes a {@code Hotel} object matching with param {@code hotelName} from this system's hotelList
     * @param hotelName is the name of the hotel to be deleted
     */
    public void removeHotel(String hotelName) {
        hotelList.remove(getHotelByName(hotelName));
    }

    /**
     * Accesses {@code this.hotelManager} to edit a hotel object matching with param {@code hotelName}
     * @param hotelName is the name of the hotel to be edited
     */
    public void manageHotel(String hotelName) {
        this.hotelManager.setHotel(getHotelByName(hotelName));

        // TODO: Implement manageHotel
    }

    /**
     * Gets the {@code Hotel} object matching with param {@code hotelName}
     * @param hotelName is the name of the hotel to be returned
     * @return {@code Hotel} with name {@code hotelName}, {@code null} if {@code Hotel} cannot be found
     */
    private Hotel getHotelByName(String hotelName) {
        for(Hotel hotel : this.hotelList) {
            if(hotel.getName().contentEquals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }
}