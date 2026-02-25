package solucionExamen;

public class Programador extends Empleado{
	
	boolean sabeJava;
	boolean sabePython;
	
	public Programador(String nombre, double salarioBase, boolean java, boolean python) {
		super(nombre, salarioBase);
		this.sabeJava = java;
		this.sabePython = python;
		
		System.out.printf("Lenguajes de Programación: ");
        if(this.sabeJava == false && this.sabePython == false) //si los dos son falsos...
        	System.out.printf("Ninguno");
        else {
        	if(this.sabeJava)//si sabe java es true...
        		System.out.printf("Java ");
        	if(this.sabePython)//si sabe python...
        		System.out.printf("Python");
        }
		System.out.printf(". Salario Base: %.2f\n", this.salarioBase);
		
	}
	
    public void calcularSueldo() {
    	double extras = 0;
    	if(this.sabeJava) //si java es truee se le añade 200  a las extras 
    		extras+=200;
    	if(this.sabePython)//si python es truee se le añade 200  a las extras 
    		extras+=200;
    	System.out.printf("El salario total de %s (%s) es de %.2f€\n", this.nombre, this.codigo, this.salarioBase+extras);
    }


}
