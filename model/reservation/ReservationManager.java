package model.reservation;

import java.util.*;
import java.util.stream.Collectors;

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
     * Checks if a given room has no reservations within the given check-in and check-out date
     * @param roomName  is the name of the room
     * @param checkIn   is the check in date
     * @param checkOut  is the check out date
     * @return true if the room is available, false otherwise
     */
    public boolean isRoomAvailableOnDate(String roomName, int checkIn, int checkOut) {
        List<Reservation> roomReservations = filterReservations(roomName);
        for (Reservation reservation : roomReservations) {
            if (reservation.getCheckOut() > checkIn && reservation.getCheckIn() < checkOut) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds all reservations within this hotel with the same room name as roomName
     * @param roomName is the name of the room of the reservation
     * @return the ArrayList of all reservations with the same room roomName
     */
    public List<Reservation> filterReservations(String roomName) {
        return reservationList.stream()
                .filter(reservation -> reservation.getRoom().getName().equals(roomName))
                .collect(Collectors.toList());
    }

    /**
     * Finds all reservations within this hotel that are active on the given date
     * @param date is the date of the reservation
     * @return the ArrayList of all reservations occurring on @param date
     */
    public List<Reservation> filterReservations(int date) {
        return reservationList.stream()
                .filter(reservation -> reservation.getCheckIn() <= date && date < reservation.getCheckOut())
                .collect(Collectors.toList());
    }

    /**
     * @return this reservation manager's price modifier
     */
    public PriceModifier getPriceModifier() {
        return this.priceModifier;
    }
}
