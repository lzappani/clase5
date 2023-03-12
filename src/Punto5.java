// Tome el ejercicio B de la clase 2 y que por parámetro se pueda elegir si es una codificación o
// decodificación, el valor del desplazo, y 2 archivos, uno para la entrada y otro para la salida. Que
// por pantalla (consola) solo indique si terminó o no correctamente, los resultados deben estar en el
// archivo de salida.

// Argumentos:
// char letra =  'c' par cifrar, 'd' para descifrar,
// int desplazo puede ser cualquier numero entero > 0
// String nombre del archivo de entrada en la carpeta files
// String nombre del archivo de salida en la carpeta files

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Punto5 {
    public static void main(String[] args) {
        try {
            char tipo = args[0].charAt(0);
            int desplazo = Integer.parseInt(args[1]);
            String pathEntrada = "./files/" + args[2];
            String pathSalida = "./files/" + args[3];
            try {
                File entrada = new File(pathEntrada);
                File salida = new File(pathSalida);
                if (salida.exists()) {
                    salida.delete();
                }
                Scanner filescn = new Scanner(entrada);
                try {
                    FileWriter escritorSalida = new FileWriter(pathSalida);
                    while (filescn.hasNextLine()) {
                        String linea = myCypher(filescn.nextLine().toLowerCase(), desplazo, tipo);
                        escritorSalida.write(linea + '\n');
                    }
                    escritorSalida.close();
                    System.out.println("Operacion Exitosa");
                } catch (IOException e3) {
                    System.out.println("Error!");
                }

            } catch (FileNotFoundException e2) {
                System.out.println("Archivo de entrada no encontrado.");
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Error en los argumentos.");
        }

    }



    static String myCypher(String aString, int desplazo, char tipo) {
        String dictionary = "abcdefghijklmnopqrstuvwxyz ";
        int cilindro = dictionary.length();
        if (tipo == 'd') {
            desplazo = cilindro - (desplazo % cilindro);
        } else {
            desplazo = desplazo % cilindro;
        }
        char[] result = new char[aString.length()];
        for (int i = 0; i < aString.length(); i++) {
            char letter = aString.charAt(i);
            int positionInDictionary = dictionary.indexOf(letter);
            int newPosition = (positionInDictionary + desplazo) % cilindro;
            result[i] = dictionary.charAt(newPosition);
        }
        return new String(result);
    }
}
