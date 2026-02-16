package tinderGoya;

public class NoDefinido extends Persona{

	
	public NoDefinido(Tinder app,String nombre, String fechaNacimiento, int busca) {
		super(nombre, fechaNacimiento, busca);
		app.ayade(this);
	}
	
	public NoDefinido(Tinder app,String nombre, String fechaNacimiento, int busca, int edadMaximaBuscada, int edadMinimaBuscada) {
		super(nombre, fechaNacimiento, busca,edadMinimaBuscada,edadMaximaBuscada);
		app.ayade(this);
	}

}
