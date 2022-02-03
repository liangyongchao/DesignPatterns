package AbstractFactory;

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
