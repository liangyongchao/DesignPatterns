package Observer.EventListener;

public class SwitchListenerImpl implements SwitchListener {

    @Override
    public void switchEvent(SwitchEvent event) {

        if (event.getSwitchState() != null) {
            System.out.println("Event state: " + event.getSwitchState());
        }
    }
}
