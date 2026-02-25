package solucionExamen;

public class JefeDeProyecto extends Empleado{
	
	private int numProyectos = 0;

	public JefeDeProyecto(String nombre, double salarioBase) {
		super(nombre, salarioBase);
		System.out.printf("Salario Base: %.2f\n", this.salarioBase);
	}

    public void calcularSueldo() {
    	double extras = 500*numProyectos;
    	System.out.printf("El salario total de %s (%s) es de %.2f€\n", this.nombre, this.codigo, this.salarioBase+extras);
    }
    
    public void incrementaProyectos() {
    	this.numProyectos++;
    }
    
    public void decrementaProyectos() {
    	this.numProyectos--;
    }

}
