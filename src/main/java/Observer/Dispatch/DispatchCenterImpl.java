package Observer.Dispatch;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DispatchCenterImpl implements DispatchCenter {

    private static final Map<String, Listener> map = new ConcurrentHashMap<>();

    @Override
    public void broadcast(String own, String message, String targetUUID){
        map.forEach((k,v)-> {
            //Don't send the message to itself
            //if(!k.equals(own)){
            if(k.equalsIgnoreCase(targetUUID)){
                v.whenReceived(message);
            }
        });
    }

    @Override
    public void addListener(Listener listener){
        listener.setCenter(this);
        map.put(listener.identify(), listener);
    }
}
