package controller;

import model.hotel.*;
import view.*;
import service.*;

public class HotelReservationSystemController {
    private HotelManager hotelManager;
    private MainFrame mainframe;

    public HotelReservationSystemController(HotelManager hotelManager, MainFrame mainframe) {
        this.hotelManager = hotelManager;
        this.mainframe = mainframe;
    }
    
    public void addAndCreateHotel() {
        HotelService hs = new HotelService(null);
        hs.createAndAddRoom(null, HotelService.DELUXE);
    }

}
