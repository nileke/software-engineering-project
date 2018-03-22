import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Particle {
    private double xpos, ypos; //position
    private static int numOfParticles;
    private Color color; //color of particle
    private boolean moving;
    private double L = 1; //unknown constant
    private int diameter;
    private int idx;
    private ArrayList positions;


    /**
     * Constructor for a particle with random position
     *
     *
     */
    Particle(int idx) {
        this.idx = idx;
        this.moving = true;
        numOfParticles++;
        this.xpos = this.getRandomPos(750); // based on start width
        this.ypos = this.getRandomPos(500); // based on start height
        this.diameter = 4;
        this.color = Color.BLACK;
        positions = new ArrayList();
    }

    /**
     * Constructor for a particle with set position
     *
     *
     */
    Particle(double xpos, double ypos, boolean moving, Color color){
        numOfParticles++;
        this.xpos = xpos;
        this.ypos = ypos;
        this.moving=true;
    }

    private double getRandomPos(int s){
        Random seed = new Random();
        // random index
        return seed.nextDouble() * s;
    }

    void move(){
        Random rand = new Random();
        double maxAngle = 2 * Math.PI;
        double n = rand.nextDouble() * (maxAngle);
        this.xpos = xpos + this.L * Math.cos(n);
        this.ypos = ypos + this.L * Math.sin(n);
    }

    //http://pages.cs.wisc.edu/~bahls/cs302/miniC/Particle.java
    void draw(Graphics g){
        g.setColor(this.color);
        int radius = this.diameter/2;
        int xPos = (int) (this.xpos - radius);
        int yPos = (int) (this.ypos - radius);
        g.fillOval(xPos, yPos, this.diameter, this.diameter);

    }

    void setColor(Color color) {
        this.color = color;
    }

    double getXpos() {
        return xpos;
    }

    double getYpos() {
        return ypos;
    }

    boolean isMoving() {
        return moving;
    }

    void setMoving(boolean m) {
        moving = m;
    }

    void setDiameter(int n) {
        this.diameter = n;
    }

    static int getNumOfParticles() {
        return numOfParticles;
    }

}