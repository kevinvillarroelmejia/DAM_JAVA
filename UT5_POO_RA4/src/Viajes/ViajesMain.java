package Viajes;

import java.util.ArrayList;
import java.util.List;

public class ViajesMain {

	public static void main(String[] args) {

		Actividad actividad=new Actividad("Vuelo Madrid-Roma", 2, 175);
		Actividad actividad1=new Actividad("Hotel 4 coches", 1, 480);
		Actividad actividad2=new Actividad("Excursion coliseo", 4, 8.75);
		ArrayList<Actividad> listaActividad=new ArrayList<Actividad>(List.of(actividad1,actividad2));
		
		Presupuesto presupuesto=new Presupuesto("Maria Lopez");
		
		presupuesto.ayadirListaActividades(listaActividad);
		presupuesto.ayadirActividad(actividad);
		
		System.out.println(presupuesto);
	}
}
