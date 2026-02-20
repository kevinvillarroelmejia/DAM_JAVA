package OLIMPIADAS;

public class Main {

	public static void main(String[] args) {

		Participante p1 = new Participante("Boris", "Rusia");
		Participante p2 = new Participante("Svelanj", "Noruega");
		Participante p3 = new Participante("Manolo", "España");
		Participante p4=new Participante("Angel", "Filipinas");
		Participante p5 = new Participante("Dario", "Brasil");
		Participante p6=new Participante("Carlos", "Peru");
		
		DeporteIndividual d1 = new DeporteIndividual("SnowBoard");
		DeporteEquipos d2 = new DeporteEquipos("Curling");
		DeporteEquipos d3 = new DeporteEquipos("Hockey");

		Equipo e1 = new Equipo("Rusia", d2);
		Equipo e2 = new Equipo("España", d3);

		e1.ayadeParticipante(p1);
		e1.ayadeParticipante(p2);
		e2.ayadeParticipante(p3);
		
		d1.resultado(p1,45.4);
		d1.resultado(p2, 30.66);
		d1.resultado(p3, 99.9);
		d1.resultado(p4, 1.9);
		d1.resultado(p3, 103.1);//sobreEscribimos el anterior
		
		d1.resultado(p5, 103.1);//jugadores con valor repetido
		d1.resultado(p6, 99.9);
		
		d1.obtenerPodium();

	}
}
