package model.hotel;

import java.util.*;

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
