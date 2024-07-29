package view.sub;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.HotelReservationSystemController;

public class PriceModifierPanel extends JPanel implements ActionListener {
    private HotelReservationSystemController controller;
    private int index;
    private JButton applyChangesButton;
    private JButton refreshTableButton;
    private JButton resetPriceButton;
    private JScrollPane priceScrollPane;
    private JTable priceTable;


    /**
    * Creates new form PriceModifierPanel
    */
    public PriceModifierPanel(HotelReservationSystemController controller, int index) {
        this.index = index;
        this.controller = controller;
        initComponents();
    }
                
    private void initComponents() {

        priceScrollPane = new JScrollPane();
        priceTable = new JTable();
        applyChangesButton = new JButton();
        refreshTableButton = new JButton();
        resetPriceButton = new JButton();

        setLayout(null);

        // TODO: Add Display Data for Price Modifier
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] headers = {"Date", "Price Multiplier"};
        tableModel.setColumnIdentifiers(headers);
        
        priceTable.setModel(tableModel);
        priceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        priceTable.setEnabled(true);
        priceTable.setCellSelectionEnabled(true);

        
        for(int i = 1; i <= 31; i++) {
            tableModel.addRow(new Object[] {i, controller.getHotel(index).getReservationManager().getPriceModifier().getMultiplier(i)});

        }

        ListSelectionModel tableSelectionModel = priceTable.getSelectionModel();

        tableSelectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                handleSelection(event);
            }
        });

        priceScrollPane.setViewportView(priceTable);

        add(priceScrollPane);
        priceScrollPane.setBounds(20, 20, 360, 390);

        applyChangesButton.setText("Apply Changes");
        applyChangesButton.addActionListener(this);
        add(applyChangesButton);
        applyChangesButton.setBounds(20, 430, 160, 23);
        
        refreshTableButton.setText("Refresh");
        refreshTableButton.addActionListener(this);
        add(refreshTableButton);
        refreshTableButton.setBounds(290, 430, 90, 23);
        
        resetPriceButton.setText("Reset");
        resetPriceButton.addActionListener(this);
        add(resetPriceButton);
        resetPriceButton.setBounds(190, 430, 90, 23);
    }                                 

    public void handleSelection(ListSelectionEvent event) {

    }

    /** Updates the hashmap */
    private void updateModelPrice() {
        // Changes below an error wont apply to proper edits below
        for(int i = 0; i < 31; i++) {
            System.out.println(priceTable.getModel().getValueAt(i, 1));
            try {
                controller.updateDatePrice(controller.getHotel(index),
                                            i + 1,
                                            Double.valueOf((String)priceTable.getModel().getValueAt(i, 1)));
            } catch (Exception e) {
                controller.updateDatePrice(controller.getHotel(index),
                                            i + 1,
                                            (double)priceTable.getModel().getValueAt(i, 1));
            }
        }
    }

    /** Resets all date modifier to 1 */
    private void resetModelPrice() {
        for(int i = 0; i < 31; i++) {
            controller.updateDatePrice(controller.getHotel(index), i + 1, 1.0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == applyChangesButton) {
            System.out.println("apply");
            // This throws an exception if no value at :(
            updateModelPrice();
        }
        else if(event.getSource() == resetPriceButton) {
            System.out.println("reset price");
            resetModelPrice();
            refreshPanel();
        }
        else if(event.getSource() == refreshTableButton) {
            System.out.println("refresh");
            refreshPanel();
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 480);
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
        return String.format("Edit Hotel Price Modifier");
    }
}
