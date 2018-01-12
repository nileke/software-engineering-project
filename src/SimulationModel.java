
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class  SimulationModel extends JPanel implements Observer {
    Particle[] particles;
   ArrayList<Particle> particleMap;
    private int numberOfParticles;
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
        this.numberOfParticles = 10000;
        particles = new Particle[this.numberOfParticles];
        particleMap = new ArrayList<Particle>();
        this.createParticles();
        this.setSize(850, 450);
        timer = new Timer();

    }

    private void createParticles(){
        for (int i=0; i<this.numberOfParticles; i++) {
            Particle p = new Particle();
            p.setDiameter(3);
            particles[i] = p;

        }
    }

    private void startTimer() {
        xdim = this.getSize().width;
        ydim = this.getSize().height;


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                List<Particle> filteredList = Arrays
                        .stream(particles)
                        .filter(particle -> particle.isMoving()).collect(Collectors.toList());
                for (Particle p : filteredList) {
                    if(!inBounds(p.getXpos(), "X") || !inBounds(p.getYpos(), "Y")){
                        p.setColor(Color.red);
                        p.setMoving(false);
                        p.setDiameter(4);
                        if(!particleMap.contains(p)){
                            particleMap.add(p);
                        }

                    }

                    else if(inCircularRadius(p)){
                        if(!particleMap.contains(p)){
                            particleMap.add(p);
                        }
                        p.setColor(Color.red);
                        p.setMoving(false);
                        p.setDiameter(4);
                    }

                    else if(inParticleRadius(p)){
                        if(!particleMap.contains(p)){
                            particleMap.add(p);
                        }
                        p.setColor(Color.red);
                        p.setMoving(false);
                        p.setDiameter(4);
                    }

                    else{
                        p.move();
                    }


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

    private boolean inCircularRadius(Particle p){
        //circle equation (x - center_x)^2 + (y - center_y)^2 < radius^2
        //we want a circle in the middle, so
        int center_x = 850/2;
        int center_y=450/2;
        int x= (int) p.getXpos();
        int y=(int) p.getYpos();
        int radius = 50;
        double circle = (Math.pow(x-center_x, 2))+(Math.pow(y-center_y,2));
        boolean condition = circle < Math.pow(2*radius, 2) && circle > Math.pow(radius,2);
        return condition;


    }

    private boolean inParticleRadius(Particle p){

        for(Particle c:particleMap){
            double diffx = c.getXpos()-p.getXpos();
            double diffy = c.getYpos()-p.getYpos();

            if(abs(diffx)<2 && abs(diffy)<2){
                return true;
            }
        }
        return false;

    }

    private boolean inBounds(double pos, String type){
        boolean condition;
        int offset = 10;
        if(type=="X"){
             condition = (pos>=offset) && (pos < (850-offset));
        }
        else if(type=="Y"){
             condition = (pos>=offset) && (pos < (450-offset));
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
            p.setDiameter(l.getDiameter());

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        ControlPanelModel l = (ControlPanelModel) o;
        this.updateL(l);
        repaint();


    }
}