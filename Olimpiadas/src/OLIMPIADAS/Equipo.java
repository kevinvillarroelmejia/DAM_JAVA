package OLIMPIADAS;

import java.util.HashSet;

public class Equipo {
	private String nacionalidad;
	private DeporteEquipos deporte;

	private HashSet<Participante> listaParticipantes = new HashSet<Participante>();

	public Equipo(String nacionalidad, DeporteEquipos deporte) {
		this.nacionalidad = nacionalidad;
		this.deporte = deporte;
	}
	//comparar la nacionalidad y añadir
	public void ayadeParticipante(Participante p1) {
		if(p1.getNacionalidad().equals(this.nacionalidad)==false) {
			System.out.printf("El jugador %s en el equipo de %s de %s no puede entrar porque su nacionalidad es %s\n"
					,p1.getNombre(),deporte.getNombreDeporte(),this.nacionalidad,p1.getNacionalidad());
			}else {
				System.out.println("Participante añadido");

			listaParticipantes.add(p1);
		}

	}

}
