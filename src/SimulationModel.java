import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class  SimulationModel extends JPanel implements Observer {

    Particle[] particles;

    private int numberOfParticles;
    private Timer timer;

    SimulationModel() {
        this.numberOfParticles = 100;
        particles = new Particle[100];
        timer = new Timer();
    }

    SimulationModel(int numberOfParticles) {
        this.numberOfParticles = numberOfParticles;
        particles = new Particle[this.numberOfParticles];
        timer = new Timer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < particles.length; i++) {
            Particle p = new Particle();
            p.draw(g);
            particles[i] = p;
        }
        this.startTimer();
    }

    private void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Particle p : particles) {
                    p.move();
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }, 0, 1000);
    }

    @Override
    public void update(Observable o, Object arg) {

    }



}
