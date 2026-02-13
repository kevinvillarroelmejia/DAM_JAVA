package tinderGoya;

public class NoDefinido extends Persona{

	
	public NoDefinido(String nombre, String fechaNacimiento, int busca) {
		super(nombre, fechaNacimiento, busca);
		
	}
	
	public NoDefinido(String nombre, String fechaNacimiento, int busca, int edadMaximaBuscada, int edadMinimaBuscada) {
		super(nombre, fechaNacimiento, busca,edadMinimaBuscada,edadMaximaBuscada);
	}

}
