import javax.swing.*;
import java.awt.*;

public class WindowView extends JFrame{

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel controlPanel;
    private ControlPanelModel ctrlPanelModel;
    private ControlPanelInput input;
    private SimulationModel simModel;

    public WindowView(SimulationModel simModel){
        this.simModel = simModel;
        ctrlPanelModel =  new ControlPanelModel();
        input =  new ControlPanelInput(ctrlPanelModel);
        frame = new JFrame();
        mainPanel = new JPanel(new BorderLayout());
        controlPanel = new JPanel(new BorderLayout());
        this.guiSetup();
    }

    private void guiSetup(){
        frame.setVisible(true);
        mainPanel.add(this.simModel);
        controlPanel.add(input);
        // Add
        ctrlPanelModel.addObserver(simModel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000,500);
        frame.setVisible(true);
    }
}
