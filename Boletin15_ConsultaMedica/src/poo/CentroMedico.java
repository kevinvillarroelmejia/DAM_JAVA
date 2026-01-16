package poo;

import java.util.ArrayList;

public class CentroMedico {
	private String nombre;
	private String codigo;
	
	
	private ArrayList<Medico> medicosCentro=new ArrayList<Medico>();
	private ArrayList<Paciente> pacientesCentro=new ArrayList<Paciente>();
	private ArrayList<Consulta> consultas=new ArrayList<Consulta>();
	
	public CentroMedico(String nombre,String codigo) {
		this.nombre=nombre;
		this.codigo=codigo;
	}
	
	//AÑADIR MEDICO
	public void ayadeMedico(Medico m) {
		medicosCentro.add(m);
	}
	//AÑADIR PACIENTE
	public void ayadePaciente(Paciente p) {
		pacientesCentro.add(p);
	}
	//ELIMINAR MEDICO
	public void eliminarMedico(Medico m) {
		medicosCentro.remove(m);
	}
	//ELIMINAR PACIENTE
	public void eliminarPaciente(Paciente p) {
		medicosCentro.remove(p);
	}
	public void ayadeConsulta(Consulta c) {
		consultas.add(c);
	}
	//Listar los medicos de un centro
	public void listaMedicos() {
		for(Medico m:medicosCentro) {
			//utilizando funcion hecha en una clase abstracta
			System.out.println(m.getNombre()+" "+m.getApellidos());
		}
	}
	
	//Listar los pacientes de un centro
	public void listaPacientes() {
		for(Paciente p:pacientesCentro) {
			//utilizando funcion COMPARTIDA hecha en una clase abstracta
			System.out.println(p.getNombre()+" "+p.getApellidos());
		}
	}
	

	//Listar TODAS las consultas que ha realizado un paciente
	
	//Listar TODAS las consultas que ha intervenido un medico
	 
	//Listas las consultas en las que ha intervenido un medico con un determinado paciente
}
