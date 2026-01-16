package poo;

import java.util.ArrayList;

abstract public class persona {
	
	protected String nombre;
	protected String apellidos;
	protected CentroMedico centroMedico;
	protected ArrayList<Consulta> consultas=new ArrayList<Consulta>();

	
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
	public CentroMedico getCentro() {
		return this.centroMedico;
	}
	public void ayadeConsulta(Consulta c) {
		consultas.add(c);
	}
	//Listar las consultas que se han realizado en un centro
	public void listasConsultas() {
		for(Consulta c:consultas) {
			c.mostrarConsulta();
		}
	}
	
	abstract public void cambiaCentro(CentroMedico c);
	
}
