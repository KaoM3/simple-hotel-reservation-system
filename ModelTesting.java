import java.util.HashMap;
import java.util.Scanner;

import model.hotel.*;
import model.hotel.room.Room;
import model.reservation.Reservation;
import service.*;

public class ModelTesting {
    Scanner sc = new Scanner(System.in);
    HotelManager model;

    public ModelTesting(HotelManager model) {
        this.model = model;
    }
    
    public void createNewHotel(String hotelName) {
        HotelManagerService modelService = new HotelManagerService(this.model);

        if(modelService.createAndAddHotel(hotelName)) {
            System.out.printf("Created Hotel %s, call create new room.\n", modelService.getHotelByName(hotelName).getName());
        }
        
    }

    public void createNewRoom(String hotelName, String roomName, int roomType) {
        // Initialize neccessary services
        HotelManagerService modelService = new HotelManagerService(this.model);
        HotelService hotelService = new HotelService(modelService.getHotelByName(hotelName));

        // Add room to hotel
        hotelService.createAndAddRoom(roomName, roomType);
        
    }

    public void createNewReservation(String hotelName, String roomName, String guestName, int checkIn, int checkOut, String discount) {
        HotelManagerService modelService = new HotelManagerService(this.model);
        HotelService hotelService = new HotelService(modelService.getHotelByName(hotelName));
        ReservationManagerService reservationService = new ReservationManagerService(modelService.getHotelByName(hotelName).getReservationManager());
        
        reservationService.createAndAddReservation(guestName, hotelService.getRoomByName(roomName), checkIn, checkOut, discount);
    }
    
    public void updateBaseRate(String hotelName, double baseRate) {
        HotelManagerService modelService = new HotelManagerService(this.model);
        HotelService hotelService = new HotelService(modelService.getHotelByName(hotelName));
        
        hotelService.updateBaseRate(baseRate);
    }
    
    public void updateHashMap(String hotelName, int date, double multiplier) {
        HotelManagerService modelService = new HotelManagerService(this.model);
        PriceModifierService priceService = new PriceModifierService(modelService.getHotelByName(hotelName).getReservationManager().getPriceModifier());

        priceService.updateDatePriceModifier(date, multiplier);
    }

    // PRINT FUNCTIONS

    public void printHotels() {
        System.out.println("==========PRINT HOTELS==========");
        for(Hotel hotel : this.model.getHotelList()) {
            System.out.println(hotel.getName());
        }
    }
    
    public void printHotelRooms(Hotel hotel) {
        System.out.println("==========ROOMS==========");
        for(Room room : hotel.getRoomList()) {
            System.out.println(room.getName());
        }
    }
    
    public void printHotelReservations(Hotel hotel) {
        System.out.println("==========RESERVATIONS==========");
        
        for(Reservation reservation : hotel.getReservationManager().getReservationList()) {
            System.out.println(String.format("%s: %s %d %d %f", reservation.getGuestName(),
                                                                reservation.getRoom().getName(),
                                                                reservation.getCheckin(),
                                                                reservation.getCheckOut(),
                                                                reservation.getTotalPrice()));
        }
    }

    public void printHotelHashMap(Hotel hotel) {
        HashMap<Integer, Double> hashmap = hotel.getReservationManager().getPriceModifier().getDatePriceModifier();
        for(Integer dateKey : hashmap.keySet()) {
            System.out.println(String.format("Date %d: \t%f", dateKey, hashmap.get(dateKey)));
        }
    }

    public void printHotelDetails() {
        System.out.println("==========PRINT HOTEL DETAILS==========");
        for(Hotel hotel : this.model.getHotelList()) {
            System.out.println(hotel.getName());
            
            printHotelRooms(hotel);
            printHotelReservations(hotel);
            printHotelHashMap(hotel);
        }
    }

}
