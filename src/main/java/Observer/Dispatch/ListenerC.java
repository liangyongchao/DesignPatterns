package Observer.Dispatch;

import Observer.Dispatch.DispatchCenter;
import Observer.Dispatch.Listener;

import java.util.UUID;

public class ListenerC  implements Listener {

    private DispatchCenter center;
    private String identify;

    public ListenerC(){
        identify = UUID.randomUUID().toString();
    }

    @Override
    public void setCenter(DispatchCenter center){
        this.center = center;
    }

    @Override
    public void notice(String message, String targetUUID){
        center.broadcast(identify, message, targetUUID);
    }

    @Override
    public void whenReceived(String message){
        System.out.println(this.getClass().getName() + " got message: " + message);
    }

    @Override
    public String identify(){
        return identify;
    }
}
