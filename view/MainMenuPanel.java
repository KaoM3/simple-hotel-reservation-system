package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.*;

public class MainMenuPanel extends JPanel implements ActionListener {
    private JButton addHotel, removeHotel, manageHotel;
    private JPanel hotelListPanel;
    private JScrollPane hotelListScroller;
    private static int LEFTMARGIN = 20;
    private static int BUTTONWIDTH = 360;
    private static int BUTTONHEIGHT = 60;

    /**
     * Constructor for class MainMenuPanel
     * Will automatically set the configurations for this panel
     * @param list is the list to be displayed
     */
    public MainMenuPanel(HotelReservationSystemController controller, List<String> list) {
        this.setName("Hotel Reservation System Main Menu");
        this.setLayout(null);
        this.setVisible(true);
        this.setList(list);
        this.setButtons();
    }

    public void setList(List<String> list) {
        hotelListPanel = new JPanel();
        hotelListPanel.setVisible(true);
        hotelListPanel.setLayout(new GridLayout(list.size()/2, 2));

        for(String string : list) {
            JLabel label = new JLabel(string);
            hotelListPanel.add(label);
        }

        hotelListScroller = new JScrollPane(hotelListPanel);
        hotelListScroller.setBounds(LEFTMARGIN, 30, 360, 200);
        hotelListScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(hotelListScroller);
    }

    private void setButtons() {
        addHotel = new JButton("Add Hotel");
        removeHotel = new JButton("Remove Hotel");
        manageHotel = new JButton("Manage Hotel");

        addHotel.setBounds(LEFTMARGIN, 250, BUTTONWIDTH, BUTTONHEIGHT);
        removeHotel.setBounds(LEFTMARGIN, 330, BUTTONWIDTH, BUTTONHEIGHT);
        manageHotel.setBounds(LEFTMARGIN, 410, BUTTONWIDTH, BUTTONHEIGHT);

        this.add(addHotel);
        this.add(removeHotel);
        this.add(manageHotel);

        addHotel.addActionListener(this);
        removeHotel.addActionListener(this);
        manageHotel.addActionListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 500);
    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == addHotel) {
            System.out.println("Add hotel button");
        }
        else if(event.getSource() == removeHotel) {
            System.out.println("Remove hotel button");
        }
        else if(event.getSource() == manageHotel) {
            System.out.println("Manage hotel button");
        }
    }
}
