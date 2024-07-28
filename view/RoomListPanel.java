package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;
import model.hotel.room.Room;

public class RoomListPanel extends JPanel implements ActionListener {
    private final HotelReservationSystemController controller;
    private final int index;
    private JButton refreshButton;
    private JScrollPane listScrollPane;
    private JLabel headerLabel;
    private JTable reservationTable;

    public RoomListPanel(HotelReservationSystemController controller, int index) {
        this.controller = controller;
        this.index = index;
        controller.getHotelObjects().get(index);
        initComponents();
    }

    private void initComponents() {
        
        listScrollPane = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        headerLabel = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 480));
        setLayout(null);

        // Set Up Table
        DefaultTableModel tableModel = new DefaultTableModel(0, 4);
        String tableHeader[] = {"Room Name", "Room Type", "Price per Night", "No. of Reservations"};
        tableModel.setColumnIdentifiers(tableHeader);
        
        reservationTable.setModel(tableModel);
        reservationTable.setEnabled(false);

        // Display Hotel Details in Table
        for(Room room : controller.getHotelRoomList(controller.getHotel(index))) {
            String roomType;

            if(room.getMultiplier() == 1.0) {
                roomType = "STANDARD";
            } else if(room.getMultiplier() == 1.2) {
                roomType = "DELUXE";
            } else if(room.getMultiplier() == 1.35) {
                roomType = "EXECUTIVE";
            } else {
                roomType = "null";
            }

            tableModel.addRow(new Object[] {room.getName(),
                                            roomType,
                                            room.getTotalPrice(),
                                            controller.getHotel(index).getReservationManager().filterReservations(room.getName()).size()});
        }

        
        listScrollPane.setViewportView(reservationTable);

        add(listScrollPane);
        listScrollPane.setBounds(20, 60, 560, 360);

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText(String.format("Viewing Room List: [%s]", controller.getHotel(index).getName()));
        add(headerLabel);
        headerLabel.setBounds(20, 20, 560, 30);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(this);
        add(refreshButton);
        refreshButton.setBounds(480, 440, 100, 23);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == refreshButton) {
            refreshPanel();
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
    public Dimension getPreferredSize() {
        return new Dimension(600, 480);
    }
}