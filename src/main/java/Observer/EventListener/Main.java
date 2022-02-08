package Observer.EventListener;

public class Main {

    public static void main(String[] args) throws Exception{

        /**
         * 使用Java标准的java.util.EventListener实现观察者-发布者设计模式
         *
         * 观察者模式用于在一个对象被修改时通知其相关对象。
         *
         * 观察者模式是一种行为模式类别。
         */
        SwitchManager manager = new SwitchManager();

        SwitchListener listener1 = new SwitchListenerImpl();
        SwitchListener listener2 = new SwitchListenerImpl();
        SwitchListener listener3 = new SwitchListenerImpl();

        manager.addDoorListener(listener1);
        manager.addDoorListener(listener2);
        manager.addDoorListener(listener3);
        manager.fireSwitchOn();

        Thread.sleep(1000);

        manager.fireSwitchOff();
        manager.removeDoorListener(listener1);
        manager.removeDoorListener(listener2);
        manager.removeDoorListener(listener3);

    }
}
