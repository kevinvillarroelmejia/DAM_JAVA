package tinderGoya;

public class Mujer extends Persona{

	//mediante el atributo app utilizamos ayade para meterlo en una lista
	public Mujer(Tinder app,String nombre, String fechaNacimiento, int busca) {
		super(nombre, fechaNacimiento, busca);
		app.ayade(this);
	}
	
	
	public Mujer(Tinder app,String nombre, String fechaNacimiento, int busca, int edadMaximaBuscada, int edadMinimaBuscada) {
		super(nombre, fechaNacimiento, busca,edadMinimaBuscada,edadMaximaBuscada);
		app.ayade(this);
	}

}
