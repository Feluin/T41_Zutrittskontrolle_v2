package application.gate;

import application.Door;
import application.Employee;
import application.proxy.ProxyDoorControl;

import java.util.ArrayList;
import java.util.List;

public enum Gate
{
    INSTANCE;
    private final Door frontDoor;
    private final Door seconddoor;
    private Employee currentEmployee;
    private final List<IGateListener> gateListeners = new ArrayList<>();
    private final ProxyDoorControl doorControl;

    Gate()
    {
        frontDoor = new Door("Frontdoor");
        seconddoor = new Door("Backdoor");
        doorControl = new ProxyDoorControl(frontDoor);
        final GateSensor gateSensor = new GateSensor(frontDoor, seconddoor);
        addGateListeners(gateSensor);
    }

    public void addGateListeners(IGateListener gateListener)
    {
        gateListeners.add(gateListener);
    }

    public void enterEmployee(Employee employee)
    {
        if (currentEmployee == null)
        {
            if (frontDoor.isOpen())
            {
                currentEmployee = employee;
                gateListeners.forEach(IGateListener::employeeEntered);
            }
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

