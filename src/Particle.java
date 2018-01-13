import java.awt.*;
import java.util.Random;

public class Particle {
    private double xpos, ypos; //position
    private static int numOfParticles;
    private Color color; //color of particle
    private boolean moving;

    private double L = 1; //unknown constant
    private int diameter;
    private int dimx,dimy;


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

    public void setDiameter(int diameter) {
        this.diameter = diameter;
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


    public void setDimx(int dimx) {
        this.dimx = dimx;
    }

    public void setDimy(int dimy) {
        this.dimy = dimy;
    }
}
