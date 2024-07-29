package view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;
import view.sub.PriceModifierPanel;
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

    public ManagePanel(HotelReservationSystemController controller) {
        this.controller = controller;
        initComponents();
    }
                      
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

        confirmUpdateButton.addActionListener(this);
        add(confirmUpdateButton);
        confirmUpdateButton.setBounds(370, 260, 170, 20);

        add(newNameField);
        newNameField.setBounds(370, 90, 170, 30);

        basePriceHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        basePriceHeading.setText("No Selected Hotel.");
        add(basePriceHeading);
        basePriceHeading.setBounds(260, 190, 280, 20);

        renameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        renameLabel.setText("Rename Hotel:");
        add(renameLabel);
        renameLabel.setBounds(260, 90, 100, 30);

        confirmUpdateLabel.setText("Confirm Update:");
        add(confirmUpdateLabel);
        confirmUpdateLabel.setBounds(260, 260, 100, 16);

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

        add(hotelTablePane);
        hotelTablePane.setBounds(20, 30, 220, 290);

        deleteButton.addActionListener(this);
        add(deleteButton);
        deleteButton.setBounds(260, 300, 280, 20);

        modifyRoomListButton.addActionListener(this);
        add(modifyRoomListButton);
        modifyRoomListButton.setBounds(380, 350, 160, 90);

        removeReservationButton.addActionListener(this);
        add(removeReservationButton);
        removeReservationButton.setBounds(20, 350, 160, 90);

        modifyDatePriceButton.addActionListener(this);
        add(modifyDatePriceButton);
        modifyDatePriceButton.setBounds(200, 350, 160, 90);

        hotelHeading.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hotelHeading.setText("No Selected Hotel");
        add(hotelHeading);
        hotelHeading.setBounds(260, 40, 280, 20);

        updateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateLabel.setText("Update Rate:");
        add(updateLabel);
        updateLabel.setBounds(260, 220, 100, 30);

        add(newPriceField);
        newPriceField.setBounds(370, 220, 170, 30);

        confirmRenameLabel.setText("Confirm Rename:");
        add(confirmRenameLabel);
        confirmRenameLabel.setBounds(260, 130, 100, 16);

        confirmRenameButton.addActionListener(this);
        add(confirmRenameButton);
        confirmRenameButton.setBounds(370, 130, 170, 20);
    }                  

    public void handleSelection(ListSelectionEvent event) {
        // TODO: Add Implementation
        hotelHeading.setText(String.format("Selected Hotel: %s",
                                            this.controller.getHotel(hotelTable.getSelectedRow()).getName()));
        
        basePriceHeading.setText(String.format("Hotel Base Rate: %.2f",
                                                this.controller.getHotel(hotelTable.getSelectedRow())
                                                .getBaseRate()));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == confirmUpdateButton) {
            // TODO: Add implementation
            System.out.println("OK 1");
        }
        else if(event.getSource() == confirmRenameButton) {
            // TODO: Add implementation
            System.out.println("OK 2");
            
        }
        else if(event.getSource() == deleteButton) {
            // TODO: Add implementation
            System.out.println("delete");
            
        }
        else if(event.getSource() == modifyRoomListButton) {
            // TODO: Add implementation
            System.out.println("modifyRoom");
            
        }
        else if(event.getSource() == modifyDatePriceButton) {
            // TODO: Add implementation
            System.out.println("modifyPrice");
            if(hotelTable.getSelectedRow() != -1) {
                new SubFrame(new PriceModifierPanel(controller, hotelTable.getSelectedRow()));
            }
            
        }
        else if(event.getSource() == removeReservationButton) {
            // TODO: Add implementation
            System.out.println("removeReservation");
            
        }
    }       
    
    @Override
    public String getName() {
        return "Manage Hotel";
    }
}
