package poo;

public class Paciente extends persona{
	private String dni;
	private int telefono;
	
	public Paciente(CentroMedico centroMedico,String nombre,String apellido,String dni,int telefono) {
		super(centroMedico,nombre,apellido);
		this.dni=dni;
		this.telefono=telefono;
		this.centroMedico.ayadePaciente(this);
	}

	
	public void cambiaCentro(CentroMedico c) {
		this.centroMedico.eliminarPaciente(this);
		this.centroMedico=c;
		this.centroMedico.ayadePaciente(this);
	}
	
	//FUNCION que permita cambiar aun paciente de centro medico



}
