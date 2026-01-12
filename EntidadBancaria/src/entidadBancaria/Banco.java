package entidadBancaria;

import java.util.ArrayList;

public class Banco {
	
	protected String nombre;
	private String codigo;
	
	private static ArrayList<Sucursal> listaSucursales=new ArrayList<Sucursal>();
	
	public Banco(String nombre,String codigo) {
		this.nombre=nombre;
		this.codigo=codigo;
	}
	//metodo añadir sucursal al banco
	public void añadirSucursal(Sucursal s) {
		listaSucursales.add(s);
	}
	
	public static void listarSucursales() {
		for(Sucursal sucu:listaSucursales) {
			sucu.sucursales();
		}
	}
	
}
