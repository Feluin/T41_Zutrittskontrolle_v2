package application.fingerprint;

public class Fingerprinttuple
{
    private final int leftfingermethod;
    private final int rightfingermethod;

    public Fingerprinttuple(final int leftfingermethod,
        final int rightfingermethod)
    {
        this.leftfingermethod = leftfingermethod;
        this.rightfingermethod = rightfingermethod;
    }

    public int getRightfingermethod()
    {
        return rightfingermethod;
    }

    public int getLeftfingermethod()
    {
        return leftfingermethod;
    }
}
