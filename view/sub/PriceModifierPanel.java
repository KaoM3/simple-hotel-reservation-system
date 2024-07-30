package view.sub;

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

import controller.HotelReservationSystemController;

public class PriceModifierPanel extends JPanel implements ActionListener {
    private HotelReservationSystemController controller;
    private int index;
    private JLabel headerLabel;
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
        headerLabel = new JLabel();

        setLayout(null);
        
        // Display Data for price modifier
        DefaultTableModel tableModel = new DefaultTableModel();
        String[] headers = {"Date", "Price Multiplier"};
        tableModel.setColumnIdentifiers(headers);
        
        priceTable.setModel(tableModel);
        priceTable.setEnabled(true);
        priceTable.setCellSelectionEnabled(true);

        for(int i = 1; i <= 31; i++) {
            tableModel.addRow(new String[] {Integer.toString(i), Double.toString(controller.getHotel(index).getReservationManager().getPriceModifier().getMultiplier(i))});

        }
        
        priceScrollPane.setViewportView(priceTable);

        add(priceScrollPane);
        priceScrollPane.setBounds(20, 60, 360, 350);

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
        
        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText(String.format("Editing Date Price: [%s]", controller.getHotel(index).getName()));
        add(headerLabel);
        headerLabel.setBounds(20, 20, 360, 30);
    }

    /** Updates the hashmap */
    private void updateModelPrice() {
        // Changes below an error wont apply to proper edits below
        for(int i = 0; i < 31; i++) {
            try {
                double newPrice = Double.valueOf(priceTable.getModel().getValueAt(i, 1).toString());
                if(!controller.updateDatePrice(controller.getHotel(index), i + 1, newPrice)) {
                    String failString = String.format("Update Failed: Double should be positive [Date %d]", i + 1); 
                    JOptionPane.showMessageDialog(null, failString);
                }
            } catch (NumberFormatException error) {
                System.out.println(error);
                String failString = String.format("Update Failed: Invalid double [Date %d]", i + 1);
                JOptionPane.showMessageDialog(null, failString);
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
            updateModelPrice();
            refreshPanel();
        }
        else if(event.getSource() == resetPriceButton) {
            System.out.println("reset price");
            if(JOptionPane.showConfirmDialog(priceScrollPane, "Reset all multipliers to 1.0?", "Reset Multipliers", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                resetModelPrice();
            }
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
