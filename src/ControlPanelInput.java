import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanelInput extends JPanel implements ActionListener {
    private ControlPanelModel mod;
    private GroupLayout layout;
    private JButton colorBlackBtn;
    private JButton colorBlueBtn;
    private JButton colorGreenBtn;
    private JButton speed1;
    private JButton speed2;
    private JButton speed3;

    public ControlPanelInput(ControlPanelModel m){
        mod = m;

        layout = new GroupLayout(this);
        this.setLayout(layout);
        setupColorControls();
        setupSpeedControls();
        setupGui();

    }

    private void setupGui() {
        // Set auto gaps
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Set the button groups and alignment horizontally and vertically
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(colorBlackBtn)
                        .addComponent(speed1))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(colorBlueBtn)
                        .addComponent(speed2))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(colorGreenBtn)
                        .addComponent(speed3))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(colorBlackBtn)
                        .addComponent(colorBlueBtn)
                        .addComponent(colorGreenBtn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(speed1)
                        .addComponent(speed2)
                        .addComponent(speed3))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, colorBlackBtn, colorBlueBtn, colorGreenBtn, speed1, speed2, speed3);
    }

    private void setupColorControls() {
        colorBlackBtn = new JButton("Black");
        colorBlackBtn.addActionListener(e -> mod.setColor(Color.BLACK));


        colorBlueBtn = new JButton("Blue");
        colorBlueBtn.addActionListener(e -> mod.setColor(Color.BLUE));

        colorGreenBtn = new JButton("Green");
        colorGreenBtn.addActionListener(e -> mod.setColor(Color.GREEN));

    }

    private void setupSpeedControls() {
        speed1 = new JButton("1x");
        speed1.addActionListener(e -> mod.setUpdateFreq(40));

        speed2 = new JButton("0.5x");
        speed2.addActionListener(e -> mod.setUpdateFreq(80));

        speed3 = new JButton("0.1x");
        speed3.addActionListener(e -> mod.setUpdateFreq(400));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // notify();
    }
}
