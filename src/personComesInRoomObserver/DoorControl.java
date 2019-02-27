
package personComesInRoomObserver;


import physicalObjects.FingerPrintSensor;

public class DoorControl {

    private static DoorControl instance =new DoorControl();
    private FingerPrintSensor fingerPrintSensor=new FingerPrintSensor();




    private DoorControl(){

    }



    public static DoorControl getInstance() {
        return instance;
    }



}
