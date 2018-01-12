import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanelInput extends JPanel implements ActionListener {
    ControlPanelModel mod;
    GroupLayout layout;

    public ControlPanelInput(ControlPanelModel m){
        mod = m;
        //layout = new GroupLayout(this);
        //this.setLayout(layout);
        //layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);
        setupColorControls();
        setupSpeedControls();
    }

    private void setupColorControls() {
        JButton colorBlackBtn = new JButton("Black");
        colorBlackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.setColor(Color.BLACK);
            }
        });


        JButton colorBlueBtn = new JButton("Blue");
        colorBlueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.setColor(Color.BLUE);
            }
        });

        JButton colorGreenBtn = new JButton("Green");
        colorGreenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.setColor(Color.GREEN);
            }
        });

        this.add(colorBlackBtn);
        this.add(colorBlueBtn);
        this.add(colorGreenBtn);
    }

    void setupSpeedControls() {
        JButton speed1 = new JButton("1x");
        speed1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.setUpdateFreq(40);
            }
        });

        JButton speed2 = new JButton("0.5x");
        speed2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.setUpdateFreq(80);
            }
        });

        JButton speed3 = new JButton("0.1x");
        speed3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.setUpdateFreq(400);
            }
        });

        this.add(speed1);
        this.add(speed2);
        this.add(speed3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
