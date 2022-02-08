package Observer.Dispatch;

import Observer.Dispatch.DispatchCenter;

public interface Listener {

    void setCenter(DispatchCenter center);

    void notice(String message, String targetUUID);

    void whenReceived(String message);

    String identify();
}
