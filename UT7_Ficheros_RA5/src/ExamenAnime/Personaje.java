package ExamenAnime;

import java.io.Serializable;

public class Personaje implements Serializable{
//	static String rutaFicheroBat="personajes.bat";
	
	private String tituloAnime;
	private String nombrePersonaje;
	
	public Personaje(String titulo,String nombrePersonaje) {
		this.tituloAnime=titulo;
		this.nombrePersonaje=nombrePersonaje;
	}
	
	@Override
	public String toString() {
		String linea=this.nombrePersonaje+"("+this.tituloAnime+")";
		return linea;
	}
	
	
}
