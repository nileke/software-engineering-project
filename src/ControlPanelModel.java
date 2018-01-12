
import java.awt.*;
import java.util.Observable;

public class ControlPanelModel extends Observable {

    private double l;
    private int diameter;
    private Color color;
    private int xdim;
    private int ydim;
    private int xoffset;
    private int yoffset;

    public int getXdim() {
        return xdim;
    }

    public void setXdim(int xdim) {
        this.xdim = xdim;
        change();
    }

    public int getYdim() {
        return ydim;
    }

    public void setYdim(int ydim) {
        this.ydim = ydim;
        change();
    }

    public int getXoffset() {
        return xoffset;
    }

    public void setXoffset(int xoffset) {
        this.xoffset = xoffset;
        change();
    }

    public int getYoffset() {
        return yoffset;
    }

    public void setYoffset(int yoffset) {
        this.yoffset = yoffset;
        change();
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
        change();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        change();
    }

    void setL(double l){
        this.l = l;
        change();
    }
    void change(){
        setChanged();
        notifyObservers();
    }

    double getL(){
        return this.l;
    }
}
