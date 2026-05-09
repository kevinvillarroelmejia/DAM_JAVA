package examen1_empresaSoftware;

public class JefesProyecto extends Empleado{

	private int numProyectos=0;
	
	public JefesProyecto(String nombre, double salarioBase) {
		super(nombre, salarioBase);
		System.out.printf("Salario base: %.2f€\n ",this.salarioBase);
	}

	@Override
	void calcularSalario() {
//		numProyectos=+500+numProyectos;
		double extras=500*numProyectos;
		System.out.printf("El salario total: ");
	}
	public void incrementarProyecto() {
		numProyectos++;
	}
	public void decrementarProyecto() {
		numProyectos--;
	}
	

}
