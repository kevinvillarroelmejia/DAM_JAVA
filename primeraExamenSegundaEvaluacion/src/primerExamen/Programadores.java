package primerExamen;

public class Programadores extends Empleados{
	private String java;
	private String python;
	
	//no sabe programar
	public Programadores(String nombre, String codigo, double salarioBase) {
		super(nombre, codigo, salarioBase);
	}
	//sabe programar en algun java
	public Programadores(String nombre, String codigo, double salarioBase,String java) {
		super(nombre, codigo, salarioBase);
		this.java=java;
	}
	//sabe programar en los dos
	public Programadores(String nombre, String codigo, double salarioBase,String python,String java) {
		super(nombre, codigo, salarioBase);
		this.python=python;
		this.java=java;
	}
	public void infoPorgramadores() {
		System.out.print(this.getNombre()+". ");
		System.out.print(this.codigo+". ");
		if(this.java!=null) {
			System.out.println("Lenguaje de programacion: "+this.java);
		}else if (this.java!=null && this.python!=null) {
			System.out.println("Lenguaje de programacion: "+this.java+" "+this.python);
		}
		else {
			System.out.println("Lenguaje de programacion: ninguno");
		}
		System.out.println("Salario Base: "+this.salarioBase);
		System.out.println();
	}
}
