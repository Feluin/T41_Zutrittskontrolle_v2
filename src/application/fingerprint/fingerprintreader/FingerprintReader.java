package application.fingerprint.fingerprintreader;

import application.fingerprint.FingerPrintSensor;
import application.fingerprint.FingerprintUtils;
import application.fingerprint.Fingerprinttuple;
import application.IDoorMediator;
import application.proxy.ProxyDoorControl;

public class FingerprintReader implements IFingersListerner
{

    private final ProxyDoorControl control;
    private final IDoorMediator mediator;
    private final FingerPrintSensor sensor;

    public FingerprintReader(ProxyDoorControl control,
        IDoorMediator mediator,
        final FingerPrintSensor sensor)
    {

        this.control = control;
        this.mediator = mediator;
        this.sensor = sensor;
    }

    private void scanFingers()
    {

        System.out.println("start scanning fingerprints");

        if (acceptFingerPrints(sensor.getFingerLeft(), sensor.getFingerRight()))
        {
            mediator.setFingerprintAccepted(true);
            control.getScreen().setText(Math.random() > 0.5 ? "Password1" : "Password2");
        } else
        {
            mediator.setFingerprintAccepted(false);
            control.getScreen().setText("Error");
        }
    }

    private boolean acceptFingerPrints(final Integer[][] fingerLeft,
        final Integer[][] fingerRight)
    {
        Fingerprinttuple methods = control.getFingeprintMethodsfor(mediator.getCurrentEmployee());
        boolean fingerleft = checkFingerPrint(fingerLeft, methods.getLeftfingermethod());
        boolean fingerright = checkFingerPrint(fingerRight, methods.getRightfingermethod());
        return fingerleft&&fingerright;
    }

    private boolean checkFingerPrint(final Integer[][] fingerprint,
        final int fingermethod)
    {
        for (int i = 0; i < fingerprint.length; i++)
        {
            final Integer[] integers = fingerprint[i];
            for (int i1 = 0; i1 < integers.length; i1++)
            {
                final Integer integer = integers[i1];
                int index=i+i1;
                switch (fingermethod)
                {
                    case 1:

                        if (!FingerprintUtils.twinPrime(index).equals(integer))
                        {
                            return false;
                        }
                        break;
                    case 2:
                        if (!FingerprintUtils.primePalindrome(index).equals(integer))
                        {
                            return false;
                        }
                        break;
                    case 3:
                        if (!FingerprintUtils.leftTrunctablePrime(index).equals(integer))
                        {
                            return false;
                        }
                        break;
                    case 4:
                        if (!FingerprintUtils.rightTrunctablePrime(index).equals(integer))
                        {
                            return false;
                        }
                        break;
                    case 5:
                        if (!FingerprintUtils.rhondaNumber(integer).equals(integer))
                        {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

    @Override
    public void fingersDetected()
    {
        scanFingers();
    }
}
