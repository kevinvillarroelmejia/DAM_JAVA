package poo;

public class Medico extends persona{
	private String Especialidad;
	private String numColegiado;
	
	
	
	public Medico(CentroMedico centroMedico,String nombre,String apellido,String Especialidad,String numeroColegiado) {
		super(centroMedico,nombre,apellido);
		this.Especialidad=Especialidad;
		this.numColegiado=numeroColegiado;
		this.centroMedico.ayadeMedico(this);//añadiendo centro cada vez que creemos un Medico
	}

	//FUNCION que permita cambiar aun medico de centro medico
	public void cambiaCentro(CentroMedico c) {
		this.centroMedico.eliminarMedico(this);//elimino el viejo
		this.centroMedico=c;//cambio el viejo por el nuevo
		this.centroMedico.ayadeMedico(this);//añado el nuevo
	}
	
	
	

}
