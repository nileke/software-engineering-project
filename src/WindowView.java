import javax.swing.*;
import java.awt.*;

public class WindowView extends JFrame{

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel controlPanel;
    private ControlPanelModel model;
    private ControlPanelInput input;
    private SimulationModel simModel;

    public WindowView(SimulationModel simModel){
        this.simModel = simModel;
        model =  new ControlPanelModel();
        input =  new ControlPanelInput(model);
        frame = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        controlPanel = new JPanel(new BorderLayout());
        this.guiSetup();
    }

    void guiSetup(){
        frame.setVisible(true);
        mainPanel.add(simModel);
        controlPanel.add(input);

        model.addObserver(simModel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,500);
        frame.setResizable(false);
    }
}
