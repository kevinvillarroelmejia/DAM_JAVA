package entidadBancaria;

import java.util.ArrayList;

public class Sucursal {
	private Banco banco;
	private String calle;
	private int numero;
	private int codigoPostal;
	private String Ciudad;
	private String codigoSucursal;
	
	
	//lista de cuentas
	private static ArrayList<CuentasCorrientes> listaCuentas=new ArrayList<CuentasCorrientes>();
	
	//lista de clientes
	private static ArrayList<Clientes> listaClientes =new ArrayList<Clientes>();
	
	public Sucursal(Banco banco,String calle,int numero ,int codigoPostal,String Ciudad,String codigoSucursal) {
		this.banco=banco;
		this.calle=calle;
		this.numero=numero;
		this.codigoPostal=codigoPostal;
		this.Ciudad=Ciudad;
		this.codigoSucursal=codigoSucursal;
		
		//utilizando la funcion añadirSurcusal que esta en banco
		banco.añadirSucursal(this);
	}
	public void sucursales() {
		Banco banco;
		System.out.println("----------------");
		System.out.println("Banco: "+this.banco.nombre);
		System.out.println("Direccion: "+calle+","+numero+","+codigoPostal);
		System.out.println("Ciudad: "+Ciudad);
		System.out.println("Codigo surcursal: "+ codigoPostal);
	}
	//METODO AÑADIR CLIENTES
	public static void añadirClientes(Clientes c) {
		listaClientes.add(c);
	}
	
	//METODO LISTAR CLIENTES
	public static void listarClientes() {
		for(Clientes c:listaClientes) {
			c.mostrarCliente();
			System.out.println("----------------");
		}
	}
	
}
