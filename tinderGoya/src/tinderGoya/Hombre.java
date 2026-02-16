package tinderGoya;

public class Hombre extends Persona{

	//app para ir metiendo los hombre a las lista de hombres
	public Hombre(Tinder app,String nombre, String fechaNacimiento, int busca) {
		super(nombre, fechaNacimiento, busca);
		app.ayade(this);//funcion que añade directamente a la lista
	}
	
	public Hombre(Tinder app,String nombre, String fechaNacimiento, int busca, int edadMaximaBuscada, int edadMinimaBuscada) {
		super(nombre, fechaNacimiento, busca,edadMinimaBuscada,edadMaximaBuscada);
		app.ayade(this);//funcion que añade directamente a la lista
	}

}
