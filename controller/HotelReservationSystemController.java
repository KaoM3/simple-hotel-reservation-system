package controller;

import java.util.List;

import model.hotel.Hotel;
import model.hotel.HotelManager;
import service.HotelManagerService;
import service.HotelService;

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

    public void createNewRoom(String hotelName, String roomName, int roomType) {
        HotelService hotelService = new HotelService(this.model.getHotelByName(hotelName));
        System.out.println(hotelService.createAndAddRoom(roomName, roomType));
    }
    
    public List<Hotel> getHotelObjects() {
        return this.model.getHotelList();
    }
}
