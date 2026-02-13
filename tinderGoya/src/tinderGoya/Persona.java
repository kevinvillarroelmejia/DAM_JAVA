package tinderGoya;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class Persona {
	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected int edadMaximaBuscada=200;
	protected int edadMinimaBuscada=18;//EDAD MINIMA PERMITIDA
	protected int queBusca;//0 BUSCA LO QUE SEA //1 BUSCA HOMBRE //2 BUSCA MUJER
	
	public Persona(String nombre,String fechaNacimiento,int busca) {
		this.nombre=nombre;
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.fechaNacimiento=LocalDate.parse(fechaNacimiento,formato);
		this.queBusca=busca;
	}
	
	public Persona(String nombre,String fechaNacimiento,int busca,int edadMinimaBuscada,int edadMaximaBuscada) {
		this(nombre,fechaNacimiento,busca); //todo lo que es comun lo podemos poner
		this.edadMaximaBuscada=edadMaximaBuscada;
		if(edadMinimaBuscada>18) {
			this.edadMinimaBuscada=edadMinimaBuscada;
		}
	}
	
}
