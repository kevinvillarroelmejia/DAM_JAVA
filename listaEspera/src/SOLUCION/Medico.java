package SOLUCION;

public class Medico extends Persona {
	private int contadorCitas = 0;
	private Especialidad especialidad;

	public Medico(String nombre, Especialidad especialidad) {
		super(nombre);
		this.especialidad = especialidad;
		especialidad.aniadeMedico(this);
	}
	
	public int getContadorCitas() {
		return this.contadorCitas;
	}
	
	public void incrementaContadorCitas() {
		this.contadorCitas++;
	}
	
}
