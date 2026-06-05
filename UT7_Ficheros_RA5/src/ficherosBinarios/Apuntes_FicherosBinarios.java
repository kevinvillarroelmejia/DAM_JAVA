package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Apuntes_FicherosBinarios {

	// ESCRITURA - DataOutputStream (output = datos salen de ti al fichero)
	// Usamos un método distinto por cada tipo de dato
	public static void escribirFichero(String fichero) {
		try (DataOutputStream binario = new DataOutputStream(new FileOutputStream(fichero))) {
			binario.writeInt(42);
			binario.writeDouble(3.14159);
			binario.writeBoolean(true);
			binario.writeUTF("Hola Mundo");
			binario.writeChar('A');
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	// LECTURA - DataInputStream (input = datos vienen del fichero a ti)
	// HAY QUE LEER EN EL MISMO ORDEN Y TIPOS QUE SE ESCRIBIERON
	public static void leerFichero(String fichero) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(fichero))) {
			int entero = binario.readInt();
			double decimal = binario.readDouble();
			boolean bool = binario.readBoolean();
			String texto = binario.readUTF();
			char caracter = binario.readChar();

			System.out.println("Entero: " + entero);
			System.out.println("Double: " + decimal);
			System.out.println("Booleano: " + bool);
			System.out.println("String: " + texto);
			System.out.println("Char: " + caracter);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}