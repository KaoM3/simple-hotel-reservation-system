
import controller.*;
import model.hotel.*;
import view.*;

public class Driver {
    
    public static void main(String[] args) {
        
        HotelManager model = new HotelManager();

        HotelReservationSystemController controller = new HotelReservationSystemController(model);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {        
                new MainFrame(controller).setVisible(true);
            }
        });
    }

}
