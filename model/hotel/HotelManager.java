package model.hotel;

import java.util.*;

public class HotelManager {
    List<Hotel> hotelList;
    
    /** Constructor for class HotelManager */
    public HotelManager() {
        this.hotelList = new ArrayList<>();
    }

    /**
     * Adds a Hotel object to this.hotelList
     * @param hotel is the hotel to be added
     */
    public void addHotel(Hotel hotel) {
        hotelList.add(hotel);
        // TODO: Decide if this is redundant
    }

    /**
     * Removes a hotel object from this.hotelList
     * @param hotel is the hotel to be removed
     */
    public void removeHotel(Hotel hotel) {
        hotelList.remove(hotel);
        // TODO: Decide if this is redundant
    }

    /**
     * @return this.hotelList
     */
    public List<Hotel> getHotelList() {
        return this.hotelList;
    }


}
