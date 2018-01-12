import java.awt.*;
import java.util.Observable;

public class ControlPanelModel extends Observable {
    private double l;
    private double diameter;
    private Color color;
    private int updateFreq;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        change();
    }

    public int getUpdateFreq() {
        return updateFreq;
    }

    public void setUpdateFreq(int updateFreq) {
        this.updateFreq = updateFreq;
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

}
