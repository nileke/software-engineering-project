
import java.awt.*;
import java.util.Observable;

public class ControlPanelModel extends Observable {

    private double l;
    private double diameter;
    private Color color;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
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
