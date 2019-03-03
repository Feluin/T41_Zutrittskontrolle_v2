package application;

import application.fingerprint.fingerprintreader.FingerprintReader;
import application.proxy.ProxyDoorControl;

public interface IDoorMediator
{

    void setFingerprintAccepted(boolean fingerprintAccepted);
    boolean Fingerprintaccepted();
    void setEmployee(String employee);
    String getCurrentEmployee();

    void setPasswordaccepted(boolean accept);
    boolean getPasswordaccepted();
}
