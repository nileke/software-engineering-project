import java.awt.*;
import java.util.Random;

public class Particle {
    private double xpos, ypos; //position
    private static int numOfParticles;
    private Color color; //color of particle
    private boolean moving;
    private final double L = 1; //unknown constant
    private int diameter;


    /**
     * Constructor for a particle with random position
     *
     *
     */
    public Particle() {
        this.moving = true;
        numOfParticles++;
        this.xpos = this.getRandomPos();
        this.ypos = this.getRandomPos();
        this.diameter = 4;
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

    private double getRandomPos(){
        Random seed = new Random();
        // random index
        return seed.nextDouble() * 1500;
    }

    public void move(){
        Random rand = new Random();
        double maxAngle = 2 * Math.PI;
        double  n = rand.nextDouble() * (maxAngle);
        this.xpos = xpos + this.L * Math.cos(n);
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

    public static int getNumOfParticles() {
        return numOfParticles;
    }


}
