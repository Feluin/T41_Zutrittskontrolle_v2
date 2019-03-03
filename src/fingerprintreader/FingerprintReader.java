package fingerprintreader;

import application.FingerPrintSensor;
import application.IDoorMediator;
import proxy.ProxyDoorControl;

public class FingerprintReader implements IFingersListerner
{

    private final ProxyDoorControl control;
    private final IDoorMediator mediator;
    private final FingerPrintSensor sensor;

    public FingerprintReader(ProxyDoorControl control,
        IDoorMediator mediator,
        final FingerPrintSensor sensor){

        this.control = control;
        this.mediator = mediator;
        this.sensor = sensor;
    }
    private void scanFingers(){
        //todo Aufruf der Scann Methode
        System.out.println("start scanning fingerprints");
        if(control.acceptFingerPrints(sensor.getFingerLeft(),sensor.getFingerRight())){
            mediator.setFingerprintAccepted(true);
            control.getScreen().setText(Math.random()>0.5?"Password1":"Password2");
        }else {
            mediator.setFingerprintAccepted(false);
            control.getScreen().setText("Error");
        }
    }

    @Override
    public void fingersDetected() {
        scanFingers();
    }
}
