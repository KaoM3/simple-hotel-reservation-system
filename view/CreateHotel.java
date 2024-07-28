package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;

/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Rafael
 */
public class CreateHotel extends JPanel implements ActionListener {
    private HotelReservationSystemController controller;
    private JButton cancelButton, confirmButton;
    private JScrollPane hotelListScrollPane;
    private JTable hotelListTable;
    private JLabel hotelNameLabel, roomNameLabel, roomTypeLabel;
    private JTextField hotelNameTextField, roomNameTextField;
    private JComboBox<String> roomTypeDropDown;
    private Integer roomTypeInput = 1;

    /**
     * Creates new form CreateHotel
     */
    public CreateHotel(HotelReservationSystemController controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(570, 480));
        initComponents();
    }

    /**
     *  Initializes the components of this panel 
     */
    private void initComponents() {

        hotelListScrollPane = new JScrollPane();
        hotelListTable = new JTable();
        roomNameTextField = new JTextField();
        hotelNameTextField = new JTextField();
        cancelButton = new JButton();
        confirmButton = new JButton();
        roomNameLabel = new JLabel();
        hotelNameLabel = new JLabel();
        roomTypeDropDown = new JComboBox<>();
        roomTypeLabel = new JLabel();

        setPreferredSize(new Dimension(570, 480));
        setLayout(null);

        // SET UP TABLE
        String hotelListHeader[] = {"Hotel Name"};
        DefaultTableModel hotelListModel = new DefaultTableModel(0, 0);

        hotelListModel.setColumnIdentifiers(hotelListHeader);
        hotelListTable.setModel(hotelListModel);
        hotelListTable.setEnabled(false);
        
        // ADD OBJECT TO TABLE
        for(int i = 0; i < controller.getHotelObjects().size(); i++) {
            hotelListModel.addRow(new Object[] {controller.getHotelObjects().get(i).getName()});
        }

        hotelListScrollPane.setViewportView(hotelListTable);
        if (hotelListTable.getColumnModel().getColumnCount() > 0) {
            hotelListTable.getColumnModel().getColumn(0).setResizable(false);
        }

        hotelListScrollPane.setBounds(20, 20, 520, 250);
        
        // Set up buttons
        roomNameTextField.setText("Enter Room Name");
        roomNameTextField.setBounds(110, 350, 430, 32);
        
        hotelNameTextField.setText("Enter Hotel Name");
        hotelNameTextField.setBounds(110, 300, 430, 32);
        
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this);
        cancelButton.setBounds(440, 410, 100, 23);
        
        confirmButton.setText("Confirm");
        confirmButton.addActionListener(this);
        confirmButton.setBounds(330, 410, 100, 23);
        
        // Set up labels
        roomNameLabel.setText("Room Name:");
        roomNameLabel.setBounds(30, 350, 80, 20);
        hotelNameLabel.setText("Hotel Name:");
        hotelNameLabel.setBounds(30, 300, 80, 20);
        roomTypeLabel.setText("Room Type:");
        roomTypeLabel.setBounds(30, 410, 70, 16);
        
        // Setup Drop Box (JComboBox)
        String roomTypes[] = {"Standard", "Deluxe", "Executive"};
        DefaultComboBoxModel<String> roomTypeModel = new DefaultComboBoxModel<>(roomTypes);
        roomTypeDropDown.setModel(roomTypeModel);
        roomTypeDropDown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                roomTypeDropDownItemStateChanged(event);
            }
        });
        
        roomTypeDropDown.setBounds(110, 410, 200, 22);
        
        // Add components to this panel
        add(hotelListScrollPane);
        add(roomNameTextField);
        add(hotelNameTextField);
        add(cancelButton);
        add(confirmButton);
        add(roomNameLabel);
        add(hotelNameLabel);
        add(roomTypeDropDown);
        add(roomTypeLabel);
    }

    /**
     * Performs actions
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == confirmButton) {
            if(!(roomNameTextField.getText().length() == 0) && !(hotelNameTextField.getText().length() == 0)) {
                this.controller.createNewHotel(hotelNameTextField.getText(), roomNameTextField.getText(), roomTypeInput);
            }
            refreshPanel();
        }
        if(event.getSource() == cancelButton) {
            refreshPanel();
            System.out.println("CancelButton");
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

    private void roomTypeDropDownItemStateChanged(ItemEvent event) {
        if(event.getStateChange() == ItemEvent.SELECTED) {
            switch (roomTypeDropDown.getSelectedIndex()) {
                case 0:
                    this.roomTypeInput = 1;
                    System.out.println("Standard");
                    break;
                case 1:
                    this.roomTypeInput = 2;
                    System.out.println("Deluxe");
                    break;
                case 2:
                    this.roomTypeInput = 3;
                    System.out.println("Executive");
                    break;
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(570, 480);
    }
}
