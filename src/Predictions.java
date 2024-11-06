public class Predictions {

    public int predecir[] = new int[]{60,80,100,25,50};

    public double resultado [] = new double[predecir.length];//En este array guardo las predicciones
    RegrecionPolinomial regrecionPolinomial;

    public Predictions() {
        this.regrecionPolinomial = new RegrecionPolinomial();
        this.resultado =  prediccion();//Aqui estoy calculando las predicciones
    }

    public  double [] prediccion(){

        double[] coeficientes = regrecionPolinomial.bDeHat;
        resultado = new  double[predecir.length];

        for(int i=0; i<predecir.length; i++) {
            double x = predecir[i];
            resultado[i] = coeficientes[0]//b0
                    + coeficientes[1]//b1 * X
                    + coeficientes[2] * Math.pow(x, 2)//b2 * X^2
                    + coeficientes[3] * Math.pow(x, 3)//b3 * X^2
                    + coeficientes[4] * Math.pow(x, 4)//b4 * X^2
                    + coeficientes[5] * Math.pow(x, 5);//b5 * X^2
        }

        return  resultado;

        }

    }


