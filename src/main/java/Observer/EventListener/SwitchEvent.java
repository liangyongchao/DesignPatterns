package Observer.EventListener;

import java.util.EventObject;

@SuppressWarnings("serial")
public class SwitchEvent extends EventObject implements Cloneable {

    private String switchState = "";

    public String getSwitchState() {
        return switchState;
    }

    public void setSwitchState(String switchState) {
        this.switchState = switchState;
    }

    public SwitchEvent(Object source, String switchState) {
        super(source);
        this.switchState = switchState;
    }

}
