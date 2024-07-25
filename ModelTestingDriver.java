import model.hotel.Hotel;
import model.hotel.HotelManager;
import service.HotelService;
import service.PriceModifierService;

public class ModelTestingDriver {
    
        public static void main(String[] args) {

        HotelManager model = new HotelManager();

        ModelTesting testing = new ModelTesting(model);

        // Test createAndAddHotel
        System.out.println("===== Test createAndAddHotel() =====");
        testing.createNewHotel("  MY HOTEL 1");
        testing.createNewHotel("MY HOTEL 1  ");
        testing.createNewHotel("MY HOTEL #1");
        testing.createNewHotel("HI");
        testing.createNewHotel("MY HOTEL IS THE BEST HOTEL IN THE WORLD");
        testing.createNewHotel("MY HOTEL 1");
        
        // Test createAndAddHotel
        testing.createNewHotel("MY HOTEL 1");
        testing.createNewHotel("MY HOTEL 2");
        
        // Test removeHotel
        System.out.println("===== Test removeHotel() =====");
        testing.removeHotel("MY HOTEL 3");
        testing.removeHotel("MY HoTEL 2");
        
        
        
        // HOTEL SERVICE TESTING
        // Test isRoomNameValid
        System.out.println("===== Test isRoomNameValid() =====");
        testing.createNewRoom("MY HOTEL 1", "   Room S1", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "Room S1   ", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "Room #S1", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "HI", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "MY Room IS THE BEST Room IN THE WORLD", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "ROOM S1", HotelService.STANDARD);
        
        // Test createAndAddRoom
        System.out.println("===== Test createAndAddRoom() =====");
        testing.createNewRoom("MY HOTEL 1", "ROOM S1", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "ROOM S2", HotelService.STANDARD);
        testing.createNewRoom("MY HOTEL 1", "ROOM S3", 0);
        testing.createNewRoom("MY HOTEL 1", "ROOM S4", "Standard");
        
        // Test removeRoom
        System.out.println("===== Test removeRoom() =====");
        testing.removeRoom("MY HOTEL 1", "ROOM S3");
        testing.removeRoom("MY HOTEL 1", "ROOM S2");
        
        // Test renameHotel
        System.out.println("===== Test renameHotel() =====");
        testing.renameHotel("My Hotel 1", "NOT VALID!");
        testing.renameHotel("My Hotel 1", "New Hotel 1");
        
        // Test updateBaseRate
        System.out.println("===== Test renameHotel() =====");
        testing.updateBaseRate("New Hotel 1", 10);
        testing.updateBaseRate("New Hotel 1", 100);
        testing.updateBaseRate("New Hotel 1", 1000);
        
        
        // PRICE MODIFIER
        System.out.println("===== Test updateDatePriceModifier() =====");
        testing.updateHashMap("New Hotel 1", null, null);
        testing.updateHashMap("New Hotel 1", 30, null);
        testing.updateHashMap("New Hotel 1", null, 1.2);
        testing.updateHashMap("New Hotel 1", 33, 1.2);
        testing.updateHashMap("New Hotel 1", 30, 1.2);

        Hotel hotel = new Hotel("Driver hotel");
        PriceModifierService pms = new PriceModifierService(hotel.getReservationManager().getPriceModifier());
        System.out.println(pms.getDiscountCode("Payday"));
        System.out.println(pms.getDiscountCode("PAYDAY"));
        System.out.println(pms.getDiscountCode(null));
    }

}
