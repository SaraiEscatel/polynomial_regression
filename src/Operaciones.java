public class Operaciones {

    MetodoPolinomio mp = new MetodoPolinomio();
    DataSet ds = new DataSet();


    public double [][] productoMatrices(double [][] x, double[][] Xt, int grados){
        double [][] Xg = mp.crearMatriz(grados, ds.x);

        if(Xt[0].length != Xg.length){
            throw new IllegalArgumentException("Las dimenciones de las matrices no son compatibles para multiplicacion.");
        }

        int filasXt = Xt.length;
        int columnasXg = Xg[0].length;
        double [][] resultado = new double[filasXt][columnasXg];

        for (int i=0; i < filasXt; i++){
            for(int j=0; j < columnasXg; j++){
                for (int k = 0; k < Xt[0].length; k++){
                    resultado[i][j] += Xt[i][k] * Xg[k][j];
                }
            }
        }
         return resultado;

    }

    //Calcular la inversa du una matriz  usando Gauss-Jordan
    public double [][] IversaProducto(double [][] x) {

        int n = x.length;

        double[][] matrizAumentada = new double[n][n * 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizAumentada[i][j] = x[i][j];//Es la parte iszquiersa la parte original
                matrizAumentada[i][j + n] = (i == j) ? 1 : 0;//Es la parte derecha la parte identidad
            }
        }

        for (int i = 0; i < n; i++) {
            //Se convierte a el elemento pivote en 1
            double pivote = matrizAumentada[i][i];
            if (pivote == 0) {
                throw new ArithmeticException("La matriz no es invertible");
            }
            for (int j = 0; j < n * 2; j++) {
                matrizAumentada[i][j] /= pivote;
            }

            //Se hace 0 para la columnas de pivote para las otras filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrizAumentada[k][i];
                    for (int j = 0; j < n * 2; j++) {
                        matrizAumentada[k][j] -= factor * matrizAumentada[i][j];
                    }
                }
            }
        }

        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = matrizAumentada[i][j + n];
            }

        }

        return inversa;
    }


    public double []  productoMatrizTranspuestaPorVector(double [][] x, double [] y){
        int filas = x.length;
        int columnas = x[0].length;

        if(columnas != y.length){
            throw  new IllegalArgumentException("Las dimenciones de la matriz y el vector no son conpatibles para la multiplicacion");
        }

        double[] resultado = new  double[filas];

        for(int i=0; i<filas; i++){
            resultado[i] = 0;
            for(int j=0; j < columnas; j++){
                resultado[i] += x[i][j] * y[j];
            }
        }
        return  resultado;

    }

    public double [] productoTranspuestaXY(double [][] x, double [] y){
        return productoMatrizTranspuestaPorVector(x,y);
    }
}
