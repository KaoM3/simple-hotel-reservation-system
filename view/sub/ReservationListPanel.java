package view.sub;

import controller.HotelReservationSystemController;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.reservation.Reservation;

public class ReservationListPanel extends JPanel implements ActionListener {
    private final HotelReservationSystemController controller;

    private final int index;

    private JButton refreshButton, detailsButton;

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
        
        listScrollPane = new JScrollPane();
        reservationTable = new JTable();
        headerLabel = new JLabel();
        refreshButton = new JButton();
        detailsButton = new JButton();

        setPreferredSize(new java.awt.Dimension(600, 480));
        setLayout(null);

        // Set Up Table
        DefaultTableModel tableModel = new DefaultTableModel(0, 5);
        String tableHeader[] = {"Room Name", "Guest", "Check In", "Check Out", "Total Price"};
        tableModel.setColumnIdentifiers(tableHeader);
        
        reservationTable.setModel(tableModel);

        // Display Hotel Details in Table
        for (Reservation reservation : controller.getHotelReservationList(controller.getHotel(index))) {
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

        detailsButton.setText("View Details");
        detailsButton.addActionListener(this);
        add(detailsButton);
        detailsButton.setBounds(330, 440, 130, 23);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == refreshButton) {
            refreshPanel();
        }
        else if (reservationTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "No Reservation Selected!");
        }
        else if (event.getSource() == detailsButton) {
            new SubFrame(new ReservationDetailsPanel(controller, index, reservationTable.getSelectedRow()));
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