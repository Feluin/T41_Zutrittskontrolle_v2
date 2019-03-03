package application;

public class DoorMediator implements IDoorMediator
{
    private boolean allowOpenDoor;
    private FingerPrintSensor sensor;
    private Door door;

    @Override
    public void registerDoor(final Door door)
    {

        this.door = door;
    }

    @Override
    public void registerFingerprintSensor(final FingerPrintSensor sensor)
    {

        this.sensor = sensor;
    }

    @Override
    public void setAllowOpenDoor(final boolean allowOpenDoor)
    {
        this.allowOpenDoor = allowOpenDoor;
    }

    @Override
    public boolean openDoorAllowed()
    {
        return allowOpenDoor;
    }
}
