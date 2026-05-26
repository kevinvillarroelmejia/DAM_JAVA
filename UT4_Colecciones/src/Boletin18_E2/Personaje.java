package Boletin18_E2;

import java.util.ArrayList;

public class Personaje {
	
	private String nombrePersonaje;
	private ArrayList<Accesorio> listaAccesorios=new ArrayList<Accesorio>();
	
	public Personaje(String nombrePersonaje) {
		this.nombrePersonaje=nombrePersonaje;
	}
	
	public void ayadirObjeto(Accesorio accesorio) {
		if(existeAccesorio(accesorio.getNombreAccesorio())) {
			System.out.println("Error el accesorio ya existe en el inventario");
		}else if(listaAccesorios.size()==10) {
			System.out.println("Error NO se puede añadir el "+accesorio.getNombreAccesorio()+" iventario lleno");
		}else {
			this.listaAccesorios.add(accesorio);
		}
	}
	
	public boolean existeAccesorio(String nombre) {
		boolean bandera=false;
			for(Accesorio accesorio:listaAccesorios) {
				if(accesorio.getNombreAccesorio().equals(nombre)) {
					bandera=true;
				}
			}
		return bandera;
	}
	
	public void eliminarAccesorio(String nombreObjeto) {
		for(int i=0;i<listaAccesorios.size();i++) {
			if(listaAccesorios.get(i).getNombreAccesorio().equals(nombreObjeto)) {
				listaAccesorios.remove(i);
			}
		}
	}
	
	public void listarObjetosPersonaje() {
		for(Accesorio accesorio:listaAccesorios) {
			System.out.println(accesorio);
		}
	}


}
