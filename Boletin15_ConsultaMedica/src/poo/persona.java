package poo;

abstract public class persona {
	
	protected String nombre;
	protected String apellidos;
	protected CentroMedico centroMedico;
	
	public persona(CentroMedico centroMedico,String nombre,String apellidos) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.centroMedico=centroMedico;
	}
	
	//FUCIONES COMPARTIDAS
	public String getNombre() {
		return this.nombre;
	}
	public String getApellidos() {
		return this.apellidos;
	}
	
	abstract public void cambiaCentro(CentroMedico c);
	
}
