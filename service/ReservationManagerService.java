package service;

import model.reservation.*;

public class ReservationManagerService {
    ReservationManager reservationManager;

    public ReservationManagerService(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    /**
     * Adds a Reservation to this.reservationList and calculates its price (applies price modifiers)
     * @param reservation is the reservation to be added
     */
    public void createAndAddReservation(Reservation reservation) {
        this.reservationManager.getReservationList().add(reservation);

        // TODO: Think of where reservation would be created (in here or another class)
        // TODO: Update add reservation to include price modifiers using class PriceModifier
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
