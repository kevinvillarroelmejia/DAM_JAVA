package tinderGoya;

import java.time.LocalDate;
import java.time.Period;
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

	public int getQueBusca() {
		return queBusca;
	}

	public void mostrarDatos() {
		System.out.printf("Nombre: %s. Edad %d\n",this.nombre,this.getEdad());
		//comparra los tipos
		if(this instanceof Hombre) {//el objeto es hombre?
			System.out.printf("Soy un hombre: ");
		}else if (this instanceof Mujer) { //el objeto es Mujer?
			System.out.printf("Soy una Mujer: ");
		}else {
			System.out.println("No me indentifico con nada: ");
		}
		//segun lo que busca
		if(this.queBusca==0) {
			System.out.println("Busco lo que sea");
		}else if(this.queBusca==1) {
			System.out.println("Busco un hombre");
		}else {
			System.out.println("Busco una mujer");
		}
		
		
		//preferencia de edad
		if(this.edadMinimaBuscada==18 &&this.edadMaximaBuscada==200) {
			System.out.println("No tengo preferencias en cuanto a tu edad");
		}else {
			System.out.printf("Busco a una persona entre %d y %d años\n",this.edadMinimaBuscada,this.edadMaximaBuscada);
		}
	}
	//para saber la edad de la persona
	public int getEdad() {
		LocalDate hoy=LocalDate.now();
		//tiempo entre dos fechas
		Period periodo=Period.between(this.fechaNacimiento,hoy);
		return periodo.getYears();
	}
	//instanceOF 
	
	
}
