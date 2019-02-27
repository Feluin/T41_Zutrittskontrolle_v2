package application;


import personComesInRoomObserver.DoorOpener;
import personComesInRoomObserver.PersonInRoomSensor;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");
//Observer fingerprints on detector =========================================





// person in Room detector==========BEGIN==================================================
        PersonInRoomSensor personInRoomSensor =new PersonInRoomSensor();
        DoorOpener doorOpener =new DoorOpener();
        personInRoomSensor.addListener(doorOpener);
        personInRoomSensor.detectPerson();

        personInRoomSensor.detectPersonLeft();
// person in Room detector===========END=================================================
    }
}
