package Observer.Dispatch;

import Observer.Dispatch.*;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        DispatchCenter center = new DispatchCenterImpl();
        ListenerA listenerA = new ListenerA();
        ListenerB listenerB = new ListenerB();
        ListenerC listenerC = new ListenerC();
        center.addListener(listenerA);
        center.addListener(listenerB);
        center.addListener(listenerC);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(()->{
            int i = 1;
            while (i>0){
                listenerA.notice("Hi listenerB, I am " + listenerA.getClass().getName() + ", I have ￥" + new Random().nextInt(100000), listenerB.identify());
                i --;
            }
        });

        executorService.submit(()->{
            int i = 1;
            while (i>0){
                listenerB.notice("Hi listenerC, I am " + listenerB.getClass().getName() + ", I have $" + new Random().nextInt(100000), listenerC.identify());
                i --;
            }
        });

        executorService.execute(()->{
            int i = 1;
            while (i>0){
                listenerC.notice("Hi listenerA, I am " + listenerC.getClass().getName() + ", I have ￥" + new Random().nextInt(100000), listenerA.identify());
                i --;
            }
        });

        executorService.shutdown();
    }
}
