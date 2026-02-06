package futbol;

import java.util.HashSet;

public class Competicion {
	private String nombre;
	private HashSet<Equipo> listaEquipos=new HashSet<Equipo>();
	
	public Competicion(String nombre) {
		this.nombre=nombre;
	}
	public void ayadeEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}
	public void ayadeEquipos(HashSet<Equipo> equipo) {
		listaEquipos.addAll(equipo);
	}
	
	public void mostrarEquipos() {
		for(Equipo equipo:listaEquipos) {
			System.out.println();
		}
	}


}
