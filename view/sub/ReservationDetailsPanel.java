package view.sub;

import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;
import model.reservation.Reservation;

public class ReservationDetailsPanel extends JPanel {

    private HotelReservationSystemController controller;
    private int index, resIndex;

    private JScrollPane listScrollPane;

    private JTable detailsTable;

    private JLabel discountTextLabel;
    private JLabel discountPriceLabel;
    private JLabel discountCodeLabel;
    private JLabel totalPriceLabel;

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

        discountTextLabel = new JLabel();
        discountPriceLabel = new JLabel();
        discountCodeLabel = new JLabel();
        totalPriceLabel = new JLabel();

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
        listScrollPane.setBounds(20, 20, 261, 150);

        discountCodeLabel.setText(reservationData.getDiscountCode());
        add(discountCodeLabel);
        discountCodeLabel.setBounds(40, 200, 120, 20);

        discountPriceLabel.setText(String.format("-%.2f", reservationData.getDiscountPrice()));
        add(discountPriceLabel);
        discountPriceLabel.setBounds(200, 180, 80, 20);

        totalPriceLabel.setText(String.format("Total: %.2f", reservationData.getTotalPrice()));
        add(totalPriceLabel);
        totalPriceLabel.setBounds(170, 200, 110, 20);

        discountTextLabel.setText("Discount Code:");
        add(discountTextLabel);
        discountTextLabel.setBounds(40, 180, 120, 20);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 240);
    }

    @Override
    public String getName() {
        return "Reservation Details";
    }
}
