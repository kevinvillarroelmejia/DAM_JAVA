package examen1_empresaSoftware;

abstract class Empleado {
	protected String nombre;
	protected String idCodigo;
	protected double salarioBase;
	
	protected static int contadorEmpleados=0;
	
	public Empleado(String nombre ,double salarioBase) {
		this.nombre=nombre;
		this.idCodigo=obtenerCodigo();
		this.salarioBase=salarioBase;
		contadorEmpleados++;
		System.out.printf("%s. Codigo %s\n",this.nombre,this.idCodigo);
	}
	
	public static String obtenerCodigo() {
		String codigo=String.valueOf(contadorEmpleados);
		for(int i=codigo.length();i<3;i++) {
			codigo="0"+codigo;
		}
		codigo="EMP-"+codigo;
		return codigo;
	}
	
	abstract void calcularSalario();
	
	
}
