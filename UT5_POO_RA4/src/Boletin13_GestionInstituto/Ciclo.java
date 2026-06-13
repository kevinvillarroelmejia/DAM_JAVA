package Boletin13_GestionInstituto;

import java.util.ArrayList;

public class Ciclo {
	private String nombre;
	private String tipoCiclo; //medio o superior
	public  ArrayList<Modulo> modulosImpartidos=new ArrayList<Modulo>();
	
	public Ciclo(String nombre,String tipoCiclo) {
		this.nombre=nombre;
		this.tipoCiclo=tipoCiclo;
	}
	@Override
	public String toString() {
		String linea = "";
		linea="Nombre Ciclo: "+this.nombre+"\n"+"Tipo ciclo: "+this.tipoCiclo;
		for(Modulo modulos:modulosImpartidos) {
			linea=linea+modulos+"\n";
		}
		return linea;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void ayadirModulo(Modulo modulo) {
		modulosImpartidos.add(modulo);
	}
	
}
