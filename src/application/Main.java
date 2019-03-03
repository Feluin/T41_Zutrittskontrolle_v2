package application;

import proxy.ProxyDoorControl;

public class Main
{

    public static void main(String[] args)
    {
        Employee employee=new Employee("","","", null, null);
        ProxyDoorControl doorControl = Gate.INSTANCE.getDoorControl();
        employee.enterName(doorControl);
        employee.putFingerprintsonSensor();
//Observer fingerprints on detector =========================================

// person in Room detector==========BEGIN==================================================
// person in Room detector===========END=================================================
    }
}
