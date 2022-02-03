package AbstractFactory;

public class ShapeImpl {

    static class Rectangle implements Shape{

        @Override
        public void draw(){
            System.out.println("I am Rectangle.");
        }
    }

    static class Circle implements Shape{

        @Override
        public void draw(){
            System.out.println("I am Circle.");
        }
    }

    static class Squire implements Shape{

        @Override
        public void draw(){
            System.out.println("I am Squire.");
        }
    }
}
