// Haga un main, donde por parámetro ponga 3 números y una letra que represente
// ascendente o descendente y los muestre ordenados por tal criterio.
public class Punto1 {
    public static void main(String[] args) {
        try {
            boolean ordenAscendente = true;
            double[] numeros = new double[3];
            double[] ordenado;
            numeros[0] = Double.parseDouble(args[0]);
            numeros[1] = Double.parseDouble(args[1]);
            numeros[2] = Double.parseDouble(args[2]);
            char orden = args[3].charAt(0);
            if (orden == 'a' || orden == 'd') {
                ordenAscendente = orden == 'a';
            } else {
                System.out.printf("ERROR! parametro de orden no reconocido, " +
                        "se ordenara de manera ascendente.%n(ingrese 'd' para orden descendente)%n%n");
            }
            ordenado = ordenar(numeros, ordenAscendente);

            for (double numero : ordenado) {
                imprimirDecimales(numero);
            }
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("ERROR! Debe ingresar 3 numeros.");
        }
    }

    public static double[] ordenar(double[] datos, boolean orden) {
        double x1 = datos[0];
        double x2 = datos[1];
        double x3 = datos[2];
        double[] resultado;
        if (x1 <= x2 && x1 <= x3) {
            if (x2 <= x3) {
                if (!orden) {
                    resultado = new double [] {x3, x2, x1};
                } else {
                    resultado = new double [] {x1, x2, x3};
                }
            } else {
                if (!orden) {
                    resultado = new double [] {x2, x3, x1};
                } else {
                    resultado = new double [] {x1, x3, x2};
                }
            }
        } else if (x2 <= x1 && x2 <= x3) {
            if (x1 <= x3) {
                if (!orden) {
                    resultado = new double [] {x3, x1, x2};
                } else {
                    resultado = new double [] {x2, x1, x3};
                }
            } else {
                if (!orden) {
                    resultado = new double [] {x1, x3, x2};
                } else {
                    resultado = new double [] {x2, x3, x1};
                }
            }
        } else {
            if (x1 <= x2) {
                if (!orden) {
                    resultado = new double [] {x2, x1, x3};
                } else {
                    resultado = new double [] {x3, x1, x2};
                }
            } else {
                if (!orden) {
                    resultado = new double [] {x1, x2, x3};
                } else {
                    resultado = new double [] {x3, x2, x1};
                }
            }
        }
            return resultado;
    }

    public static void imprimirDecimales(double numero) {
        if (numero == (int) numero) {
            System.out.printf("%.0f ", numero);
        } else if (10 * numero == (int) (10 * numero)) {
            System.out.printf("%.1f ", numero);
        } else if (100 * numero == (int) (100 * numero)) {
            System.out.printf("%.2f ", numero);
        } else if (1000 * numero == (int) (1000 * numero)) {
            System.out.printf("%.3f ", numero);
        } else if (10000 * numero == (int) (10000 * numero)) {
            System.out.printf("%.4f ", numero);
        } else if (100000 * numero == (int) (100000 * numero)) {
            System.out.printf("%.5f ", numero);
        } else {
            System.out.printf("%f ", numero);
        }
    }
}
