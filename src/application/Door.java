package application;

import application.proxy.IDoorAccess;

public class Door implements IDoorAccess
{

    private final String door;

    public Door(String door)
    {

        this.door = door;
    }

    private boolean isOpen;



    public boolean isOpen()
    {
        return isOpen;
    }

    @Override
    public boolean openDoor()
    {
        System.out.println(door+"was opened");
        isOpen=true;
        return true;
    }
    public void closeDoor(){
        System.out.println(door+"was closed");
        isOpen=false;
    }

}
