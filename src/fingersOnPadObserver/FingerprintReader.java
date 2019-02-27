package fingersOnPadObserver;

public class FingerprintReader implements IFingersObserver {

    public void scanFingers(){
        //todo Aufruf der Scann Methode
        System.out.println("start scanning fingerprints");
    }

    @Override
    public void fingersDetected() {
        scanFingers();
    }
}
