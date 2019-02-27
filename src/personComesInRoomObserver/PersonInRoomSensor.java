package personComesInRoomObserver;

import java.util.ArrayList;

public class PersonInRoomSensor {

    private ArrayList<IPersonInRoomSensor> listeners;

    public PersonInRoomSensor() {
      listeners= new ArrayList<>();
    }

    public void addListener(IPersonInRoomSensor listener){
        listeners.add(listener);
    }

    public void removeListener(IPersonInRoomSensor listener){
        listeners.remove(listener);
    }

    public void detectPerson(){
            for (IPersonInRoomSensor listener: listeners){
                listener.detectPersonInRoom();
            }

    }
    public void detectPersonLeft() {
        for (IPersonInRoomSensor listener : listeners) {
            listener.detectPersonLeftRoom();
        }
    }
}
