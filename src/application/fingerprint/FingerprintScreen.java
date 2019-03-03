package application.fingerprint;

import application.IScreenListener;

import java.util.ArrayList;
import java.util.List;

public class FingerprintScreen
{
    private String text;
    private final List<IScreenListener> listeners=new ArrayList<>();

    public void setText(final String text)
    {
        this.text = text;
        listeners.forEach(iScreenListener -> iScreenListener.onScreenChanged(text));
    }

    public void registerListener(final IScreenListener employee)
    {
        listeners.add(employee);
    }
    public void removeListener(final IScreenListener employee){
        listeners.remove(employee);
    }

    public String  getText()
    {
        return text;
    }
}
