package AbstractFactory;

public class PrinterImpl {

    static class PaperPrinter implements Printer{
        @Override
        public void print(){
            System.out.println("Paper Printer");
        }
    }

    static class WebPrinter implements Printer{
        @Override
        public void print(){
            System.out.println("Web Printer");
        }
    }

    static class ScreenPrinter implements Printer{
        @Override
        public void print(){
            System.out.println("Screen Printer");
        }
    }
}
