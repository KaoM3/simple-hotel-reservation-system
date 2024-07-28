package controller;

import java.util.List;

import model.hotel.Hotel;
import model.hotel.HotelManager;
import service.*;

public class HotelReservationSystemController {
    HotelManager model;

    public HotelReservationSystemController(HotelManager model) {
        this.model = model;
    }

    public void createNewHotel(String hotelName) {
        HotelManagerService modelService = new HotelManagerService(this.model);
        System.out.println(modelService.createAndAddHotel(hotelName));        
    }
    
    public List<Hotel> getHotelObjects() {
        return this.model.getHotelList();
    }
}
