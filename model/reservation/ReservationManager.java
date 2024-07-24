package model.reservation;

import java.util.*;

import model.pricemodifier.PriceModifier;

/**
 * Contains a hotel's list of reservations and date price modifier.
 * Does not contain setter methods. When updating the reservationList,
 * first instantiate a {@code ReservationManagerService} object then pass this
 * {@code ReservationManager} object.
 */
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
