package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
    
    public void actionPerformed(ActionEvent event) {
        event.getSource().notify();
    }

}
