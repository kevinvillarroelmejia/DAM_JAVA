package primerExamen;

abstract class Empleados {
	protected String nombre;
	protected String codigo=generarCodigo();
	protected double salarioBase;
	
	public Empleados(String nombre, String codigo,double salarioBase) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.salarioBase=salarioBase;
	}
	public static String generarCodigo() {
		String codigo="EMP-";
		for(int i=0;i<3;i++) {
			int numeroI=i;
			String numeroITexto=String.valueOf(numeroI);
			codigo=codigo+numeroITexto;
		}
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	

}
