package model.reservation;

import java.util.*;

import model.pricemodifier.PriceModifier;

public class ReservationManager {
    private double              baseRate;
    private List<Reservation>   reservationList;
    private PriceModifier       priceModifier;

    /**
     * Constructor class for ReservationManager
     */
    public ReservationManager() {
        this.baseRate = 1299;
        this.reservationList = new ArrayList<>();
        this.priceModifier = new PriceModifier();
    }

    /**
     * @param baseRate new Base Rate (not including price modifiers)
     */
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
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

    /**
     * @return this reservation manager's price modifier
     */
    public PriceModifier getPriceModifier() {
        return this.priceModifier;
    }
}
