package RA5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Ejercicio1_Paises {
    static String fichero = "D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\paises.csv";

    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            ArrayList<String> paises = new ArrayList<>();
            ArrayList<String> capitales = new ArrayList<>();
            ArrayList<String> monedas = new ArrayList<>();
            ArrayList<String> animales = new ArrayList<>();
                        
            lector.readLine(); // saltar cabecera
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] campos = linea.split(",");
                
               
                if (campos.length == 4) { // ignorar líneas erróneas
                    paises.add(campos[0]);
                    capitales.add(campos[1]);
                    monedas.add(campos[2]);
                    animales.add(campos[3]);
                }
            }
            lector.close();

            if (paises.size() == 0) {
                System.out.println("No hay datos de ningún país en el fichero");
            } else {
                System.out.println("Países en el fichero: " + paises.size());
                System.out.println("Nombres: " + formatear(paises));
                System.out.println("Las capitales de los mismos son: " + formatear(capitales));
                System.out.println("Sus monedas oficiales son: " + formatear(monedas));
                System.out.println("Sus animales mas representativos son " + formatear(animales));
            }
        } catch (Exception e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    public static String formatear(ArrayList<String> lista) {
        String resultado = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.size() - 1 && lista.size() > 1) {
                resultado += "y " + lista.get(i);
            } else if (i == lista.size() - 1) {
                resultado += lista.get(i);
            } else {
                resultado += lista.get(i) + ", ";
            }
        }
        return resultado;
    }
}