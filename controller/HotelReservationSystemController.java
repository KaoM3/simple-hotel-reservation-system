package controller;

import java.util.List;
import model.hotel.Hotel;
import model.hotel.HotelManager;
import model.hotel.room.Room;
import model.reservation.Reservation;
import service.HotelManagerService;
import service.HotelService;
import service.PriceModifierService;
import service.ReservationManagerService;

public class HotelReservationSystemController {
    HotelManager model;

    public HotelReservationSystemController(HotelManager model) {
        this.model = model;
    }

    public void createNewHotel(String hotelName, String roomName, int roomType) {
        boolean hotelCreation, roomCreation = false;

        HotelManagerService modelService = new HotelManagerService(this.model);
        hotelCreation = modelService.createAndAddHotel(hotelName);

        if(hotelCreation == true) {
            HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
            roomCreation = hotelService.createAndAddRoom(roomName, roomType);
        }

        System.out.println(String.format("Creation of hotel %s: %b", hotelName, hotelCreation));
        System.out.println(String.format("Creation of room %s with room type %d: %b", roomName, roomType, roomCreation));
        
        if(hotelCreation == true && roomCreation == false) {
            modelService.removeHotel(hotelName);
            System.out.println("Hotel has no room, deleting hotel...");
        }
    }

    public List<Reservation> getHotelReservationList(Hotel hotel) {
        return hotel.getReservationManager().getReservationList();
    }

    public List<Reservation> getHotelReservationList(Hotel hotel, Room room) {
        return hotel.getReservationManager().getReservationList();
    }

    public Hotel getHotel(int index) {
        return model.getHotelByIndex(index);
    }

    public List<Room> getHotelRoomList(Hotel hotel) {
        return hotel.getRoomList();
    }

    public void createNewRoom(String hotelName, String roomName, int roomType) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.createAndAddRoom(roomName, roomType));
    }

    public void updateDatePrice(Hotel hotel, int date, double multiplier) {
        PriceModifierService modifierService = new PriceModifierService(hotel.getReservationManager().getPriceModifier());
        System.out.println(modifierService.updateDatePriceModifier(date, multiplier));
    }
    
    public List<Hotel> getHotelObjects() {
        return this.model.getHotelList();
    }

    public void deleteReservation(Hotel hotel, int index) {
        ReservationManagerService reservationService = new ReservationManagerService(hotel.getReservationManager());
        System.out.println(reservationService.removeReservation(index));
    }
}
