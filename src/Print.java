public class Print {

    MetodoPolinomio mp = new MetodoPolinomio();
    DataSet ds = new DataSet();
    RegrecionPolinomial regrecionPolinomial = new RegrecionPolinomial();
    Predictions predictions = new Predictions();


    public void  printCrearMstriz(){
        int grado = 5;
        double [][] matrizX = mp.crearMatriz(grado, ds.x);

        System.out.println("Matriz de X para grado  " + grado + ":");
        printMatrizX(matrizX);


    }

    public void printMatrizX(double [][] matrizx){
        for (int i= 0; i< matrizx.length; i++){
            for(int j=0; j < matrizx[i].length; j++){
                System.out.printf("%15.4f", matrizx[i][j]);
            }
            System.out.println();
        }
    }

    public void  printCrearMatrizT(){
        int grado = 5;
        double[][] matrizX = mp.crearMatriz(grado, ds.x);
        double [][] matrizXT = mp.crearMatrizT(matrizX);

        System.out.println("Matriz Transpuesta de X :");
        printMatrizX(matrizXT);
    }

    public double[][] printProductosMatrices(){
        Operaciones op = new Operaciones();
        MetodoPolinomio mp = new MetodoPolinomio();
        DataSet ds = new DataSet();

        double [][] matrizX = mp.crearMatriz(ds.grado, ds.x);
        double[][] matrizXT = mp.crearMatrizT(matrizX);

        double [][] resultado = op.productoMatrices(matrizX, matrizXT ,ds.grado);

        System.out.println("Resultado del Producto de la Transpuesta: ");
        printMatricesX(resultado);

        return resultado;

    }

    public  void  printMatricesX(double [][] matrizX) {
        for(int i = 0; i < matrizX.length; i++){
            for(int j = 0; j < matrizX[i].length; j++){
                System.out.printf("%33.10f", matrizX[i][j]);
            }
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }


    public  void printInversa(double [][] x){
        Operaciones op = new Operaciones();
        double [][] inversa = op.IversaProducto(x);

        System.out.println("Iversa del Producto : (X^T * X) ");


        for (int i=0; i< inversa.length; i++){
            for (int j=0; j<inversa[i].length; j++){
                System.out.printf("%25.10f", inversa[i][j]);
            }
            System.out.println();
        }
    }

    public void printProductoTranspuestaXY(){
        Operaciones op = new Operaciones();
        MetodoPolinomio mp = new MetodoPolinomio();

        int grado = 5;
        double [][] matrizX = mp.crearMatriz(grado, ds.x);
        double [][] matrizXT = mp.crearMatrizT(matrizX);

        double [] resultado = op.productoTranspuestaXY(matrizXT, ds.y);
        System.out.println("--------------Resultado de: X^T * Y-------------------");
        for (double valor : resultado){
            System.out.printf("%25.4f",valor);
        }
        System.out.println();
    }

    public void printRegresionPolinomial(){
        double[] coeficientes = regrecionPolinomial.bDeHat;
        System.out.print("-----------Coeficiente-------------\n");
       for(int i=0; i< coeficientes.length; i++) {
           System.out.printf("Coeficientes b[%d]: %15.4f\n", i, coeficientes[i]);
         }

       }

    public void printPredictions() {
        System.out.print("Las predicciones son: ");
        for (int i = 0; i < predictions.resultado.length; i++) {
            System.out.printf("%.2f", predictions.resultado[i]);
            if (i < predictions.resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }



}


