import java.util.List;
import java.util.ArrayList;

import model.hotel.HotelManager;
import controller.HotelReservationSystemController;
import view.MainFrame;

public class Driver {
    
    public static void main(String[] args) {

        HotelManager model = new HotelManager();

        MainFrame view = new MainFrame();

        HotelReservationSystemController controller = new HotelReservationSystemController(model, view)

        view.setController(controller);
        view.initialize();

        /**
         * TESTING OF MAINFRAME
         */
        // List<String> list = new ArrayList<>();

        // for(int i = 0; i < 44; i++) {
        //     list.add(String.format("Hotel %d", i + 1));
        // }
        
        // // new MainFrame(new MainMenuPanel(list));
        // MainFrame mainframe = new MainFrame();
        // mainframe.setPanel(new MainMenuPanel(list));
    }

}
