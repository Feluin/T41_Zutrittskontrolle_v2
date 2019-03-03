package application.fingerprint;

import application.fingerprint.fingerprintreader.IFingersListerner;
import application.proxy.ProxyDoorControl;

import java.util.ArrayList;

public class FingerPrintSensor
{

    private Integer[][] fingerLeft;
    private Integer[][] fingerRight;
    private final ArrayList<IFingersListerner> listeners = new ArrayList<>();

    public void setFingerLeft(Integer[][] fingerLeft)
    {
        this.fingerLeft = fingerLeft;
        update();
    }

    public Integer[][] getFingerLeft()
    {
        return fingerLeft;
    }

    public Integer[][] getFingerRight()
    {
        return fingerRight;
    }

    public void setFingerRight(Integer[][] fingerRight)
    {
        this.fingerRight = fingerRight;
        update();
    }
    public void addListeners(IFingersListerner listener)
    {
        listeners.add(listener);
    }

    public void removeListener(IFingersListerner listener)
    {
        listeners.remove(listener);
    }

    private void update()
    {

        if (fingerLeft != null && fingerRight != null)
        {
            listeners.forEach(IFingersListerner::fingersDetected);
        }
    }
}
