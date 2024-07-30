package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;
import view.sub.ReservationListPanel;
import view.sub.RoomListPanel;
import view.sub.SubFrame;

public class ViewPanel extends JPanel implements ActionListener{
    private HotelReservationSystemController controller;

    private JButton viewReservationButton;
    private JButton refreshButton;
    private JButton viewRoomButton;

    private JScrollPane hotelListScrollPane;

    private JTable hotelListTable;

    /**
     * Constructor for class ViewHotelPanel
     */
    public ViewPanel(HotelReservationSystemController controller) {
        this.controller = controller;
        initComponents();
    }

    /**
     * Initializes the components of this panel
     */
    private void initComponents() {

        hotelListScrollPane = new javax.swing.JScrollPane();
        hotelListTable = new javax.swing.JTable();
        viewReservationButton = new JButton();
        refreshButton = new JButton();
        viewRoomButton = new JButton();

        setPreferredSize(new java.awt.Dimension(570, 480));
        setLayout(null);

        // Create Table Model
        String tableHeader[] = {"Hotel Name", "Base Rate", "No. of Rooms", "No. of Reservations"};
        DefaultTableModel tableModel = new DefaultTableModel(0, 4);
        tableModel.setColumnIdentifiers(tableHeader);
        
        // Set up hotel table
        hotelListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hotelListTable.setModel(tableModel);

        // Display Hotel Details in Table
        for(int i = 0; i < this.controller.getHotelObjects().size(); i++) {
            tableModel.addRow(new Object[] {this.controller.getHotelObjects().get(i).getName(),
                                            this.controller.getHotelObjects().get(i).getBaseRate(),
                                            this.controller.getHotelObjects().get(i).getRoomList().size(),
                                            this.controller.getHotelObjects().get(i).getReservationManager().getReservationList().size()});
        }
        
        hotelListScrollPane.setViewportView(hotelListTable);
        add(hotelListScrollPane);
        hotelListScrollPane.setBounds(20, 20, 530, 370);

        // Set up all buttons
        viewReservationButton.setText("View Hotel Reservation List");
        add(viewReservationButton);
        viewReservationButton.addActionListener(this);
        viewReservationButton.setBounds(20, 420, 190, 23);
        
        refreshButton.setText("Refresh Table");
        add(refreshButton);
        refreshButton.addActionListener(this);
        refreshButton.setBounds(440, 420, 110, 23);

        viewRoomButton.setText("View Hotel Room List");
        add(viewRoomButton);
        viewRoomButton.addActionListener(this);
        viewRoomButton.setBounds(230, 420, 190, 23);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == refreshButton) {
            refreshPanel();
        }
        else if(hotelListTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No Hotel Selected!");
        }
        else if(event.getSource() == viewReservationButton) {
            System.out.println("View Reservation");
            new SubFrame(new ReservationListPanel(controller, hotelListTable.getSelectedRow()));
        }
        else if(event.getSource() == viewRoomButton) {
            System.out.println("View Room");
            new SubFrame(new RoomListPanel(controller, hotelListTable.getSelectedRow()));
        }
    }

    /**
     * Refreshes this panel.
     */
    private void refreshPanel() {
        System.out.println("Refreshing Panel...");
        this.removeAll();
        this.initComponents();
        this.repaint();
        this.revalidate();
    }
    
    @Override
    public String getName() {
        return "View Hotel";
    }
}
