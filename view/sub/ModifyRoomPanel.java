package view.sub;

import controller.HotelReservationSystemController;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import model.hotel.room.Room;


public class ModifyRoomPanel extends JPanel implements ActionListener, ItemListener, ListSelectionListener {
    private final HotelReservationSystemController controller;

    private final int index;

    private int roomTypeInput;

    private JButton refreshButton;
    private JButton createButton;
    private JButton deleteButton;

    private JScrollPane listScrollPane;

    private JLabel headerLabel;
    private JLabel roomNameLabel;
    private JLabel roomTypeLabel;
    private JLabel selectedRoomLabel;

    private JTextField roomNameTextField;

    private JTable roomTable;

    private JComboBox<String> roomTypeDropDown;

    public ModifyRoomPanel(HotelReservationSystemController controller, int index) {
        this.controller = controller;
        this.index = index;
        controller.getHotelObjects().get(index);
        initComponents();
    }

    private void initComponents() {

        listScrollPane = new JScrollPane();
        roomTable = new JTable();
        headerLabel = new JLabel();
        refreshButton = new JButton();
        createButton = new JButton();
        roomNameTextField = new JTextField();
        roomNameLabel = new JLabel();
        roomTypeLabel = new JLabel();
        roomTypeDropDown = new JComboBox<>();
        deleteButton = new JButton();
        selectedRoomLabel = new JLabel();
        roomTypeInput = 1;

        setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        setLayout(null);

        // Set Up Table
        DefaultTableModel tableModel = new DefaultTableModel(0, 4);
        String tableHeader[] = {"Room Name", "Room Type", "Price per Night", "No. of Reservations"};
        tableModel.setColumnIdentifiers(tableHeader);
        
        roomTable.setModel(tableModel);
        roomTable.setEnabled(true);

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

        ListSelectionModel selectionModel = roomTable.getSelectionModel();

        selectionModel.addListSelectionListener(this);
        
        listScrollPane.setViewportView(roomTable);

        add(listScrollPane);
        listScrollPane.setBounds(20, 60, 560, 250);

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText(String.format("Editing Room List: [%s]", controller.getHotel(index).getName()));
        add(headerLabel);
        headerLabel.setBounds(20, 20, 560, 30);

        refreshButton.setText("Refresh Table Data");
        refreshButton.addActionListener(this);
        add(refreshButton);
        refreshButton.setBounds(350, 420, 210, 23);

        createButton.setText("Confirm Room Creation");
        createButton.addActionListener(this);
        add(createButton);
        createButton.setBounds(110, 420, 200, 23);

        roomNameTextField.setText("Enter Room Name");
        add(roomNameTextField);
        roomNameTextField.setBounds(110, 340, 200, 30);

        roomNameLabel.setText("Room Name:");
        add(roomNameLabel);
        roomNameLabel.setBounds(20, 340, 80, 20);

        roomTypeLabel.setText("Room Type:");
        add(roomTypeLabel);
        roomTypeLabel.setBounds(20, 380, 70, 16);
        
        // Setup Drop Box (JComboBox)
        String roomTypes[] = {"Standard", "Deluxe", "Executive"};
        DefaultComboBoxModel<String> roomTypeModel = new DefaultComboBoxModel<>(roomTypes);
        roomTypeDropDown.setModel(roomTypeModel);
        roomTypeDropDown.addItemListener(this);
        add(roomTypeDropDown);
        roomTypeDropDown.setBounds(110, 380, 200, 22);

        deleteButton.setText("Delete Selected Room");
        deleteButton.addActionListener(this);
        add(deleteButton);
        deleteButton.setBounds(350, 380, 210, 23);

        selectedRoomLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        selectedRoomLabel.setText("No Selected Room");
        add(selectedRoomLabel);
        selectedRoomLabel.setBounds(340, 340, 240, 20);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
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
    public void valueChanged(ListSelectionEvent event) {
        // TODO Auto-generated method stub
        if(event.getValueIsAdjusting()) {
            return;
        }

        String selectedRoom = controller.getHotel(index).getRoomByIndex(roomTable.getSelectedRow()).getName();
        selectedRoomLabel.setText(String.format("Selected Room: %s", selectedRoom));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == refreshButton) {
            refreshPanel();
        }
        else if(event.getSource() == createButton) {
            System.out.println(roomNameTextField.getText());
            if(!(roomNameTextField.getText().length() == 0)) {
                controller.createNewRoom(controller.getHotel(index).getName(),
                                            roomNameTextField.getText(),
                                            roomTypeInput);
            }
            refreshPanel();
        }
        else if(event.getSource() == deleteButton) {
            if(controller.getHotel(index).getRoomList().size() == 1) {
                JOptionPane.showMessageDialog(null, "Hotel needs at least 1 room!");
            }
            else if(roomTable.getSelectedRow() != -1) {
                deleteButtonFunction();
            } else {
                JOptionPane.showMessageDialog(null, "No Room Selected!");
            }
        }
    }

    /**
     * Implementation for room deletion
     */
    private void deleteButtonFunction() {
        String confirmationString = String.format("Delete room: [%s]?", controller.getHotel(index).getRoomByIndex(roomTable.getSelectedRow()).getName());
        int confirmation = JOptionPane.showConfirmDialog(null,
                                                        confirmationString,
                                                        "Confirm Room Deletion",
                                                        JOptionPane.YES_NO_OPTION);

        if(confirmation == JOptionPane.YES_OPTION) {
            if(controller.deleteRoom(controller.getHotel(index), roomTable.getSelectedRow())) {
                refreshPanel();
            }
            else {
                JOptionPane.showMessageDialog(null, "Deletion failed!");
            }
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
        return "Hotel Room List";
    }
}