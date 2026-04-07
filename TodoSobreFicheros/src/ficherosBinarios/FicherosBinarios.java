package ficherosBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FicherosBinarios {

	public static void main(String[] args) {
		/* FICHEROS BINARIOS */
		// Ocupan menos espacio
		// El acceso es mucho mas rapido
		// GRABAMOS EN BINARIO
		// TENEMOS QUE INDICAR EL TIPO DE DATOS QUE ESTAMOS GRABANDO TAMBIEN CUANDO
		// LEEMOS

		// La persistencia de objetos es mucho mejor con ficheros binarios

		// int 2 Bytes
		// double 4Bytes

		String fichero = "/home/alumno/binario.dat"; // puede ser .bin o .dat
		// escribirFicheroBinario(fichero);

		// TareaFicherosBinarios t1= new TareaFicherosBinarios("E34","Aprende a grabar
		// objetosd con java",9,false);
		/*
		 * grabarTarea(t1, fichero); leerFicherobinario(fichero);
		 * 
		 * TareaFicherosBinarios treRecuperada=leerTarea(fichero);
		 * if(treRecuperada!=null) { treRecuperada.mostrarTarea(); }
		 */
		TareaFicherosBinarios t1 = new TareaFicherosBinarios("E34", "Aprende a grabar objetosd con java", 9, false);
		TareaFicherosBinarios t2 = new TareaFicherosBinarios("X15", "COMPRAR COMIDA", 5, true);
		TareaFicherosBinarios t3 = new TareaFicherosBinarios("T44", "Limpiar los baños", 4, true);
		TareaFicherosBinarios t4 = new TareaFicherosBinarios("R56", "Quedar con los amigos", 7, true);
		ArrayList<TareaFicherosBinarios> listaTareas = new ArrayList<TareaFicherosBinarios>(List.of(t1, t2, t3, t4));

		grabarLista(listaTareas, fichero);
		ArrayList<TareaFicherosBinarios> listaRecuperada = leerListaTareas(fichero);
		TareaFicherosBinarios tnuevo = new TareaFicherosBinarios("V55", "Planificador", 10, false);
		listaRecuperada.add(tnuevo);

		grabarLista(listaRecuperada, fichero);

		for (TareaFicherosBinarios tarea : listaRecuperada) {
			tarea.mostrarTarea();
		}

//		leerFicherobinario(fichero);
	}

	public static TareaFicherosBinarios leerTarea(String fichero) {
		TareaFicherosBinarios tarea = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			tarea = (TareaFicherosBinarios) binario.readObject();
		} catch (Exception e) {
			e.getMessage();
		}
		return tarea;
	}

	public static ArrayList<TareaFicherosBinarios> leerListaTareas(String fichero) {
		ArrayList<TareaFicherosBinarios> lista = null;
		TareaFicherosBinarios tarea = null;
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			lista = (ArrayList<TareaFicherosBinarios>) binario.readObject();
		} catch (Exception e) {
			e.getMessage();
		}
		return lista;
	}

	public static void grabarLista(ArrayList<TareaFicherosBinarios> listaTareas, String fichero) {
		// ObjectOutputStream permite grabar objetos en el fichero
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
			binario.writeObject(listaTareas);// writeObject te graba el fichero
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// TODO LEYENDO EL FICHERO BINARIO
	private static void leerFicherobinario(String fichero) {
		try (DataInputStream binario = new DataInputStream(new FileInputStream(fichero))) {
			// tenemos que leer en el MISMO ORDEN EN EL QUE ESCRIBIMOS EL FICHERO
			System.out.println(binario.readInt());
			System.out.println(binario.readDouble());
			System.out.println(binario.readBoolean());
			System.out.println(binario.readChar());
			System.out.println(binario.readUTF());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void escribirFicheroBinario(String fichero) {
		// ESTO ABRE UN FICHERO PARA ESCRITURA
		// OUTPUT CUANDO NOSOTROS ESCRIBIMOS
		// INPUT CUANDO NOSOTROS LEEMOS
		try (DataOutputStream binario = new DataOutputStream(new FileOutputStream(fichero))) {
			binario.writeInt(3456);
			binario.writeDouble(3.1415);
			binario.writeBoolean(false);
			binario.writeChar('X');
			binario.writeUTF("hola mundo binario");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
