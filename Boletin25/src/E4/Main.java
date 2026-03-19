package E4;

public class Main {

	public static void main(String[] args) {
		
		String nombreFichero="tareas.txt";
		Tarea.leerFicheroTareas(nombreFichero);
		Tarea t1=new Tarea("E55", "Dar de comer a los peces", 8, false);
		Tarea t2=new Tarea("E56", "Sacar la basura", 1, true);
		
		Tarea.ordenarPorBurbuja(null);
		
		t1.mostrarTarea();
		t2.mostrarTarea();
		
		
	}
}
