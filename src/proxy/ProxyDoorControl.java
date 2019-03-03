package proxy;

import application.Door;
import application.DoorMediator;
import application.FingerPrintSensor;
import application.FingerprintScreen;
import application.Fingerprinttuple;
import application.IDoorMediator;
import fingerprintreader.FingerprintReader;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProxyDoorControl implements IDoorAccess
{
    private Door frontdoor;
    private Map<String, Fingerprinttuple> employeeFingerprintMethodMap = new HashMap<>();
    private Map<String, Long> employeeBirtdayMap = new HashMap<>();
    private FingerPrintSensor fingerPrintSensor;
    private FingerprintScreen screen;

    public ProxyDoorControl(Door frontdoor)
    {

        this.frontdoor = frontdoor;
        employeeBirtdayMap.put("E01", (new Date(1970, 1, 1)).getTime());
        employeeBirtdayMap.put("E02", (new Date(1980, 5, 9)).getTime());
        employeeBirtdayMap.put("E03", (new Date(1962, 12, 20)).getTime());
        employeeFingerprintMethodMap.put("E01", new Fingerprinttuple(1, 4));
        employeeFingerprintMethodMap.put("E02", new Fingerprinttuple(2, 3));
        employeeFingerprintMethodMap.put("E03", new Fingerprinttuple(1, 5));
        IDoorMediator mediator = new DoorMediator();
        fingerPrintSensor = new FingerPrintSensor(this);
        FingerprintReader reader =new FingerprintReader(this, mediator, fingerPrintSensor);

    }

    @Override
    public boolean openDoor()
    {
        frontdoor.openDoor();
        return false;
    }

    public FingerPrintSensor getFingerPrintSensor()
    {
        return fingerPrintSensor;
    }

    public void enterText(final String name)
    {

    }

    public FingerprintScreen getScreen()
    {
        return screen;
    }

    public boolean acceptFingerPrints(final Integer[][] fingerLeft,
        final Integer[][] fingerRight)
    {

        return false;
    }
}
