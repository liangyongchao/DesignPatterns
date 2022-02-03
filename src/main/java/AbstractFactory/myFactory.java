package AbstractFactory;

class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new ShapeImpl.Circle();
        }
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new ShapeImpl.Rectangle();
        }
        if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new ShapeImpl.Squire();
        }
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        return null;
    }
}

class PrinterFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    @Override
    Printer getPrinter(String type) {
        if (type == null) {
            return null;
        }
        if(type.equalsIgnoreCase("paper")){
            return new PrinterImpl.PaperPrinter();
        }
        if(type.equalsIgnoreCase("web")){
            return new PrinterImpl.WebPrinter();
        }
        if(type.equalsIgnoreCase("Screen")){
            return new PrinterImpl.ScreenPrinter();
        }
        return null;
    }
}
