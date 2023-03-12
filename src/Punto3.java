// Lo mismo, pero usando los parámetros si hay alguno (como en a) y haciendo (b) si no
// detecta ninguno. Vea si con una función puede evitar repetir código.

import java.util.Scanner;

public class Punto3 {
    public static void main(String[] args) {
        boolean ordenAscendente;
        char orden;
        Double[] numeros = new Double[3];
        double[] ordenado;
        for (int i = 0; i < 3; i++) {
            try {
                numeros[i] = Double.parseDouble(args[i]);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                numeros[i] = null;
            }
        }
        try {
            orden = args[3].charAt(0);
        } catch (IndexOutOfBoundsException e) {
            orden = 's';
        }
        completarNumeros(numeros);
        ordenAscendente = pedirOrden(orden);

        ordenado = ordenar(numeros, ordenAscendente);

        for (double numero : ordenado) {
            imprimirDecimales(numero);
        }
    }

    public static double[] ordenar(Double[] datos, boolean orden) {
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

    public static void completarNumeros(Double[] numeros) {
        String input;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == null) {
                System.out.print("Ingrese un numero: ");
                while (true) {
                    try {
                        input = scanner.nextLine();
                        numeros[i] = Double.parseDouble(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("ERROR! Ingrese un numero: ");
                    }
                }
            }
        }
    }

    public static boolean pedirOrden(Character orden) {
        Scanner scanner = new Scanner(System.in);
        boolean ordenAscendente;
        if ('a' == orden || 'd' == orden) {
            ordenAscendente = orden == 'a';
        } else {
            System.out.print("Ingrese el orden ('a' para ascendente, 'd' para descendente): ");
            while (true) {
                orden = scanner.next().charAt(0);
                if (orden == 'a' || orden == 'd') {
                    ordenAscendente = orden == 'a';
                    break;
                } else {
                    System.out.print("ERROR! Ingrese el orden ('a' para ascendente, 'd' para descendente: ");
                }
            }
        }
        return ordenAscendente;
    }
}
