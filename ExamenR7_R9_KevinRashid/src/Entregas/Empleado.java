package Entregas;

import java.util.ArrayList;

public class Empleado implements Categoria ,Comparable<Empleado>{
	
	public static int contadorEmpleado=1;
	
	private String nombre;
	private double salarioMensual;
	private double bonoExtra;
	private int numeroEmpleado=contadorEmpleado;
	private static ArrayList<Empleado> listaEmpleados=new ArrayList<Empleado>();
	
	public Empleado(String nombre,double salarioMensual,double bonoExtra) {
		this.nombre=nombre;
		this.salarioMensual=salarioMensual;
		this.contadorEmpleado++;
		listaEmpleados.add(this);
	}

	public static ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	@Override
	public String categorizarEmpleadoPorsueldo() {
		String categoria="";
		if(this.salarioMensual<Categoria.fronteraJuniorSenior) {
			categoria="Junior";
		}else {
			categoria="Senior";
		}
		return categoria;
	}
	@Override
	public String toString() {
		double salarioBono=this.salarioMensual+this.bonoExtra;
		String linea ="Empleado numero "+this.numeroEmpleado+" "+this.nombre+"("+(categorizarEmpleadoPorsueldo()+")"
				+"\nSalario mensual: "+this.salarioMensual+"\n"+
				"Salario con bono: "+salarioBono+"\n");
		return linea;
	}
	@Override
	public int compareTo(Empleado empleado) {
		int mayor=0;
		//POR SALARIO
		if(this.salarioMensual<empleado.salarioMensual) {
			mayor=1;
		}else if(this.salarioMensual>empleado.salarioMensual) {
			mayor=-1;
			//SI SALARIO EMPATE
		}else {
			if(this.bonoExtra<empleado.bonoExtra) {
				mayor=1;
			}else if(this.bonoExtra>empleado.bonoExtra) {
				mayor=-1;
			}else {
				//SI BONO EMPATE
				if(this.numeroEmpleado>empleado.numeroEmpleado) {
					mayor=1;
				}else if(this.numeroEmpleado<empleado.numeroEmpleado) {
					mayor=-1;
				}
			}			
		}
		return mayor;
	}

	
}
