import java.awt.*;
import java.util.Random;

public class Particle {
    private double xpos, ypos; //position
    private static int numOfParticles;
    private Color color; //color of particle
    private boolean moving;
    private double L = 1; //unknown constant
    private int diameter;


    /**
     * Constructor for a particle with random position
     *
     *
     */
    public Particle() {
        this.moving = true;
        numOfParticles++;
        this.xpos = this.getRandomPos(750); // based on start width
        this.ypos = this.getRandomPos(500); // based on start height
        this.diameter = 4;
        this.color = Color.BLACK;
    }

    /**
     * Constructor for a particle with set position
     *
     *
     */
    public Particle(double xpos, double ypos, boolean moving, Color color){
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

    public void move(){
        Random rand = new Random();
        double maxAngle = 2 * Math.PI;
        double n = rand.nextDouble() * (maxAngle);
        this.xpos = xpos + this.L * Math.cos(n);
        this.ypos = ypos + this.L * Math.sin(n);
    }

    //http://pages.cs.wisc.edu/~bahls/cs302/miniC/Particle.java
    public void draw(Graphics g){
        g.setColor(this.color);
        int radius = this.diameter/2;
        int xPos = (int) (this.xpos - radius);
        int yPos = (int) (this.ypos - radius);
        g.fillOval(xPos, yPos, this.diameter, this.diameter);

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getXpos() {
        return xpos;
    }

    public double getYpos() {
        return ypos;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean m) {
        moving = m;
    }

    public void setDiameter(int n) {
        this.diameter = n;
    }

    public static int getNumOfParticles() {
        return numOfParticles;
    }

}