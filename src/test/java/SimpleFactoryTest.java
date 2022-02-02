import SimpleFactory.Shape;
import SimpleFactory.ShapeFactory;
import org.junit.Test;

public class SimpleFactoryTest {

    @Test
    public void ShapeTest()
    {
        /**
         * 优点：
         * 工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例。客户端可以免除直接创建产品对象的职责，很方便的创建出相应的产品。工厂和产品的职责区分明确。
         * 客户端无需知道所创建具体产品的类名，只需知道参数即可。
         * 也可以引入配置文件，在不修改客户端代码的情况下更换和添加新的具体产品类。
         * 缺点：
         * 简单工厂模式的工厂类单一，负责所有产品的创建，职责过重，一旦异常，整个系统将受影响。且工厂类代码会非常臃肿，违背高聚合原则。
         * 使用简单工厂模式会增加系统中类的个数（引入新的工厂类），增加系统的复杂度和理解难度
         * 系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂
         * 简单工厂模式使用了 static 工厂方法，造成工厂角色无法形成基于继承的等级结构。
         * 应用场景
         * 对于产品种类相对较少的情况，考虑使用简单工厂模式。使用简单工厂模式的客户端只需要传入工厂类的参数，不需要关心如何创建对象的逻辑，可以很方便地创建所需产品。
         */
        Shape cycle = ShapeFactory.getFactory("Cycle");

        cycle.draw();

        Shape rectangle = ShapeFactory.getFactory("Rectangle");

        rectangle.draw();

        Shape other = ShapeFactory.getFactory("Triangle");

        other.draw();
    }

}
