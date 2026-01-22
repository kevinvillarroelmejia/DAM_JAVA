package inventarioDeJuegos;

import java.util.HashSet;
public class personaje {
	private String nombre;
	private  HashSet<accesorios> inventarioAccesorios;

	//Personaje creado directamente con accesorio

//	public personaje(String nombre,accesorios accesorio) {
//		this.nombre=nombre;
//		this.inventarioAccesorios.add(accesorio);
//	}
	//Personaje creado SIN accesorio
	public personaje(String nombre) {
		this.nombre=nombre;
	}
	public void añadirObjetoInventario(accesorios a){
		if(this.inventarioAccesorios.contains(a)||this.inventarioAccesorios.size()>=10) {
			System.out.println("ERROR-accesorio encontrado-inventario lleno");
		}else {
			this.inventarioAccesorios.add(a);
		}
		
	}
	
}
