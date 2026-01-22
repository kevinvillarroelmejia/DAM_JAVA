package inventarioDeJuegos;

import java.util.HashSet;

public class personaje {
	private String nombre;
	private static HashSet<accesorios> inventarioAccesorios;

	//Personaje creado directamente con accesorio

//	public personaje(String nombre,accesorios accesorio) {
//		this.nombre=nombre;
//		this.inventarioAccesorios.add(accesorio);
//	}
	//Personaje creado SIN accesorio
	public personaje(String nombre,HashSet<accesorios> accesorio) {
		this.nombre=nombre;
	}
	public static void añadirObjetoInventario(accesorios a){
		if(inventarioAccesorios.contains(a)||inventarioAccesorios.size()>=10) {
			System.out.println("ERROR-accesorio encontrado-inventario lleno");
		}else {
			inventarioAccesorios.add(a);
		}
		
	}
	
}
