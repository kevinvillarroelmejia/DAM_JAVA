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

	@Override
	public void cambiaCentro(CentroMedico c) {
		// TODO Auto-generated method stub
		
	}
	
	//FUNCION que permita cambiar aun paciente de centro medico



}
