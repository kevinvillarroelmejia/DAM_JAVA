package RA8_Serializacion;

import java.io.Serializable;

public class Cliente implements Serializable{
	private String nombre;
	private String suscripcion;
	private int mesesRestanteContrato;
	
	
	public Cliente(String nombre, String suscripcion, int mesesRestanteContrato) {
		this.nombre = nombre;
		this.suscripcion = suscripcion;
		this.mesesRestanteContrato = mesesRestanteContrato;
	}

	public enum Suscripcion{
		basico,premiun,elite
	}
	
	public String getNombre() {
		return nombre; 
	}

	@Override 
	public String toString() {
		String linea=this.nombre+" ("+this.suscripcion+") - "+this.mesesRestanteContrato;
		return linea;
	}

	public String getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(String suscripcion) {
		this.suscripcion = suscripcion;
	}

	public int getMesesRestanteContrato() {
		return mesesRestanteContrato;
	}
}
