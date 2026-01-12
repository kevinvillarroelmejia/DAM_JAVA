package entidadBancaria;

import java.util.ArrayList;

public class Banco {
	
	private String nombre;
	private String codigo;
	
	private static ArrayList<Sucursal> listaSucursales=new ArrayList<Sucursal>();
	
	public Banco(String nombre,String codigo) {
		this.nombre=nombre;
		this.codigo=codigo;
	}
	//metodo añadir sucursal al banco
	public void añadirSucursal(Sucursal s1) {
		listaSucursales.add(s1);
	}
	
	public void listarSucursales() {
		for(Sucursal sucu:listaSucursales) {
			System.out.println(sucu);
		}
	}
	
}
