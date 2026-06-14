package TareaFicheroBinario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import TareaFicheroBinario.Tarea.Prioridad;

public class Main {

	public static void main(String[] args) {
		Tarea t1 = new Tarea("barrer", Prioridad.alta, false);
		Tarea t2 = new Tarea("gym", Prioridad.media, true);
		Tarea t3 = new Tarea("comer", Prioridad.baja, false);

		ArrayList<Tarea> listaTareas = new ArrayList<Tarea>(List.of(t1, t2, t3));

		String fichero = "tareas.dat";
		escribirTarea(fichero, listaTareas);
		leerTareasIncompletas(fichero);
		
		System.out.println();
		marcarTarea(t3, listaTareas);
		escribirTarea(fichero, listaTareas);
		leerTareasIncompletas(fichero);

	}

	public static void escribirTarea(String fichero, ArrayList<Tarea> listaTareas) {
		try (ObjectOutputStream binario = new ObjectOutputStream(new FileOutputStream(fichero))) {
			binario.writeObject(listaTareas);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void leerTareasIncompletas(String fichero) {
		try (ObjectInputStream binario = new ObjectInputStream(new FileInputStream(fichero))) {
			//COMO HE GUARDADO UNA LISTA RECUPERO UNA LISTA
			ArrayList<Tarea> listaTarea=(ArrayList<Tarea>)binario.readObject();
			for(Tarea tarea:listaTarea) {
				if(tarea.isEstado()==false) {
					System.out.println(tarea);
				}
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
//			e.printStackTrace();
		}
	}
	
	public static void marcarTarea(Tarea tarea,ArrayList<Tarea> listaTareas) {
		for(Tarea elemento:listaTareas) {
			if(elemento==tarea) {
				elemento.setEstado(true);
			}
		}
	}

}
