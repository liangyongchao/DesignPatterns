package AbstractFactory;

/**
 * 抽象工厂模式是另一个创建模式。
 *
 * 抽象工厂模式，也称为工厂的工厂，有一个工厂创建其他工厂。
 *
 * 当使用抽象工厂模式时，我们首先使用超级工厂创建工厂，然后使用创建的工厂创建对象。
 */
public class Main {

    public static void main(String[] args) {

        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        Shape shape = shapeFactory.getShape("CIRCLE");

        shape.draw();

        shape = shapeFactory.getShape("RECTANGLE");

        shape.draw();

        shape = shapeFactory.getShape("SQUARE");

        shape.draw();

        AbstractFactory printerFactory = FactoryProducer.getFactory("Printer");

        Printer printer = printerFactory.getPrinter("Paper");

        printer.print();

        printer = printerFactory.getPrinter("Web");

        printer.print();

        printer = printerFactory.getPrinter("Screen");

        printer.print();
    }
}
