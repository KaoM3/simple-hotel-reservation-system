package view;

import javax.swing.*;
import java.awt.event.*;

public class Mainframe implements ActionListener{
    JFrame frame;
    JButton add, remove, manage;
    JTextArea textArea;
    JScrollPane scrollPane;

    public Mainframe() {
        frame = new JFrame("Mainframe");
        add = new JButton("Add");
        remove = new JButton("remove");
        manage = new JButton("manage");
        textArea = new JTextArea("TEXT AREA");
        scrollPane = new JScrollPane(textArea);

        add.addActionListener(this);
        remove.addActionListener(this);
        manage.addActionListener(this);

        // Set Element Bounds
        add.setBounds(10, 10, 100, 100);
        remove.setBounds(10, 110, 100, 500);
        manage.setBounds(10, 610, 100, 100);

        // Configure JScrollPane
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(120, 10, 200, 200);

        // Add Elements to Frame
        frame.add(add);
        frame.add(remove);
        frame.add(manage);
        frame.add(scrollPane);

        // Display Frame
        frame.setLayout(null);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        
        if(event.getSource() == add) {
            System.out.printf("Add Button");
            scrollPane.setViewportView(new JTextArea("NEW AREA!"));
        }
        if(event.getSource() == remove) {
            System.out.printf("Remove Button");
        }
        if(event.getSource() == manage) {
            System.out.printf("Manage Button");
        }
    }
}
