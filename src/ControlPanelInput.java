import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanelInput extends JPanel implements ActionListener {
    ControlPanelModel mod;

    public ControlPanelInput(ControlPanelModel m){
        mod = m;
        this.add(new TextField("controlpanel"));
        JButton b = new JButton("test");
        this.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.setL(10);
                m.setColor(Color.magenta);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
