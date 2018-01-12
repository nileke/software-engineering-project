import java.awt.*;
import java.util.Random;

public class Particle{
    private double xpos, ypos; //position
    private static int numOfParticles;
    private Color color; //color of particle
    private boolean moving;
    private double L; //unknown constant
    private int diameter;
    private int dimx,dimy;


    /**
     * Constructor for a particle with random position
     *
     *
     */
    public Particle() {
        this.moving = true;
        this.numOfParticles++;
        this.xpos = this.getRandomPos(800);
        this.ypos = this.getRandomPos(400);
        this.diameter = 1;
        this.color = Color.BLACK;
        this.L = 2;
    }

    public void setL(double l) {
        L = l;
    }

    /**
     * Constructor for a particle with set position
     *
     *
     */
    public Particle(double xpos, double ypos, boolean moving, Color color){
        this.numOfParticles++;
        this.xpos = xpos;
        this.ypos = ypos;
        this.moving=true;
        this.L = 1000;
    }

    private double getRandomPos(int s){
        Random seed = new Random();
        // random index
        return (seed.nextDouble()*s)+25;
    }

    public void move(){
        Random rand = new Random();
        double maxAngle = 2 * Math.PI;
        double n = rand.nextDouble() * (maxAngle);
        xpos = xpos + L * Math.cos(n);
        ypos = ypos + L * Math.sin(n);


    }


    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    //http://pages.cs.wisc.edu/~bahls/cs302/miniC/Particle.java
    public void draw(Graphics g){
        g.setColor(this.color);
        double radius = this.diameter/2;
        int xPos = (int) (this.xpos - radius);
        int yPos = (int) (this.ypos-radius);
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

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public boolean isMoving() {
        return moving;
    }

    public static int getNumOfParticles() {
        return numOfParticles;
    }


    public void setDimx(int dimx) {
        this.dimx = dimx;
    }

    public void setDimy(int dimy) {
        this.dimy = dimy;
    }
}
