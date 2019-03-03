package application;

import application.fingerprint.fingerprintreader.FingerprintReader;
import application.proxy.ProxyDoorControl;

public class DoorMediator implements IDoorMediator
{
    private String employee;
    private boolean fingerprintAccepted;
    private boolean accept;


    @Override
    public void setFingerprintAccepted(final boolean fingerprintAccepted)
    {
        this.fingerprintAccepted = fingerprintAccepted;
    }

    @Override
    public boolean Fingerprintaccepted()
    {
        return fingerprintAccepted;
    }

    @Override
    public void setEmployee(final String employee)
    {

        this.employee = employee;
    }

    @Override
    public String getCurrentEmployee()
    {
        return employee;
    }

    @Override
    public void setPasswordaccepted(final boolean accept)
    {

        this.accept = accept;
    }

    @Override
    public boolean getPasswordaccepted()
    {
        return accept;
    }
}
