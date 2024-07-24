package controller;

import model.hotel.*;
import model.reservation.Reservation;
import view.*;
import service.*;

public class HotelReservationSystemController {
    private HotelManager hotelManager;
    private MainFrame mainframe;

    public HotelReservationSystemController(HotelManager hotelManager, MainFrame mainframe) {
        this.hotelManager = hotelManager;
        this.mainframe = mainframe;
    }
    
    public void addAndCreateHotel(String hotelNameInput) {

        HotelManagerService hotelManagerService = new HotelManagerService(this.hotelManager);
        hotelManagerService.createAndAddHotel(hotelNameInput);
    }

    public void viewHotel() {

    }

    public void manageHotel() {

    }

    public void simulateBooking() {
    }

    /** Books a reservation for a specific hotel */
    private void bookReservation(Hotel hotel, String guestName, String roomName, int checkIn, int checkOut, String discountCode) {
        
        // Instantiate Necessary Services
        HotelService hotelService = new HotelService(hotel);
        ReservationManagerService booking = new ReservationManagerService(hotel.getReservationManager());
        PriceModifierService pricing = new PriceModifierService(hotel.getReservationManager().getPriceModifier());

        // Calculate price
        double totalPrice;

        booking.createAndAddReservation(
            guestName, null, checkIn, checkOut, checkOut);
    }

}
