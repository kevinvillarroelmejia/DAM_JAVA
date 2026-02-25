package ConsultaMedica;

import java.time.LocalDate;

public class Consulta {

	//con esta clase se refiere al acto de que el medico
	//vea a un paciente
	private LocalDate fechaConsulta;
	private String descripcion;
	private String consejoMedico;
	private Paciente paciente;
	private Medico medico;
	
	public Consulta(LocalDate fechaConsulta,Paciente paciente,Medico medico,String descripcion,String consejoMedico) {
		this.fechaConsulta=fechaConsulta;
		this.paciente=paciente;
		this.medico=medico;
		this.descripcion=descripcion;
		this.consejoMedico=consejoMedico;
		
		CentroMedico centro=this.medico.getCentro();
		centro.ayadeConsulta(this);
		this.medico.ayadeConsulta(this);
		this.paciente.ayadeConsulta(this);
	}
	
	public void mostrarConsulta() {
		System.out.println("--------------------------------------------------");
		System.out.println("Fecha de la consulta: "+this.fechaConsulta);
		System.out.println("Paciente: "+paciente.getNombre());
		System.out.println("Medico: "+medico.getNombre());
		System.out.println("Descripcion de la consulta: "+descripcion);
		System.out.println("Consejo del Medico: "+consejoMedico);
	}
	
}
