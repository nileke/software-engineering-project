import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class  SimulationModel extends JPanel implements Observer {

    private Particle[] particles;
    private int numberOfParticles;
    private int xdim;
    private int ydim;
    private Timer timer;

    SimulationModel(int numberOfParticles) {
        this.numberOfParticles = numberOfParticles;
        particles = new Particle[this.numberOfParticles];
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
                        p.setMoving(false);
                        p.setColor(Color.red);
                    }
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

    @Override
    public void update(Observable o, Object arg) {

    }



}
