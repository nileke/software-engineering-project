import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;

public class  SimulationModel extends JPanel implements Observer {
    Particle[] particles;
    private int numberOfParticles;
    int seconds = 0;
    TimerTask task;
    Timer timer;
    int xdim;
    int ydim;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle p:particles) {
            p.draw(g);
        }
        this.startTimer();
    }


    SimulationModel()  {
        this.numberOfParticles = 1000;
        particles = new Particle[this.numberOfParticles];
        this.createParticles();
        timer = new Timer();

    }

    private void createParticles(){
        for (int i=0; i<this.numberOfParticles; i++) {
            Particle p = new Particle();
            p.setDiameter(5);
            particles[i] = p;
        }
    }

    private void startTimer() {
        xdim = this.getSize().width;
        ydim = this.getSize().height;


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Particle p : particles) {
                    if(!inBounds(p.getXpos(), "X") || !inBounds(p.getYpos(), "Y")){
                        p.setColor(Color.red);
                        p.setMoving(false);
                        p.setDiameter(4);
                    }

                    p.move();


                }
                try {
                    // affects the speed of the animation
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                repaint();


            }
        }, 0, 1000);
    }

    private boolean inBounds(double pos, String type){
        boolean condition;
        int offset = 10;
        if(type=="X"){
             condition = (pos>=offset) && (pos < (xdim-offset));
        }
        else if(type=="Y"){
             condition = (pos>=offset) && (pos < (ydim-offset));
        }
        else{
            condition = false;
        }

        return condition;
    }


    SimulationModel(int numberOfParticles) {
        this.numberOfParticles = numberOfParticles;
    }

    void updateL(ControlPanelModel l){
        for(Particle p:particles){
            p.setL(l.getL());
            p.setColor(l.getColor());

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        ControlPanelModel l = (ControlPanelModel) o;
        this.updateL(l);
        repaint();

    }
}