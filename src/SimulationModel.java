import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class  SimulationModel extends JPanel implements Observer {

    Particle[] particles;

    private int numberOfParticles;
    int seconds = 0;
    TimerTask task;
    Timer timer;

    SimulationModel()  {
        this.numberOfParticles = 100;
        particles = new Particle[100];
        timer = new Timer();
        for (int i=0; i<100; i++) {
            Particle p = new Particle();
            Graphics g = getGraphics();
            p.draw(g);
            particles[i] = p;
        }
        this.startTimer();
    }

    private void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Your database code here
                for (Particle p : particles) {
                    p.move();
                }
                repaint();
            }
        }, 0, 33);
    }

    SimulationModel(int numberOfParticles) {
        this.numberOfParticles = numberOfParticles;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
