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


}
