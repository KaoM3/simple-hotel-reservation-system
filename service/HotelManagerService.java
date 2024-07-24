package service;

import model.hotel.*;

/**
 * Contains all the business logic for editing the data inside a {@code HotelManager} object.
 * This class should be instantiated to manipulate the data of this.hotelManager.
 */
public class HotelManagerService {
    private HotelManager hotelManager;

    /** Constructor for class HotelManagerService */
    public HotelManagerService(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    /**
     * Creates and adds a new hotel with name {@code hotelName} to this hotelManager's hotel list
     * @param hotelName is the name of the new hotel
     * @return true if hotel was successfully created, false otherwise
     */
    public boolean createAndAddHotel(String hotelName) {
        if(getHotelByName(hotelName) == null) {
            Hotel newHotel = new Hotel(hotelName);
            this.hotelManager.getHotelList().add(newHotel);
            return true;
        }
        return false;
    }

    /**
     * Removes the {@code hotel} object from this hotel manager's hotel list
     * @param hotelName is the name of the hotel to be removed
     * @return true if successful, false otherwise
     */
    public boolean removeHotel(String hotelName) {
        try {
            return this.hotelManager.getHotelList().remove(getHotelByName(hotelName));
        } catch (NullPointerException error) {
            System.out.println(error);
            return false;
        }
    }

    /**
     * Returns a hotel object from this.hotelManager's hotelList with name matching {@code hotelName}
     * @param hotelName is the name of the hotel
     * @return hotel object with name {@code hotelname}, null if no matches
     */
    public Hotel getHotelByName(String hotelName) {
        for(Hotel hotel : this.hotelManager.getHotelList()) {
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
        return this.hotelManager.getHotelList().get(index);
    }

}
