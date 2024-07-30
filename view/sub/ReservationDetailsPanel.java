package view.sub;

import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;
import model.reservation.Reservation;

public class ReservationDetailsPanel extends javax.swing.JPanel {
    private HotelReservationSystemController controller;
    private int index, resIndex;
    private JScrollPane listScrollPane;
    private JTable detailsTable;

    /**
     * Constructor for class ReservationDetailsPanel
     */
    public ReservationDetailsPanel(HotelReservationSystemController controller, int index, int resIndex) {
        this.controller = controller;
        this.index = index;
        this.resIndex = resIndex;
        initComponents();
    }

    /**
     * Initializes components for this panel
     */
    private void initComponents() {

        listScrollPane = new JScrollPane();
        detailsTable = new JTable();

        setLayout(null);

        String tableHeader[] = {"Date", "Price of this night"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(tableHeader);
        
        // Set up reservation reference
        Reservation reservationData = controller.getHotel(index).getReservationManager().getReservationList().get(resIndex);
        HashMap<Integer, Double> reservationBreakdown = reservationData.getPriceBreakdown();

        // Run through each date in the reservation
        for(int currentDate = reservationData.getCheckIn(); currentDate < reservationData.getCheckOut(); currentDate++) {
            tableModel.addRow(new Object[] {
                String.format("%d -> %d", currentDate, currentDate + 1),
                reservationBreakdown.get(currentDate)
            });
        }

        detailsTable.setEnabled(false);
        detailsTable.setModel(tableModel);

        listScrollPane.setViewportView(detailsTable);
        add(listScrollPane);
        listScrollPane.setBounds(20, 20, 560, 200);
    }       
}
