public class RegrecionPolinomial {

    double [] bDeHat;

    public RegrecionPolinomial(){
        this.bDeHat = calcularCoeficientes();
    }

    public  double [] calcularCoeficientes(){

        MetodoPolinomio mp = new MetodoPolinomio();
        Operaciones op = new Operaciones();
        DataSet ds = new DataSet();

        double[][] matrizX = mp.crearMatriz(ds.grado, ds.x);
        double[][] matrizXT = mp.crearMatrizT(matrizX);

        //Calcular (X^T X)
        double [][] xtX = op.productoMatrices(matrizX,matrizXT, ds.grado);

        //Calcular la inversa (X^T X)^-1
        double [][] xtxInversa = op.IversaProducto(xtX);

        //Calcular X^T * Y
        double [] xtY = op.productoTranspuestaXY(matrizXT,ds.y);

        //Calcular B de Hat = (X^T X )^-1 * X^T * Y
        double [] BHat = op.productoMatrizTranspuestaPorVector(xtxInversa,xtY);
        return BHat;
    }

}
