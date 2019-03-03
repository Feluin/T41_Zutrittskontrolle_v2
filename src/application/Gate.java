package application;

import fingerprintreader.FingerprintReader;
import proxy.ProxyDoorControl;

import java.util.ArrayList;
import java.util.List;

public enum Gate
{
    INSTANCE;
    private Door frontDoor;
    private Door seconddoor;
    private FingerprintReader fingerprintReader;
    private Employee currentEmployee;
    private List<IGateListener> gateListeners = new ArrayList<>();
    private ProxyDoorControl doorControl;
    private GateSensor gateSensor;

    Gate()
    {

        frontDoor = new Door("Frontdoor");
        seconddoor = new Door("Backdoor");
        doorControl=new ProxyDoorControl(frontDoor);
        gateSensor=new GateSensor(frontDoor,seconddoor);
    }

    public void addGateListeners(IGateListener gateListener)
    {
        gateListeners.add(gateListener);
    }

    public void enterEmployee(Employee employee)
    {
        if (currentEmployee == null)
        {
            currentEmployee = employee;
            gateListeners.forEach(IGateListener::employeeEntered);
        }
    }

    public void employeeLeft()
    {
        if (currentEmployee != null)
        {
            currentEmployee = null;
            gateListeners.forEach(IGateListener::employeeLeft);
        }
    }

    public Door getSeconddoor()
    {
        return seconddoor;
    }

    public ProxyDoorControl getDoorControl()
    {
        return doorControl;
    }

}

