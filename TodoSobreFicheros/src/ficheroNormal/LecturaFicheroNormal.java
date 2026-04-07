package ficheroNormal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaFicheroNormal {

    public static void main(String[] args) {
        // ===FICHERO TEXTO===

        // ===FICHERO BINARIO===
        // Recurrimos a uno binario cuando el usuario no pueda acceder a el
        // Para darle persistencia a los objetos
        // OJO: los ficheros binarios SI se pueden modificar, solo que no son legibles por humanos

        // ~~~~~RECORIENDO FICHEROS~~~~~
        // TODO 5 METODOS DIFERENTES PARA LEER UN FICHERO

        // UN SALTO DE LINEA SE REPRESENTA CON UN \n

        // OBLIGATORIO USAR EXCEPCIONES
        // OBLIGATORIO CERRAR SIEMPRE EL FICHERO

        metodo0(); // do-while con FileReader + BufferedReader (el mas correcto logicamente)
        metodo1(); // while compacto con BufferedReader
        metodo2(); // Scanner
        metodo3(); // readAllLines -> ArrayList
        metodo4(); // readString -> String entero
    }


    // =====================================================================
    // METODO 0 - do-while con FileReader + BufferedReader
    // =====================================================================
    // FileReader     -> representa el fichero
    // BufferedReader -> el cursor que va leyendo linea a linea
    // do-while: el mas correcto logicamente porque con ficheros
    //           siempre vas a leer al menos una vez
    // readLine() devuelve null cuando llega al final del fichero
    // =====================================================================
    public static void metodo0() {
        try {
            FileReader fichero = new FileReader("/home/alumno/Escritorio/quijote.txt"); // ES EL PROPIO FICHERO
            BufferedReader lector = new BufferedReader(fichero); // LO TENEMOS QUE CERRAR
            String linea;
            do {
                linea = lector.readLine(); // lee una linea completa, devuelve null al final
                if (linea != null)
                    System.out.println(linea);
            } while (linea != null); // cuando lee null hemos terminado el fichero
            lector.close(); // cerramos y liberamos los recursos
        } catch (Exception e) {
            System.out.println("Error con el fichero");
            System.out.println(e.getMessage());
        }
    }


    // =====================================================================
    // METODO 1 - while compacto con BufferedReader
    // =====================================================================
    // Igual que metodo0 pero mas compacto
    // Los dos objetos se crean en una sola linea
    // La lectura y comprobacion van dentro del while -> mas limpio
    // =====================================================================
    public static void metodo1() {
        // SIEMPRE TENEMOS QUE TRABAJAR CON EXCEPCIONES
        try {
            // LEER EL FICHERO
            FileReader fichero = new FileReader("/home/alumno/Escritorio/quijote.txt"); // ES EL PROPIO FICHERO
            // También lo podemos usar asi (version compacta):
            // BufferedReader lector = new BufferedReader(new FileReader("/home/alumno/Escritorio/quijote.txt"));
            // El propio cursor para leer el fichero
            BufferedReader lector = new BufferedReader(fichero); // LO TENEMOS QUE CERRAR

            String linea;

            while ((linea = lector.readLine()) != null) { // COMPROBAMOS SI LECTOR ES DIFERENTE A NULL
                System.out.println(linea);
            }

            lector.close(); // cerramos y liberamos los recursos
        } catch (Exception e) {
            System.out.println("Error con el fichero");
            System.out.println(e.getMessage());
        }
    }


    // =====================================================================
    // METODO 2 - Scanner (ya lo conoces del teclado)
    // =====================================================================
    // File          -> representa el fichero (diferente a FileReader)
    // Scanner       -> el cursor, igual que cuando leemos del teclado
    // hasNextLine() -> devuelve true si queda alguna linea, false si no
    // nextLine()    -> lee la siguiente linea completa
    // =====================================================================
    // LEYENDO LINEA A LINEA
    public static void metodo2() {
        try {
            File fichero = new File("/home/alumno/Escritorio/quijote.txt");
            Scanner lector = new Scanner(fichero);
            String linea;
            // IMPRIMIR FICHERO ENTERO
            while (lector.hasNextLine()) { //boolean COMPRUEBA SI EXISTE UNA SIGUIENTE LINEA
                linea = lector.nextLine();
                System.out.println(linea);
            }
            lector.close(); // cerramos y liberamos los recursos
        } catch (Exception e) {
            System.out.println("Error con el fichero");
            System.out.println(e.getMessage());
        }
    }


    // =====================================================================
    // METODO 3 - readAllLines -> lee TODO de golpe -> ArrayList
    // =====================================================================
    // Path               -> objeto que simboliza el fichero
    // Files.readAllLines -> lee el fichero entero y lo cierra solo
    // Devuelve List<String>, hacemos cast a ArrayList<String>
    // Cada linea del fichero = una celda del ArrayList
    // Los \n se suprimen igual que en los metodos anteriores
    // =====================================================================
    private static void metodo3() {
        ArrayList<String> lineas = null;
        try {
            Path fichero = Path.of("/home/alumno/Escritorio/quijote.txt"); // objeto que simboliza el fichero
            // guarda CADA linea en una celda del ArrayList
            lineas = (ArrayList<String>) Files.readAllLines(fichero); // leo TODAS LAS LINEAS DEL FICHERO
        } catch (Exception e) {
            System.out.println("Error con el fichero");
            System.out.println(e.getMessage());
        }
        for (String linea : lineas) {
            System.out.println(linea);
        }
    }


    // =====================================================================
    // METODO 4 - readString -> lee TODO de golpe -> un String entero
    // =====================================================================
    // EN ESTE METODO SI QUE SALEN LOS \n
    // OJO: usar System.out.print, NO println
    //      el fichero ya tiene sus propios \n, println añadiria uno extra
    // =====================================================================
    private static void metodo4() {
        Path fichero = Path.of("/home/alumno/Escritorio/quijote.txt"); // lo mismo que el anterior
        String contenido = null;
        try {
            contenido = Files.readString(fichero);
        } catch (Exception e) {
            System.out.println("Error con el fichero");
            System.out.println(e.getMessage());
        }
        System.out.print(contenido); // OJO: print, NO println
    }


    // =====================================================================
    // RECORRIDOS ALTERNATIVOS (solo como referencia, no usar)
    // =====================================================================
    /*
     * RECORRIDO 1 - do-while (el mas correcto logicamente, ver metodo0)
     * do {
     *     linea = lector.readLine(); // lee la primera linea
     *     // cuando acaba de leer TODO el fichero devuelve null
     *     if (linea != null) {
     *         System.out.println(linea);
     *     }
     * } while (linea != null);
     */

    /*
     * RECORRIDO 2 - while con lectura previa fuera del bucle (menos elegante)
     * while (linea != null) {
     *     System.out.println(linea);
     *     linea = lector.readLine();
     * }
     */

}