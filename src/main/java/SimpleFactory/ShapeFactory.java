package SimpleFactory;

public class ShapeFactory {


    public static Shape getFactory(String shapeName){

        Shape shape = null;

        if(shapeName.equalsIgnoreCase("Cycle")){
            shape = new Cycle();
        }

        if(shapeName.equalsIgnoreCase("Rectangle")){
            shape = new Rectangle();
        }

        if(shapeName.equalsIgnoreCase("Triangle")){
            shape = new OtherShape();
        }

        return shape;
    }
}
