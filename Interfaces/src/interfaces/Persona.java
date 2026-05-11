package interfaces;

//TODO esta clase heredara todo lo que tenga jubilada
public class Persona implements Jubilada{
	private String nombre;
	private String apellido;
	private int edad;
	
	public Persona(String nombre, String apellido, int e) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=e;
	}

	//SOBREESCRIBIENDO EL METODO
	@Override
	public void cuantoMeFalta() {
		
	}
	


}
