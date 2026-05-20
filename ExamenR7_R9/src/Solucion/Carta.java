package Solucion;

import java.util.ArrayList;
import java.util.Collections;

public class Carta implements Comparable<Carta> ,Ubicacion{
	private String nombre;
	private String tipo;
	private int coste;
	private String descripcion;
	private String ubicacion="Biblioteca";
	
	private static ArrayList<Carta> albumCartas=new ArrayList<Carta>();
	
	public Carta(String nombre,String tipo,int coste,String descripcion) {
		this.nombre=nombre;
		this.tipo=tipo;
		this.coste=coste;
		this.descripcion=descripcion;
		albumCartas.add(this);
	}
	
	@Override
	public String toString() {
		String linea="";
		linea="Nombre: "+this.nombre+"\n"
				+ "Tipo: "+this.tipo+"\n"
						+ "Coste: "+this.coste+"\n"
								+ "Descripcion: "+this.descripcion+"\n"
										+ "Ubicacion: "+this.ubicacion;
		return linea;
	}

	@Override
	public int compareTo(Carta carta) {
		return this.nombre.compareTo(carta.nombre);
	}
	
	public static void mostrarCartas() {
		//ordenamos e imprimimos
		Collections.sort(albumCartas);
		for(Carta carta: albumCartas) {
			System.out.println(carta);
			System.out.println("----------------------------");
		}
		
		
	}

	@Override
	public void cementerio() {
		this.ubicacion="Cementerio";
	}

	@Override
	public void biblioteca() {
		this.ubicacion="Biblioteca";
	}

	@Override
	public void mano() {
		this.ubicacion="Mano";
	}
}
