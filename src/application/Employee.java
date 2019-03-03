package application;

import proxy.ProxyDoorControl;

public class Employee implements IScreenListener
{
    private String name;
    private String password1;
    private String password2;
    private Integer[][] leftFingerPrint;
    private Integer[][] rightFingerprint;
    private ProxyDoorControl control;

    public Employee(String name,
        final String password1,
        final String password2,Integer[][] leftFingerPrint,Integer[][] rightFingerprint)
    {

        this.name = name;
        this.password1 = password1;
        this.password2 = password2;
        this.leftFingerPrint = leftFingerPrint;
        this.rightFingerprint = rightFingerprint;
    }

    @Override
    public void onScreenChanged(final String newText)
    {
        //put in password
        switch (newText)
        {
            case "Password1":
               control.enterText(password1);
                break;
            case "Password2":
                control.enterText(password2);
                break;
            case "Error":
            default:
                return;

        }
        //open door

        if(Gate.INSTANCE.getDoorControl().openDoor()){
            //enter gate
            Gate.INSTANCE.enterEmployee(this);
            //leavegate
            Gate.INSTANCE.employeeLeft();
        }



    }

    public void enterName(ProxyDoorControl control){
        this.control = control;
        control.getScreen().registerListener(this);
        control.enterText(name);
    }

    public void putFingerprintsonSensor()
    {
        control.getFingerPrintSensor().setFingerLeft(leftFingerPrint);
        control.getFingerPrintSensor().setFingerRight(rightFingerprint);
    }
}
