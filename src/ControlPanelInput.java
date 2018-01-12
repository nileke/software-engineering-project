import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanelInput extends JPanel implements ActionListener {
    ControlPanelModel mod;

    public ControlPanelInput(ControlPanelModel m){
        mod = m;
        this.add(new TextField("controlpanel"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
