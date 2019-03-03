package application;

import fingerprintreader.FingerprintReader;
import proxy.ProxyDoorControl;

public interface IDoorMediator
{
    void registerFingerprintReader(FingerprintReader reader);
    void registerProxyDoorControl(ProxyDoorControl control);
    void setFingerprintAccepted(boolean fingerprintAccepted);
    boolean Fingerprintaccepted();
    void setEmployee(String employee);
    String getCurrentEmployee();
}
