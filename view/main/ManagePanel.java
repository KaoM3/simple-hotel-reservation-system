package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;
import view.sub.ModifyRoomPanel;
import view.sub.PriceModifierPanel;
import view.sub.ReservationDeletePanel;
import view.sub.SubFrame;

/**
 *
 * @author Rafael
 */
public class ManagePanel extends JPanel implements ActionListener {
    private HotelReservationSystemController controller;
    private JButton confirmUpdateButton, confirmRenameButton, deleteButton;
    private JButton modifyRoomListButton, removeReservationButton, modifyDatePriceButton;
    private JLabel basePriceHeading, renameLabel, confirmUpdateLabel, hotelHeading, updateLabel, confirmRenameLabel;
    private JTextField newNameField, newPriceField;
    private JScrollPane hotelTablePane;
    private JTable hotelTable;

    /**
     * Constructor for class ManagePanel
     */
    public ManagePanel(HotelReservationSystemController controller) {
        this.controller = controller;
        initComponents();
    }
    
    /**
     * Initializes the components of this panel
     */
    private void initComponents() {

        confirmUpdateButton = new JButton("OK");
        modifyRoomListButton = new JButton("Modify Room List");
        removeReservationButton = new JButton("Remove Reservation");
        modifyDatePriceButton = new JButton("Modify Date Price");
        confirmRenameButton = new JButton("OK");
        deleteButton = new JButton("Delete Selected Hotel");
        newNameField = new JTextField("New Hotel Name");
        newPriceField = new JTextField("New Base Rate");
        basePriceHeading = new JLabel();
        renameLabel = new JLabel();
        confirmUpdateLabel = new JLabel();
        hotelTable = new JTable();
        hotelHeading = new JLabel();
        updateLabel = new JLabel();
        confirmRenameLabel = new JLabel();
        hotelTablePane = new JScrollPane();

        setLayout(null);


        // Create Table Model
        DefaultTableModel tableModel = new DefaultTableModel(0, 1);
        String tableHeader[] = {"Select a Hotel"};
        tableModel.setColumnIdentifiers(tableHeader);
        
        hotelTable.setModel(tableModel);

        // Display Hotel Details in Table
        for(int i = 0; i < this.controller.getHotelObjects().size(); i++) {
            tableModel.addRow(new Object[] {this.controller.getHotelObjects().get(i).getName()});
        }
        
        // Set selection model then add listener
        hotelTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = hotelTable.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                handleSelection(event);
            }
        });
    
        hotelTablePane.setViewportView(hotelTable);

        hotelTablePane.setBounds(20, 30, 220, 290);

        // Set up all buttons
        confirmUpdateButton.addActionListener(this);
        confirmUpdateButton.setBounds(370, 260, 170, 20);
        
        deleteButton.addActionListener(this);
        deleteButton.setBounds(260, 300, 280, 20);

        modifyRoomListButton.addActionListener(this);
        modifyRoomListButton.setBounds(380, 350, 160, 90);

        removeReservationButton.addActionListener(this);
        removeReservationButton.setBounds(20, 350, 160, 90);

        modifyDatePriceButton.addActionListener(this);
        modifyDatePriceButton.setBounds(200, 350, 160, 90);

        confirmRenameButton.addActionListener(this);
        confirmRenameButton.setBounds(370, 130, 170, 20);

        // Set up all labels
        basePriceHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        basePriceHeading.setText("No Selected Hotel.");
        basePriceHeading.setBounds(260, 190, 280, 20);

        renameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        renameLabel.setText("Rename Hotel:");
        renameLabel.setBounds(260, 90, 100, 30);

        confirmUpdateLabel.setText("Confirm Update:");
        confirmUpdateLabel.setBounds(260, 260, 100, 16);

        hotelHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hotelHeading.setText("No Selected Hotel");
        hotelHeading.setBounds(260, 40, 280, 20);

        updateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateLabel.setText("Update Rate:");
        updateLabel.setBounds(260, 220, 100, 30);

        confirmRenameLabel.setText("Confirm Rename:");
        confirmRenameLabel.setBounds(260, 130, 100, 16);

        // Set up all text fields
        newPriceField.setBounds(370, 220, 170, 30);
        newNameField.setBounds(370, 90, 170, 30);
        
        // Add all components to the panel
        add(confirmUpdateButton);
        add(newNameField);
        add(basePriceHeading);
        add(renameLabel);
        add(confirmUpdateLabel);
        add(hotelTablePane);
        add(deleteButton);
        add(modifyRoomListButton);
        add(removeReservationButton);
        add(modifyDatePriceButton);
        add(hotelHeading);
        add(updateLabel);
        add(newPriceField);
        add(confirmRenameLabel);
        add(confirmRenameButton);
    }                  

    /**
     * Updates the labels whenever a new row is selected in hotelTable
     */
    public void handleSelection(ListSelectionEvent event) {
        hotelHeading.setText(String.format("Selected Hotel: %s",
                                            this.controller.getHotel(hotelTable.getSelectedRow()).getName()));
        
        basePriceHeading.setText(String.format("Hotel Base Rate: %.2f",
                                                this.controller.getHotel(hotelTable.getSelectedRow())
                                                .getBaseRate()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(hotelTable.getSelectedRow() == -1) {
            System.out.println("No Hotel Selected");
            JOptionPane.showMessageDialog(null, "No Hotel Selected");
        }
        else if(event.getSource() == confirmUpdateButton) {
            System.out.println("Confirm Update Price Button");
            try {
                double newPrice = Double.parseDouble(newPriceField.getText());
                confirmUpdateButtonFunction(newPrice);
            } catch (NumberFormatException error) {
                System.out.println(error);
                JOptionPane.showMessageDialog(null, "Enter a valid double value!");
                newPriceField.setText("");
            }
        }
        else if(event.getSource() == confirmRenameButton) {
            System.out.println("Confirm Rename Button");
            confirmRenameButtonFunction();
        }
        else if(event.getSource() == deleteButton) {
            System.out.println("delete");
            deleteButtonFunction();
        }
        else if(event.getSource() == modifyRoomListButton) {
            System.out.println("modifyRoom");
            new SubFrame(new ModifyRoomPanel(controller, hotelTable.getSelectedRow()));
        }
        else if(event.getSource() == modifyDatePriceButton) {
            System.out.println("modifyPrice");
            new SubFrame(new PriceModifierPanel(controller, hotelTable.getSelectedRow()));
        }
        else if(event.getSource() == removeReservationButton) {
            System.out.println("removeReservation");
            new SubFrame(new ReservationDeletePanel(controller, hotelTable.getSelectedRow()));
        }
    }       

    /**
     * Implementation for update base price functionality
     */
    private void confirmUpdateButtonFunction(double newPrice) {

        if(newPrice < 100) {
            JOptionPane.showMessageDialog(null, "New rate cannot be less than 100.");
        }
        else {
            controller.updateBaseRate(controller.getHotel(hotelTable.getSelectedRow()), newPrice);
            basePriceHeading.setText(String.format("Hotel Base Rate: %.2f",
                                            this.controller.getHotel(hotelTable.getSelectedRow())
                                            .getBaseRate()));
        }
    }

    /**
     * Implementation for rename hotel functionality
     */
    private void confirmRenameButtonFunction() {
        String confirmationString = String.format("Rename [%s] to [%s]?",
                                                controller.getHotel(hotelTable.getSelectedRow()).getName(),
                                                newNameField.getText());
        
        int confirmation = JOptionPane.showConfirmDialog(null,
                                        confirmationString,
                                        "Confirm Hotel Rename",
                                        JOptionPane.YES_NO_OPTION);

        if(confirmation == JOptionPane.NO_OPTION) {
            return;
        }

        if(controller.renameHotel(controller.getHotel(hotelTable.getSelectedRow()), newNameField.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Invalid Name!");
        }
        refreshPanel();
    }
    
    /**
     * Implementation for delete hotel functionality
     */
    private void deleteButtonFunction() {
        int confirmation = JOptionPane.showConfirmDialog(null,
                                        String.format("Delete Hotel: [%s]?", controller.getHotel(hotelTable.getSelectedRow()).getName()),
                                        "Confirm Hotel Deletion",
                                        JOptionPane.YES_NO_OPTION);

        if(confirmation == JOptionPane.OK_OPTION) {
            if(controller.deleteHotel(controller.getHotel(hotelTable.getSelectedRow())) == false) {
                JOptionPane.showMessageDialog(null, "Hotel cannot be deleted!");
            } else {
                JOptionPane.showMessageDialog(null, "Hotel successfully deleted!");                
            }
            refreshPanel();
        }
    }

    @Override
    public String getName() {
        return "Manage Hotel";
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
}
