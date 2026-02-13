package tinderGoya;

public class Hombre extends Persona{

	
	public Hombre(String nombre, String fechaNacimiento, int busca) {
		super(nombre, fechaNacimiento, busca);
		
	}
	
	
	public Hombre(String nombre, String fechaNacimiento, int busca, int edadMaximaBuscada, int edadMinimaBuscada) {
		super(nombre, fechaNacimiento, busca,edadMinimaBuscada,edadMaximaBuscada);
		
	}

}
