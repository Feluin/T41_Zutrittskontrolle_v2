package application;

public class GateSensor implements IGateListener
{
    private Door frontDoor;
    private Door secondDoor;

    public GateSensor(final Door frontDoor,
        final Door secondDoor)
    {
        this.frontDoor = frontDoor;
        this.secondDoor = secondDoor;
    }

    @Override
    public void employeeLeft()
    {
        secondDoor.closeDoor();
    }

    @Override
    public void employeeEntered()
    {
        frontDoor.closeDoor();
    }
}
