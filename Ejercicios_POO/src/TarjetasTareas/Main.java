package TarjetasTareas;

public class Main {

	public static void main(String[] args) {
	
		//creando objeto tarea
		Tarea t1= new Tarea("Aprender JAVA", "Estudiar POO para aprobar", "verde");
		Tarea t2= new Tarea("Stranger Things", "Ver la ultima temporada", "rojo");
		
		//t1.mostrarTarea();

		t2.tareaCompletado();

		Tarea.mostrarTareasNoCompletadas();//metodo estatico
		
	}
}
