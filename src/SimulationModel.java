import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;


public class  SimulationModel2 extends JPanel implements Observer, ComponentListener {

    private Particle[] particles;
    private int numberOfParticles;
    private int xdim;
    private int ydim;
    private Timer timer;
    private int updateFreq;
    private Color movingColor;

    SimulationModel2(int numberOfParticles) {
        xdim = this.getSize().width;
        ydim = this.getSize().height;
        movingColor = Color.BLACK;
        this.numberOfParticles = numberOfParticles;
        particles = new Particle[this.numberOfParticles];
        updateFreq = 40;
        createParticles();
        timer = new Timer();
    }

    private void createParticles() {
        for (int i = 0; i < numberOfParticles; i++) {
            Particle p = new Particle();
            particles[i] = p;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p : particles) {
            p.draw(g);
        }
        this.startTimer();
    }

    private void startTimer() {
        xdim = this.getSize().width;
        ydim = this.getSize().height;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Particle p : particles) {
                    if (!inBounds(p.getXpos(), p.getYpos())) {
                        p.setColor(Color.red);
                        continue;
                    } else {
                        p.setColor(movingColor);
                    }
                    p.move();
                }

                try {
                    Thread.sleep(updateFreq);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }

        }, 0, 1000);
    }

    private boolean inBounds(double x, double y) {
        boolean condition = true;

        if (x < 2 || x >= xdim-2) {
            condition = false;
        }
        else if (y < 2 || y >= ydim-2) {
            condition = false;
        }

        return condition;
    }

    void implementUpdate(ControlPanelModel cpm) {
        movingColor = cpm.getColor();
        updateFreq = cpm.getUpdateFreq();
    }


    @Override
    public void update(Observable o, Object arg) {
        ControlPanelModel cpm = (ControlPanelModel) o;
        this.implementUpdate(cpm);
        //repaint();
    }


    @Override
    public void componentResized(ComponentEvent e) {
        xdim = this.getSize().width;
        ydim = this.getSize().height;
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}