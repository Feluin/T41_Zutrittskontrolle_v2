package application;

import java.util.ArrayList;
import java.util.List;

public class FingerprintScreen
{
    private String text;
    private List<IScreenListener> listeners=new ArrayList<>();

    public void setText(final String text)
    {
        listeners.forEach(iScreenListener -> iScreenListener.onScreenChanged(text));
        this.text = text;
    }

    public void registerListener(final IScreenListener employee)
    {
        listeners.add(employee);
    }
    public void removeListener(final IScreenListener employee){
        listeners.remove(employee);
    }

}
