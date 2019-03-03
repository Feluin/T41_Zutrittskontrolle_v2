package application;

public class Fingerprinttuple
{
    private int leftfingermethod;
    private int rightfingermethod;

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
