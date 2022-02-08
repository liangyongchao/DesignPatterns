package Singleton;

public class Main {

    public static void main(String[] args) {
        MainWindow obj1 = MainWindow.getInstance();

        obj1.showMessage();

        MainWindow obj2 = MainWindow.getInstance();

        obj2.showMessage();
    }
}

/**
 * 下面的代码将创建一个MainWindow类。
 *
 * MainWindow类的构造函数是私有的，并且有一个自身的静态实例。
 *
 * MainWindow类提供了一个静态方法来获取它的静态实例到外部世界。
 *
 * Main，我们的演示类将使用MainWindow类来获取一个MainWindow对象。
 */
class MainWindow{
    private static MainWindow instance = new MainWindow();

    private MainWindow(){}

    private int cnt = 0;

    public static MainWindow getInstance(){
        return instance;
    }

    public void showMessage(){
        cnt ++;
        System.out.println("Singleton test. cnt = " + cnt);
    }
}


