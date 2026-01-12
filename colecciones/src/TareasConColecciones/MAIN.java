package TareasConColecciones;

public class MAIN {

	public static void main(String[] args) {
		
		//creando objeto tarea
				TareasTarjetas t1= new TareasTarjetas("Aprender JAVA", "Estudiar POO para aprobar", "verde");
				TareasTarjetas t2= new TareasTarjetas("Stranger Things", "Ver la ultima temporada", "rojo");
				
				//t1.mostrarTarea();

				t2.tareaCompletado();
				t1.eliminarTarea(); 
				//t1.eliminarTarea(); //da false por que t1 ya fue eliminado

				//TareasTarjetas.mostrarTareasNoCompletadas();//metodo estatico
				
				TareasTarjetas.mostrarTodaLaLista();
			
				
	}
}
