package application.gate;

import application.Door;

public class GateSensor implements IGateListener
{
    private final Door frontDoor;
    private final Door secondDoor;

    public GateSensor(final Door frontDoor,
        final Door secondDoor)
    {
        this.frontDoor = frontDoor;
        this.secondDoor = secondDoor;
    }

    @Override
    public void employeeLeft()
    {
        System.out.println("Employee left");
        secondDoor.closeDoor();
    }

    @Override
    public void employeeEntered()
    {
        System.out.println("Employee entered");
        frontDoor.closeDoor();
    }
}
