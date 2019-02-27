package personComesInRoomObserver;


import physicalObjects.Door;

public class DoorOpener implements IPersonInRoomSensor{


    @Override
    public void detectPersonInRoom(){

        Door.First.setOpen(false);
        System.out.println("Embloyee is in Chamber\nFirst door is opened: "+Door.First.isOpen());
         Door.Second.setOpen(true);
        System.out.println("Second door is opened: "+Door.Second.isOpen()+"\n\n");

    }

    @Override
    public void detectPersonLeftRoom() {
        Door.Second.setOpen(false);
        System.out.println("Embloyee left Chamber\nSecond door is opened: "+Door.Second.isOpen()+"\n\n");
    }
}
