import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

class Listener implements ActionListener {

    JButton button1, button2;
    JPanel panel;
    JLabel label;
    boolean visible = false;
    Listener(JButton button1, JButton button2, JPanel panel, JLabel label){
        this.button1 = button1;
        this.button2 = button2;
        this.panel = panel;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        visible = !visible;
        panel.setVisible(visible);
    }
}

