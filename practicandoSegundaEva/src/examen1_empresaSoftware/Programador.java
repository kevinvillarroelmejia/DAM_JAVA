package examen1_empresaSoftware;

public class Programador extends Empleado{
	

	private boolean sabeJava;
	private boolean sabePython;
	
	public Programador(String nombre, double salarioBase, boolean sabeJava,boolean sabePython) {
		super(nombre, salarioBase);
		this.sabeJava=sabeJava;
		this.sabePython=sabePython;
		System.out.print("Lenguajes de programacion: ");
		if(sabeJava==false &&sabePython==false) {
			System.out.println("NINGUNO");
		}else {
			if(sabeJava) {
				System.out.printf("Java\n");
			}
			if (sabePython) {
				System.out.printf("Python\n");
			}
		}
		System.out.println("==============================================");
	}

	@Override
	void calcularSalario() {
		double extras=0;
		if (sabeJava) {
			extras+=200;
		}
		if(sabePython) {
			extras+=200;
		}
		System.out.printf("El salario total de %s con codigo %s es de %.2f€\n",this.nombre,this.idCodigo,this.salarioBase+extras);
	}
	
}
