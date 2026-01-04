package generics;

public class IntegerPrinter {

    public static void main(String[] args) {

        Printer<Integer> printer = new Printer<>(123);
        printer.print();

         Printer<Double> printer2 = new Printer<>(58.33);
        printer2.print();

         Printer<String> printer3 = new Printer<>("Vipul");
        printer3.print();
    }
}
