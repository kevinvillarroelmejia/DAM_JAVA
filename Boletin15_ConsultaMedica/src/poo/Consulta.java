package poo;

import java.time.LocalDate;

public class Consulta {

	//con esta clase se refiere al acto de que el medico
	//vea a un paciente
	private LocalDate fechaConsulta;
	private String descripcion;
	private String consejoMedico;
	private Paciente paciente;
	private Medico medico;
	private CentroMedico centroMedico;
	
	public Consulta(LocalDate fechaConsulta,Paciente paciente,Medico medico,String descripcion,String consejoMedico) {
		this.fechaConsulta=fechaConsulta;
		this.paciente=paciente;
		this.medico=medico;
		this.descripcion=descripcion;
		this.consejoMedico=consejoMedico;
		this.centroMedico.ayadeConsulta(this);
	}
}
