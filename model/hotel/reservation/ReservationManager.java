package model.hotel.reservation;

import java.util.*;

public class ReservationManager {
    private double              baseRate;
    private List<Reservation>   reservationList;

    /**
     * Constructor class for ReservationManager
     */
    public ReservationManager() {
        this.baseRate = 1299;
        this.reservationList = new ArrayList<>();
    }

    /**
     * @param baseRate new Base Rate (not including price modifiers)
     */
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    /**
     * Adds a Reservation to this.reservationList and calculates its price (applies price modifiers)
     * @param reservation is the reservation to be added
     */
    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);

        //TODO: Update add reservation to include price modifiers using class PriceModifier
    }

    /**
     * Removes a specific reservation from this.reservationList
     * @param index is the index of the reservation to be deleted
     */
    public void removeReservation(int index) {
        reservationList.remove(index);
    }

    /**
     * @return the base rate of the reservations for this hotel
     */
    public double getBaseRate() {
        return this.baseRate;
    }

    /**
     * @return the list of reservations for this hotel
     */
    public List<Reservation> getReservationList() {
        return this.reservationList;
    }
}
