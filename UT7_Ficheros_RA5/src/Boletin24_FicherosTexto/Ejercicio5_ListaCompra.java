package Boletin24_FicherosTexto;

import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio5_ListaCompra {

	public static void main(String[] args) {
		String rutaFichero="D:\\IES FRANCISCO DE GOYA\\DAM\\PROGRAMACION\\compra.txt";
		escribirListaCompraFichero(rutaFichero);
	}
	public static void escribirListaCompraFichero(String rutaFichero) {
		// Para AÑADIR al final: segundo parámetro true
		try (FileWriter escritor = new FileWriter(rutaFichero)) {
//			escritor.write("\nEsta línea se añade al final.");
			String siNo = "";
			String nombreArticulo = "";
			double cantidad = 0;
			double precioUnidad = 0;
			Scanner teclado = new Scanner(System.in);
			String linea = "";
			int contadorArticulos = 0;
			double precioCompraTotal = 0;
			do {
				System.out.print("Introduce un articulo: ");
				nombreArticulo = teclado.nextLine();
				System.out.print("Introduce cantidad: ");
				cantidad = teclado.nextDouble();
				System.out.print("Introduce precio: ");
				precioUnidad = teclado.nextDouble();
				linea = cantidad + " " + nombreArticulo + "\n";
				escritor.write(linea);
				contadorArticulos++;
				precioCompraTotal=precioCompraTotal+(cantidad*precioUnidad);
				teclado.nextLine(); // si no podia esta linea antes me salia error null por que ??
				System.out.print("Quieres seguir introduciendo articulos en la lista (si/no): ");
				siNo = teclado.nextLine();
			} while (siNo.equalsIgnoreCase("si"));
			System.out.println("Tu lista de la compra se en encuentra en el fichero "+rutaFichero);
			escritor.write("Total de articulos en la lista: " + contadorArticulos+"\n");
			escritor.write("Precio de la compra "+precioCompraTotal);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
