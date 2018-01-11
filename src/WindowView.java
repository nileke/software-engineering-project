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
        simModel = new SimulationModel();
        model =  new ControlPanelModel();
        input =  new ControlPanelInput(model);
        frame = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        controlPanel = new JPanel(new BorderLayout());
        this.guiSetup();
    }

    void guiSetup(){
        frame.setVisible(true);
        mainPanel.add(new TextField("Simulation"));
        controlPanel.add(input);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

    }
}
