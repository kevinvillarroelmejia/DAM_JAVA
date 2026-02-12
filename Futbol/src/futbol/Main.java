package futbol;

import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Competicion laLiga = new Competicion("La Liga eaSports");
		Equipo elMadrid = new Equipo("Raal Madrid FC");
		Equipo barça = new Equipo("Barca Fc");
		Equipo betis = new Equipo("Batis FC");
		Equipo atleti = new Equipo("Atleti");
		Equipo rayo = new Equipo("Rayo");
		Equipo sevilla = new Equipo("Sevilla");

		HashSet<Equipo> listaEquiposMain = new HashSet<>(List.of(elMadrid, atleti, barça, betis, rayo, sevilla));

		laLiga.ayadeEquipo(elMadrid);
		laLiga.ayadeEquipo(barça);
		laLiga.ayadeEquipo(betis);
		laLiga.ayadeEquipo(atleti);
		laLiga.ayadeEquipo(rayo);
		laLiga.ayadeEquipo(sevilla);

		Jugador jugador1 = new Jugador("Messi", 10, barça);
		Jugador jugador2 = new Jugador("Cristiano");

		Entrenador entrenador1 = new Entrenador("Simeone", elMadrid);

		Arbitro arbitro1 = new Arbitro("Alexandru");
		Arbitro arbitro2 = new Arbitro("Andrea");

		Jornada j1 = new Jornada(laLiga);
		//terminar funciones
		j1.resultadosPartidos(1, 0, 3);// numero de partido //golesEquipo1 // golesEquipo2
		j1.resultadosPartidos(2, 5, 0);
		j1.resultadosPartidos(3, 2, 2);

		Partido p1 = new Partido(rayo, sevilla);
		Partido p2 = new Partido(elMadrid, atleti);
		Partido p3 = new Partido(elMadrid, betis);

		p1.resultadoPartido(0, 3);
		p2.resultadoPartido(5, 0);
		p3.resultadoPartido(2, 2);

		laLiga.verClasificacion();
	}
}
