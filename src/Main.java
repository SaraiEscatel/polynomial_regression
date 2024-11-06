//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   static Print print = new Print();

    public static void main(String[] args) {

        print.printCrearMstriz();
        print.printCrearMatrizT();

        double [][] producto = print.printProductosMatrices();

        print.printInversa(producto);
        print.printProductoTranspuestaXY();
        print.printRegresionPolinomial();
        print.printPredictions();

    }
}