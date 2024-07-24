package model.hotel;

import java.util.*;

/**
 * Represents a list of {@code Hotel} objects. Does not contain setter methods. When setting
 * new values for the data, first instantiate a {@code HotelManagerService} object then pass this
 * {@code HotelManager} object.
 */
public class HotelManager {
    List<Hotel> hotelList;
    
    /** Constructor for class HotelManager */
    public HotelManager() {
        this.hotelList = new ArrayList<>();
    }

    /**
     * @return this.hotelList
     */
    public List<Hotel> getHotelList() {
        return this.hotelList;
    }

    /**
     * Returns a hotel object from this.hotelManager's hotelList with name matching {@code hotelName}
     * @param hotelName is the name of the hotel
     * @return hotel object with name {@code hotelname}, null if no matches
     */
    public Hotel getHotelByName(String hotelName) {
        for(Hotel hotel : this.hotelList) {
            if(hotel.getName().contentEquals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }

    /**
     * Returns a hotel object at the specified index of this.hotelManager's hotelList
     * @param index is the index of the hotel
     * @return
     */
    public Hotel getHotelByIndex(int index) {
        return this.hotelList.get(index);
    }

}
