package E4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

public class Tarea {
	private String identificador;
	private String titulo;
	private int prioridad;
	private boolean estadoTarea; // 1 o 0 para guardar el fichero

	private static ArrayList<Tarea> listaTarea = new ArrayList<Tarea>();

	// EJERCICIO 4 BOLETIN 25 - RECUPERAR TAREAS CON ESE FORMATO
	public Tarea(String identificador, String titulo, int prioridad, boolean estadoTarea) {
		this.identificador = identificador;
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.estadoTarea = estadoTarea;
		Tarea.listaTarea.add(this);
	}

	public static Tarea leerFicheroTareas(String fichero) {
		try(BufferedReader lector=new BufferedReader(new FileReader(fichero))) {
			String linea;
			while((linea=lector.readLine())!=null) {
				String[] lista=linea.split(":");
				boolean completado=false;
				if(lista[3].equals("1")) {
					completado=true;
				}
				new Tarea(lista[0],lista[1],Integer.parseInt(lista[2]),completado);
			}

		} catch (Exception e) {
			System.out.println("ERROR " + e.getMessage());
		}
		return null;
	}
	public void mostrarTarea() {
		String completada = "";
		if (this.estadoTarea == true) {
			completada = "X";
		}
		System.out.printf("%s [%s] %s (Prioridad: %d)\n", completada, this.identificador, this.titulo, this.prioridad);
	}
	public static void mostrarTareas() {
		for(Tarea tarea:listaTarea) {
			tarea.mostrarTarea();
		}
	}
	public void grabarFichero(String fichero) {
		try(PrintWriter pluma=new PrintWriter(fichero)){
			for(Tarea tarea:listaTarea) {
				int completado=0;
				if(tarea.estadoTarea==true) {
					completado=1;
				}
				pluma.printf("%s:%s:%d:%d", tarea.identificador,tarea.titulo,tarea.prioridad, completado);
				pluma.println();
			}
		}catch (Exception e) {
		}
	}
	
	//CORREGIR ESTO
	public static ArrayList<Tarea> ordenarPorPrioridad(ArrayList<Tarea> listaDesordenada) {
        ArrayList<Tarea> ordenada = new ArrayList<>();
        while (listaDesordenada.size() != 0) {
            Tarea tarea;
            for (Tarea n : listaDesordenada) {
                if (n. > pri) {
                    pri = n;
                }
            }
            listaDesordenada.remove((Integer) pri);
            ordenada.add(pri);
        }
        return ordenada;
	}
	
	// En este algorítmo de ordenación estamos devolviendo una nueva lista
    // En caso de que qusieramos consevar la lista original tendríamos que hacer una copia
    public static ArrayList<Integer> ordenarporSeleccion(ArrayList<Integer> desordenada) {
        ArrayList<Integer> ordenada = new ArrayList<>();
        while (desordenada.size() != 0) {
            int mayor = -1;
            for (int n : desordenada) {
                if (n > mayor) {
                    mayor = n;
                }
            }
            desordenada.remove((Integer) mayor);
            ordenada.add(mayor);
        }
        return ordenada;
    }

    // En este algorítmo de ordenación no estamos devolviendo una nueva lista sino que hacemos cambios sobre la que teníamos
    // En caso de que qusieramos consevar la lista original tendríamos que hacer una copia
    public static ArrayList<Integer> ordenarPorBurbuja(ArrayList<Integer> desordenada) {
        boolean hayCambios = true;
        while (hayCambios == true) {
            hayCambios = false;
            for (int i=0; i<desordenada.size()-1; i++) {
                // Con este syso sabemos que muestra los números por parejas
                // System.out.println(desordenada.get(i) + " - " + desordenada.get(i+1));
                if (desordenada.get(i+1) > desordenada.get(i)) {
                    int n = desordenada.remove(i);
                    desordenada.add(i+1,n);
                    hayCambios = true;
                }
            }
        }
        return desordenada;
    }
	
	

}
