package tinderGoya;

public class Mujer extends Persona{

	public Mujer(String nombre, String fechaNacimiento, int busca) {
		super(nombre, fechaNacimiento, busca);
		
	}
	
	
	public Mujer(String nombre, String fechaNacimiento, int busca, int edadMaximaBuscada, int edadMinimaBuscada) {
		super(nombre, fechaNacimiento, busca,edadMinimaBuscada,edadMaximaBuscada);
		
	}

}
