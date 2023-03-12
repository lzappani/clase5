// Haga un main donde por parámetro envíe la ruta de un archivo. Ese archivo debe contener
// números. El programa debe escribir por consola la suma de esos números
// Al programa anterior agreguele un parámetro para que la operación pueda ser suma o multiplicación.

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Punto4 {
    public static void main(String[] args) {
        double suma = 0;
        double multiplicacion = 1;
        int operacion;
        Scanner scn = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo en la carpeta files: ");
        String path = "./files/" + scn.nextLine();
        try {
            File entrada = new File(path);
            Scanner filescn = new Scanner(entrada);
            System.out.print("Ingrese la operacion (1 - suma, 2 - multiplicacion): ");
            operacion = scn.nextInt();
            while (operacion != 1 && operacion != 2) {
                System.out.print("ERROR! Ingrese la operacion (1 - suma, 2 - multiplicacion): ");
                operacion = scn.nextInt();
            }

            while (filescn.hasNextLine()) {
                String[] datos = filescn.nextLine().split(" ");
                for (String dato : datos) {
                    try {
                        if (operacion == 1) {
                            suma += Double.parseDouble(dato);
                        } else {
                            multiplicacion *= Double.parseDouble(dato);
                        }
                    } catch (NumberFormatException ignored) {}
                }
            }
            if (operacion == 1) {
                System.out.print("El resultado de la suma es ");
                Punto2.imprimirDecimales(suma);
            } else {
                System.out.print("El resultado de la multiplicacion es ");
                Punto2.imprimirDecimales(multiplicacion);
            }
            filescn.close();
        } catch (FileNotFoundException e1) {
            System.out.println("ERROR! Archivo de entrada no encontrado.");
        }
    }
}
