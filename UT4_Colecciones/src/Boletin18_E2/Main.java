package Boletin18_E2;

public class Main {

	public static void main(String[] args) {
		
		Accesorio navaja = new Accesorio("navaja", 10);
		Accesorio escudo = new Accesorio("escudo", 50);
		Accesorio pocion = new Accesorio("pocion", 5);
		Accesorio arco = new Accesorio("arco", 30);
		Accesorio casco = new Accesorio("casco", 25);
		Accesorio anillo = new Accesorio("anillo", 100);
		Accesorio botas = new Accesorio("botas", 15);
		Accesorio capa = new Accesorio("capa", 20);
		Accesorio espada = new Accesorio("espada", 45);
		Accesorio amuleto = new Accesorio("amuleto", 60);
		Accesorio lanza = new Accesorio("lanza", 35);
		
		Personaje kevin=new Personaje("Kevin");
		
		kevin.ayadirObjeto(navaja);
		kevin.ayadirObjeto(escudo);
		kevin.ayadirObjeto(pocion);
		kevin.ayadirObjeto(arco);
		kevin.ayadirObjeto(casco);
		kevin.ayadirObjeto(anillo);
		kevin.ayadirObjeto(botas);
		kevin.ayadirObjeto(capa);
		kevin.ayadirObjeto(espada);
		kevin.ayadirObjeto(amuleto);
		kevin.ayadirObjeto(lanza);

		kevin.listarObjetosPersonaje();
	}
}
