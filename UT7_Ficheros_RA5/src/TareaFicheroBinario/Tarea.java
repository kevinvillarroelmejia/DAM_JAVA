package TareaFicheroBinario;

import java.io.Serializable;

public class Tarea implements Serializable {

	private String descripcion;
	private Prioridad prioridad;
	private boolean estado;

	public Tarea(String descripcion, Prioridad prioridad, boolean estado) {
		this.descripcion = descripcion;
		this.prioridad = prioridad;
		this.estado = estado;
	}

	@Override
	public String toString() {
		String linea="Descripcion: "+this.descripcion+"\nPrioridad: "+this.prioridad+"\nEstado: "+this.estado;
		return linea;
	}

	public enum Prioridad {
		alta, media, baja
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
