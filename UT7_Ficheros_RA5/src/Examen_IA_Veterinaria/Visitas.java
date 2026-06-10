package Examen_IA_Veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class Visitas implements Serializable{
	private String nombreCliente;
	private String nombreMascota;
	private String especie;
	private double costeVisita;
	
	public String getEspecie() {
		return especie;
	}
	private ArrayList<Visitas> listaVisitas=new ArrayList<Visitas>();
	
	public  Visitas(String nombreCliente,String nombreMascota,String especie,double costeVisita) {
		this.nombreCliente=nombreCliente;
		this.nombreMascota=nombreMascota;
		this.especie=especie;
		this.costeVisita=costeVisita;
		listaVisitas.add(this);
	}
	@Override
	public String toString() {
		String linea="- "+this.nombreCliente+" llevo a "+this.nombreMascota;
		return linea;
	}
	
}
