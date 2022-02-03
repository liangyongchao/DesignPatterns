package AbstractFactory;

abstract class AbstractFactory {

    abstract Printer getPrinter(String type);
    abstract Shape getShape(String shape);
}
