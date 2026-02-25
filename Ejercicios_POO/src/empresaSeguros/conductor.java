package empresaSeguros;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class conductor {
	private String nif;
	private int pCarnet;
	private int añoNacimiento;
	private int añoCarnet;
	
	public conductor(String nif,int pCarnet, int añoNacimiento,int añoCarnet) {
		this.nif=nif;
		this.pCarnet=pCarnet;
		this.añoNacimiento=añoNacimiento;
		this.añoCarnet=añoCarnet;
	}
	
	//CALCULANDO LA EDAD SEGUN SOLO EL AÑO
	public int edad() {
		int nacimiento=this.añoNacimiento;//almacenamos el año segun
		LocalDate hoy=LocalDate.now();		
		DateTimeFormatter formato1= DateTimeFormatter.ofPattern("yyyy");
		String fechaConFormato=hoy.format(formato1);
		int convertido=Integer.parseInt(fechaConFormato);
		int edad=convertido-nacimiento;
		return edad;
	}
	
	//ANTIGUEDAD DEL CONDUCTOR
	public int antiguedad() {
		int antiguedad=0;
		LocalDate hoy=LocalDate.now();		
		DateTimeFormatter formato1= DateTimeFormatter.ofPattern("yyyy");
		String fechaConFormato=hoy.format(formato1);
		
		int convertido=Integer.parseInt(fechaConFormato);
		antiguedad=convertido-this.añoCarnet;
		return antiguedad;
	}
	
	public int getPuntosCarnet() {
		return pCarnet;
	}
	public void setPuntosCarnet(int pCarnet) {
		this.pCarnet = pCarnet;
	}

	//FUNCION SEGURO A TODO RIESGO
	/*SI TIENE 1 AÑO PAGA 400
	 * SI TIENE 2 AÑOS PAGA 550
	 * SI TIENE 3 AÑOS PAGA 750
	 * A APARTIR DEL 250 POR AÑO
	 * 
	 * +100€ SI TIENE MENOS DE 8 PUNTOS
	 * +50 SI TIENE MENOS DE 24 AÑOS*/
	public int seguroTodoRiesgo() {
		int importeTotal=0;
		if (antiguedad()<=1) {
			importeTotal=400;
		}else if(antiguedad()==2) {
			importeTotal=550;
		}else if(antiguedad()==3) {
			importeTotal=importeTotal+750;
		}else {
			importeTotal=250*(antiguedad()-3);
		}
		//SI TIENE MENOS DE 8 PUNTOS SE LE SUMAN 100€
		if(this.pCarnet<8) {
			importeTotal=importeTotal+100;
		}
		//Utilizando la funcion edad--> segun el resultado se le sumaran 50€
		if(edad()<24) {
			importeTotal=importeTotal+50;
		}
		return importeTotal;
	}
	/*FUNCION SEGURO A TERCEROS
	 * 250€ FIJOS 
	 * +150 SI TIENE MENOS DE 8PUNTOS
	 * +50€ SI TIENE MENOS DE 24 AÑOS*/
	public int seguroTerceros()	{
		int importeTotal=200;
		if(getPuntosCarnet()<9) {
			importeTotal=importeTotal+250;
		}
		if(edad()<24) {
			importeTotal=importeTotal+100;
		}
		return importeTotal;
	}
	
	
	
	
	
}
