package gestionFestival;

import java.time.LocalDateTime;

public class MAIN {

	public static void main(String[] args) {
		LocalDateTime fechaFiestasArganda = LocalDateTime.of(2026, 3, 20, 21, 0);
        LocalDateTime fechaFiestasRivas = LocalDateTime.of(2026, 2, 10, 22, 0);
        Concierto fiestasArganda = new Concierto("Fiestas Arganda", 2, fechaFiestasArganda);
        Concierto fiestasRivas = new Concierto("Fiestas Arganda", 2, fechaFiestasRivas);

        LocalDateTime fechaExpoFotografia = LocalDateTime.of(2026, 1, 30, 17, 30);
        LocalDateTime fechaExpoVideojuegos = LocalDateTime.of(2026, 2, 2, 18, 0);
        Exposicion expoFotografia = new Exposicion("Exposicion Fotografía", "Fotografía Arquitectónica", 10, fechaExpoFotografia);
        Exposicion expoVideojuegos = new Exposicion("Exposicion Videojuegos", "Videjuegos de los 2000", 20, fechaExpoVideojuegos);

        LocalDateTime fechaTallerPintura = LocalDateTime.of(2026, 4, 15, 17, 0);
        LocalDateTime fechaTallerCostura = LocalDateTime.of(2026, 5, 2, 14, 0);
        Taller tallerPintura = new Taller("Taller de pintura", "Pinceles, cuadros y pinturas", 5, fechaTallerPintura);
        Taller tallerCostura = new Taller("Taller de costura", "Maquina de coser, agujas e hilo", 8, fechaTallerCostura);

        Artista art1 = new Artista(1, "Billie Eilish");
        Artista art2 = new Artista(2, "Oli", "Olivia Rodrigo");
        Asistente asi1 = new Asistente(1,"Sara García Martín", "Sarita");
        Asistente asi2 = new Asistente(2,"Kevin Villaroel","KEvin");
        Asistente asi3 = new Asistente(3, "Sergio Serrano Arroyo");
        Asistente asi4 = new Asistente(4, "Alexandru Iacob");
        Asistente asi5 = new Asistente(5, "Jordan Daniel Zuñiga");
        
        fiestasArganda.ayadirArtistasConcierto(art1);
	}

}
