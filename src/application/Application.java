package application;

import application.fingerprint.FingerprintUtils;
import application.gate.Gate;
import application.proxy.ProxyDoorControl;

public class Application
{

    public static void main(String[] args)
    {
        Integer[][] fingerLeft = new Integer[1000][1000];
        Integer[][] fingerRight = new Integer[1000][1000];
        for (int i = 0; i < fingerLeft.length; i++)
        {
            final Integer[] integers = fingerLeft[i];
            for (int i1 = 0; i1 < integers.length; i1++)
            {
                fingerLeft[i][i1] = FingerprintUtils.twinPrime(i + i1);
            }

        }
        for (int i = 0; i < fingerRight.length; i++)
        {
            final Integer[] integers = fingerRight[i];
            for (int i1 = 0; i1 < integers.length; i1++)
            {
                fingerRight[i][i1] = FingerprintUtils.rightTrunctablePrime(i + i1);
            }

        }

        Employee employee = new Employee("E01", "30119", "17", fingerLeft, fingerRight);
        ProxyDoorControl doorControl = Gate.INSTANCE.getDoorControl();
        employee.enterName(doorControl);
        employee.putFingerprintsonSensor();
    }
}
