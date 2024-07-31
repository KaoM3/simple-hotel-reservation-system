package service;

import model.hotel.Hotel;
import model.hotel.HotelManager;

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

        if (!isHotelNameValid(hotelName)) {
            return false;
        }

        if (this.hotelManager.getHotelByName(hotelName) == null) {
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
            if (this.hotelManager.getHotelByName(hotelName).getReservationManager().getReservationList().size() <= 0) {
                return this.hotelManager.getHotelList().remove(this.hotelManager.getHotelByName(hotelName));
            }
            return false;
        } catch (NullPointerException error) {
            System.out.println(error);
            return false;
        }
    }

    /**
     * Checks if a given {@code hotelName} is valid. String has no leading or trailing
     * whitespaces. String may only contain alphabetical and numerical letters.
     * @param hotelName is the string to be checked.
     * @return true if string is valid, false otherwise.
     */
    private boolean isHotelNameValid(String hotelName) {
        boolean hasWhiteSpace = hotelName.charAt(0) == ' ' || hotelName.charAt(hotelName.length()-1) == ' ';
        boolean isValidLength = hotelName.length() >= 3 && hotelName.length() <= 20 && hotelName != null;
        boolean hasValidChars = hotelName.matches("[ a-zA-z0-9]+");

        return !hasWhiteSpace && isValidLength && hasValidChars;
    }
}
