package service;

import model.hotel.*;

public class HotelManagerService {
    private HotelManager hotelManager;

    public HotelManagerService(HotelManager hotelManager) {
        this.hotelManager = hotelManager;
    }

    /**
     * Creates and adds a new hotel with name {@code hotelName} to this hotelManager's hotel list
     */
    public void createAndAddHotel(String hotelName) {
        Hotel newHotel = new Hotel(hotelName);

        if(getHotelByName(hotelName) == null) {
            this.hotelManager.getHotelList().add(newHotel);
        }
    }

    /**
     * Removes the {@code room} instance from this hotel's room list
     * @param room is the room to be removed
     */
    public void removeHotel(String hotelName) {
        this.hotelManager.getHotelList().remove(getHotelByName(hotelName));
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
