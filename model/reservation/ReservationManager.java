package model.reservation;

import java.util.*;

import model.pricemodifier.PriceModifier;

public class ReservationManager {
    private List<Reservation>   reservationList;
    private PriceModifier       priceModifier;

    /**
     * Constructor class for ReservationManager
     */
    public ReservationManager() {
        this.reservationList = new ArrayList<>();
        this.priceModifier = new PriceModifier();
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
