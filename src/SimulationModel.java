import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.*;
import java.util.Timer;
import java.util.stream.Collectors;

import static java.lang.Math.abs;


public class  SimulationModel extends JPanel implements Observer, ComponentListener {
    private int numberOfParticles;
    private Particle[] particles;
    ArrayList<Particle> particleMap;
    ArrayList<Particle> movingParticles;
    ArrayList<Particle> nonMovingParticles;
    private int xdim;
    private int ydim;
    private Timer timer;
    private int updateFreq;
    private Color movingColor;

    SimulationModel(int numberOfParticles) {
        xdim = this.getSize().width;
        ydim = this.getSize().height;
        movingColor = Color.BLACK;
        particleMap = new ArrayList<>();
        movingParticles = new ArrayList<>();
        nonMovingParticles = new ArrayList<>();
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
            movingParticles.add(p);
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
                /*java.util.List<Particle> filteredList = Arrays
                        .stream(particles)
                        .filter(particle -> particle.isMoving()).collect(Collectors.toList());*/
                for (Particle p : movingParticles) {
                    if(!inBounds(p.getXpos(), p.getYpos())){
                        p.setColor(Color.red);
                        p.setMoving(false);
                        nonMovingParticles.add(p);
                        //p.setDiameter(4);
                        if(!particleMap.contains(p)){
                            particleMap.add(p);
                        }

                    }

                    else if(inCircularRadius(p)){
                        if(!particleMap.contains(p)){
                            particleMap.add(p);
                        }
                        nonMovingParticles.add(p);

                        p.setColor(Color.red);
                        p.setMoving(false);
                        p.setDiameter(4);
                    }

                    else if(inParticleRadius(p)){
                        if(!particleMap.contains(p)){
                            particleMap.add(p);
                        }
                        nonMovingParticles.add(p);
                        p.setColor(Color.red);
                        p.setMoving(false);
                        //p.setDiameter(4);
                    }

                    else{
                        p.setColor(movingColor);
                        p.move();
                    }

                }
                movingParticles.removeAll(nonMovingParticles);
                try {
                    // affects the speed of the animation
                    Thread.sleep(updateFreq);
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

            if(abs(diffx)<4 && abs(diffy)<4){
                return true;
            }
        }
        return false;

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

    private void implementUpdate(ControlPanelModel cpm) {
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