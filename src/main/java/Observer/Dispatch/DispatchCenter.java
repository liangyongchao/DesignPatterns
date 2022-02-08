package Observer.Dispatch;

public interface DispatchCenter {

    void broadcast(String own, String message, String targetUUID);

    void addListener(Listener listener);
}
