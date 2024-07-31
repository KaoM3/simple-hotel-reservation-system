import java.util.HashMap;

import model.hotel.*;
import model.hotel.room.Room;
import model.reservation.Reservation;
import service.*;

public class ModelTesting {
    HotelManager model;

    public ModelTesting(HotelManager model) {
        this.model = model;
    }
    
    /** Test createAndAddHotel */
    public void createNewHotel(String hotelName) {
        HotelManagerService modelService = new HotelManagerService(this.model);
        System.out.println(modelService.createAndAddHotel(hotelName));        
    }

    /** Test removeHotel */
    public void removeHotel(String hotelName) {
        HotelManagerService modelService;
        modelService = new HotelManagerService(model);

        System.out.println(modelService.removeHotel(hotelName));
    }

    /** Test createAndAddRoom */
    public void createNewRoom(String hotelName, String roomName, int roomType) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.createAndAddRoom(roomName, roomType));
    }

    /** Test createAndAddRoom */
    public void createNewRoom(String hotelName, String roomName, String roomType) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.createAndAddRoom(roomName, roomType));
    }

    /** Test removeRoom */
    public void removeRoom(String hotelName, String roomName) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.removeRoom(this.model.getHotelByName(hotelName).getRoomByName(roomName)));
    }

    /** Test renameHotel */
    public void renameHotel(String hotelName, String newName) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.renameHotel(newName));

    }

    /** Test updateBaseRate */
    public void updateBaseRate(String hotelName, double baseRate) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.updateBaseRate(baseRate));
    }

    public void createNewReservation(String hotelName, String roomName, String guestName, int checkIn, int checkOut, String discount) {
        ReservationManagerService reservationService = new ReservationManagerService(this.model.getHotelByName(hotelName).getReservationManager());
        
        System.out.println(reservationService.createAndAddReservation(guestName, this.model.getHotelByName(hotelName).getRoomByName(roomName), checkIn, checkOut, discount));
    }

    public void removeReservation(String hotelName, int index) {
        ReservationManagerService reservationService = new ReservationManagerService(this.model.getHotelByName(hotelName).getReservationManager());

        reservationService.removeReservation(index);
    }
    
    /** Test updateDatePriceModifier */
    public void updateHashMap(String hotelName, Integer date, Double multiplier) {
        PriceModifierService priceService = new PriceModifierService(this.model.getHotelByName(hotelName).getReservationManager().getPriceModifier());
        
        System.out.println(priceService.updateDatePriceModifier(date, multiplier));
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
        System.out.println("\n==========RESERVATIONS==========");
        
        for(Reservation reservation : hotel.getReservationManager().getReservationList()) {
            System.out.println(String.format("%s: %s %d %d %f", reservation.getGuestName(),
            reservation.getRoom().getName(),
            reservation.getCheckIn(),
            reservation.getCheckOut(),
            reservation.getTotalPrice()));
        }
    }
    
    public void printHotelHashMap(Hotel hotel) {
        System.out.println("\n==========DATE PRICE MODIFIER==========");
        HashMap<Integer, Double> hashmap = hotel.getReservationManager().getPriceModifier().getDatePriceModifier();
        for(Integer dateKey : hashmap.keySet()) {
            if(hashmap.get(dateKey) != 1) {
                System.out.println(String.format("Date %d: \t%.2f", dateKey, hashmap.get(dateKey)));
            }
        }
    }

    public void printHotelEarnings(Hotel hotel) {
        System.out.println("\n==========EARNINGS==========");
        System.out.println(new ReservationManagerService(hotel.getReservationManager()).getHotelEarnings());
    }

    public void printHotelDetails() {
        System.out.println("\n==========PRINT HOTEL DETAILS==========");
        for(Hotel hotel : this.model.getHotelList()) {
            System.out.println("\n==============================");
            System.out.println(hotel.getName());
            System.out.println("------------------------------\n");
            
            printHotelRooms(hotel);
            printHotelReservations(hotel);
            printHotelHashMap(hotel);
            printHotelEarnings(hotel);
        }
    }

}
