package Observer.EventListener;

import java.util.EventListener;

public interface SwitchListener extends EventListener {
    public void switchEvent(SwitchEvent event);
}
