package application;

import proxy.IDoorAccess;

public class Door implements IDoorAccess
{

    private String door;

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
        isOpen=true;
        return false;
    }
    public void closeDoor(){
        isOpen=false;
    }

}
