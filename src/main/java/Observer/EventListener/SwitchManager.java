package Observer.EventListener;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class SwitchManager {

    private Collection<SwitchListener> listeners;

    public void addDoorListener(SwitchListener listener) {
        if (listeners == null) {
            listeners = new HashSet<SwitchListener>();
        }
        listeners.add(listener);
    }

    public void removeDoorListener(SwitchListener listener) {
        if (listener == null)
            return;
        listeners.remove(listener);
    }

    protected void fireSwitchOn() {
        if (listeners == null)
            return;
        SwitchEvent event = new SwitchEvent(this, "open");
        notifyListeners(event);
    }

    protected void fireSwitchOff() {
        if (listeners == null)
            return;
        SwitchEvent event = new SwitchEvent(this, "close");
        notifyListeners(event);
    }

    private void notifyListeners(SwitchEvent event) {
        Iterator<SwitchListener> itr = listeners.iterator();
        while (itr.hasNext()) {
            SwitchListener listener = (SwitchListener) itr.next();
            listener.switchEvent(event);
        }
    }
}
