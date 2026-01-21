package entidadBancaria;

import java.util.ArrayList;

public class Clientes {
	
	private String Nombre;
	private String Apellido;
	private String NIF;
	private int Telefono;
	private Sucursal Sucursal;
	
	ArrayList<CuentasCorrientes> cuentas =new ArrayList<CuentasCorrientes>();

	
	//lista de clientes
	public Clientes(Sucursal sucursal,String nombre,String apellido,String nif,int telefono){
		this.Sucursal=sucursal;
		this.Nombre=nombre;
		this.Apellido=apellido;
		this.NIF=nif;
		this.Telefono=telefono;
		//cada vez que creamos un cliente se añade direcctamente a sucursal
		this.Sucursal.ayadirClientes(this);
	}
	
	
	public void mostrarCliente() {
		System.out.println("Nombre: "+Nombre);
		System.out.println("Apellido: "+Apellido);
		System.out.println("NIF: "+NIF);
		System.out.println("Telefono: "+Telefono);
	}


	public String getNombre() {
		return Nombre;
	}

	public String getApellido() {
		return Apellido;
	}
	public void anydeCuenta(CuentasCorrientes c) {
		this.cuentas.add(c);
	}
	
	
	
}

