package entidadBancaria;

public class Clientes {
	
	private String Nombre;
	private String Apellidos;
	private String NIF;
	private int Telefono;
	private Sucursal Sucursal;
	
	//lista de clientes
	
	public Clientes(Sucursal sucursal,String nombre,String apellido,String nif,int telefono){
		this.Sucursal=sucursal;
		this.Nombre=nombre;
		this.Apellidos=apellido;
		this.NIF=nif;
		this.Telefono=telefono;
	}
	
	
}
