// Haga lo mismo, pero solicitando los parámetros de a uno por consola.

import java.util.Scanner;
public class Punto2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ordenAscendente;
        String input;
        double[] numeros = new double[3];
        double[] ordenado;
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Ingrese un numero (%d de 3): ", i + 1);
            while (true) {
                try {
                    input = scanner.nextLine();
                    numeros[i] = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.printf("ERROR! Ingrese un numero (%d de 3): ", i + 1);
                }
            }
        }
        System.out.print("Ingrese el orden ('a' para ascendente, 'd' para descendente): ");
        while (true) {
            char orden = scanner.next().charAt(0);
            if (orden == 'a' || orden == 'd') {
                ordenAscendente = orden == 'a';
                break;
            } else {
                System.out.print("ERROR! Ingrese el orden ('a' para ascendente, 'd' para descendente: ");
            }
        }
        ordenado = ordenar(numeros, ordenAscendente);
        for (double numero : ordenado) {
            imprimirDecimales(numero);
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
