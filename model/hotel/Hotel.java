package model.hotel;

import java.util.List;
import model.room.*;
import model.hotel.reservation.*;

public class Hotel {
    private String              name;
    private List<Room>          roomList;
    private ReservationManager  reservationManager;
    private PriceModifier       priceModifier;


}


