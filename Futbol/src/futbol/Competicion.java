package futbol;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	
	public void verClasificacion() {
		//CABECERA DE LA CLASIFICACION
		LocalDate fecha=LocalDate.now();
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String fechaHoy=fecha.format(formato);
		System.out.println("-----------------------------------------------------------------");
		System.out.println("--------COMPETICION: " +this.nombre +" Fecha: "+fechaHoy+"------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------");

		System.out.printf("%-25s | %3s | %2s | %2s | %2s | %2s | %3s | %3s\n "
				,"EQUIPO","PTS","PJ","PG","PE","PP","GF","GC");
		//ORDENAR LA LISTA DE QUIPOS
		
		//mostrar cada equipo de la lista
		for(Equipo e:listaEquipos) {
			int PJ=e.getPartidosGanados()+e.getPartidosPerdidos()+e.getPartidosEmpatados();
			System.out.printf("%-25s | %3d | %2d | %2d | %2d | %2d | %3d | %3d\n"
					,e.getNombre()
					,e.getPuntos()
					,PJ,e.getPartidosGanados()
					,e.getPartidosEmpatados()
					,e.getPartidosPerdidos()
					,e.getGolesAFavor()
					,e.getGolesEnContra());
		}
	}
	
	//algoritmo de ordenacion
	//goles a favor y goles en contra

}
