import java.awt.*;
import java.awt.event.ComponentListener;
import java.util.Observable;

class ControlPanelModel extends Observable {
    private double l;
    private double diameter;
    private Color color;
    private int updateFreq;

    ControlPanelModel(){
        //initial color
        this.setColor(Color.BLACK);
    }

    double getDiameter() {
        return diameter;
    }

    void setDiameter(double diameter) {
        this.diameter = diameter;
        change();
    }

    int getUpdateFreq() {
        return updateFreq;
    }

    void setUpdateFreq(int updateFreq) {
        this.updateFreq = updateFreq;
        change();
    }

    Color getColor() {
        return color;
    }

    void setColor(Color color) {
        this.color = color;
        change();
    }

    void setL(double l){
        this.l = l;
        change();
    }
    private void change(){
        setChanged();
        notifyObservers();
    }
}
