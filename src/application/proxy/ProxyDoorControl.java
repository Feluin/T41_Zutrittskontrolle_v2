package application.proxy;

import application.Door;
import application.DoorMediator;
import application.fingerprint.FingerPrintSensor;
import application.fingerprint.FingerprintScreen;
import application.fingerprint.Fingerprinttuple;
import application.IDoorMediator;
import application.PasswordUtils;
import application.fingerprint.fingerprintreader.FingerprintReader;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProxyDoorControl implements IDoorAccess
{
    private final Door frontdoor;
    private final Map<String, Fingerprinttuple> employeeFingerprintMethodMap = new HashMap<>();
    private final Map<String, Long> employeeBirtdayMap = new HashMap<>();
    private final FingerPrintSensor fingerPrintSensor;
    private final FingerprintScreen screen;
    private final IDoorMediator mediator = new DoorMediator();

    public ProxyDoorControl(Door frontdoor)
    {

        this.frontdoor = frontdoor;
        employeeBirtdayMap.put("E01", (new Date(1970, 1, 1)).getTime());
        employeeBirtdayMap.put("E02", (new Date(1980, 5, 9)).getTime());
        employeeBirtdayMap.put("E03", (new Date(1962, 12, 20)).getTime());
        employeeFingerprintMethodMap.put("E01", new Fingerprinttuple(1, 4));
        employeeFingerprintMethodMap.put("E02", new Fingerprinttuple(2, 3));
        employeeFingerprintMethodMap.put("E03", new Fingerprinttuple(1, 5));


        fingerPrintSensor = new FingerPrintSensor();

        screen = new FingerprintScreen();

        FingerprintReader reader = new FingerprintReader(this, mediator, fingerPrintSensor);
        fingerPrintSensor.addListeners(reader);
    }

    @Override
    public boolean openDoor()
    {
        if (mediator.getPasswordaccepted())
        {
            frontdoor.openDoor();
            return true;
        }

        return false;
    }

    public FingerPrintSensor getFingerPrintSensor()
    {
        return fingerPrintSensor;
    }

    public void enterText(final String input)
    {
        System.out.println("Text entered: "+input);
        if (mediator.Fingerprintaccepted())
        {
            boolean accept;
            switch (screen.getText())
            {
                case "Password1":
                    accept = testPassword1(mediator.getCurrentEmployee(), input);
                    break;
                case "Password2":
                    accept = testPassword2(mediator.getCurrentEmployee(), input);
                    break;
                default:
                    return;
            }
            System.out.println("Password accepted: "+accept);
            mediator.setPasswordaccepted(accept);
        } else
        {
            mediator.setEmployee(input);
        }
    }

    public Fingerprinttuple getFingeprintMethodsfor(final String currentEmployee)
    {
        return employeeFingerprintMethodMap.get(currentEmployee);
    }

    private boolean testPassword1(final String currentEmployee,
        final String input)
    {
        return PasswordUtils.lastPrimeFactor(employeeBirtdayMap.get(currentEmployee)).equals(Integer.valueOf(input));
    }

    private boolean testPassword2(final String currentEmployee,
        final String input)
    {
        return PasswordUtils.sumPrimeFactors(employeeBirtdayMap.get(currentEmployee)).equals(Integer.valueOf(input));
    }

    public FingerprintScreen getScreen()
    {
        return screen;
    }

}
