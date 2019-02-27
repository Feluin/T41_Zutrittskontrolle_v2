package physicalObjects;

import fingersOnPadObserver.IFingersObserver;

import java.util.ArrayList;

public class FingerPrintSensor {

    private Integer[][] fingerLeft;
    private Integer[][] fingerRight;
    private ArrayList<IFingersObserver> listeners= new ArrayList<>();

    public void setFingerLeft(Integer[][] fingerLeft) {
        this.fingerLeft = fingerLeft;
        update();
    }

    public void setFingerRight(Integer[][] fingerRight) {
        this.fingerRight = fingerRight;
        update();
    }

    public Integer[][] getFingerLeft() {
        return fingerLeft;
    }

    public Integer[][] getFingerRight() {
        return fingerRight;
    }

    public void addListeners(IFingersObserver listener){
        listeners.add(listener);
    }

    public void removeListener (IFingersObserver listener) {
        listeners.remove(listener);
    }
    private void update(){
        if (fingerLeft !=null && fingerRight!=null){
            listeners.forEach(IFingersObserver::fingersDetected);
        }
    }
}
