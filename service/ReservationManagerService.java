package service;

import model.hotel.room.*;
import model.pricemodifier.PriceModifier;
import model.reservation.*;

public class ReservationManagerService {
    ReservationManager reservationManager;

    public ReservationManagerService(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    /**
     * Creates a new reservation object and adds it to this reservationManager's reservation list
     * @param guestName is the name of the guest
     * @param room is the room object
     * @param checkIn is the check in date
     * @param checkOut is the check out date
     * @param discountCode is the discount code used
     */
    public void createAndAddReservation(String guestName, Room room, int checkIn, int checkOut, String discountCode) {

        // Instantiate Necessary Services
        PriceModifierService priceModifier = new PriceModifierService(this.reservationManager.getPriceModifier());

        // Calculate base price (rooms total price per night multiplied by date price modifier)
        double totalPrice = 0;
        for(int date = checkIn; date < checkOut; date++) {
            totalPrice += room.getTotalPrice() * priceModifier.getPriceModifier(date);
        }

        // Apply discount code
        double firstDayPrice = room.getTotalPrice() * priceModifier.getPriceModifier(checkIn);
        totalPrice = priceModifier.getDiscountCode(discountCode)
                                    .applyDiscount(checkIn, checkOut, totalPrice, firstDayPrice);

        // Add new reservation to system
        this.reservationManager.getReservationList()
                                .add(new Reservation(guestName, room, checkIn, checkOut, totalPrice));
    }

    /**
     * Removes a specific reservation from this.reservationList
     * @param index is the index of the reservation to be deleted
     * @return true if index can be removed, false otherwise
     */
    public boolean removeReservation(int index) {
        try {
            this.reservationManager.getReservationList().remove(index);
            return true;
        } catch (IndexOutOfBoundsException error) {
            System.out.println(error);
            return false;
        }
    }

    /**
     * Sets the base rate of this.reservationManager if {@code baseRate} is valid
     * @param baseRate is the new base rate (baseRate >= 100)
     * @return true if baseRate is valid, false otherwise
     */
    public boolean updateBaseRate(double baseRate) {
        
        if(baseRate < 100) {
            return false;
        }
        
        this.reservationManager.setBaseRate(baseRate);
        return true;
    }
}
