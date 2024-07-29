package view.sub;

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
import model.reservation.Reservation;

public class ReservationListPanel extends JPanel implements ActionListener {
    private final HotelReservationSystemController controller;
    private final int index;
    private JButton refreshButton;
    private JScrollPane listScrollPane;
    private JLabel headerLabel;
    private JTable reservationTable;

    public ReservationListPanel(HotelReservationSystemController controller, int index) {
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
        DefaultTableModel tableModel = new DefaultTableModel(0, 5);
        String tableHeader[] = {"Room Name", "Guest", "Check In", "Check Out", "Total Price"};
        tableModel.setColumnIdentifiers(tableHeader);
        
        reservationTable.setModel(tableModel);

        // Display Hotel Details in Table
        for(Reservation reservation : controller.getHotelReservationList(controller.getHotel(index))) {
            tableModel.addRow(new Object[] {reservation.getRoom().getName(),
                                            reservation.getGuestName(),
                                            reservation.getCheckIn(),
                                            reservation.getCheckOut(),
                                            reservation.getTotalPrice()});
        }

        
        listScrollPane.setViewportView(reservationTable);

        add(listScrollPane);
        listScrollPane.setBounds(20, 60, 560, 360);

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText(String.format("Viewing Reservation List: [%s]", controller.getHotel(index).getName()));
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
    
    @Override
    public String getName() {
        return "Hotel Reservation List";
    }
}