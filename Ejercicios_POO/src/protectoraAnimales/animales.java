package protectoraAnimales;

abstract class animales {

	protected int anyoNacimiento;
	protected String nombre=null;
	protected boolean adoptado=false;
	
	//DOS CONSTRUCTORES POR QUE EL NOMBRE ES OPCIONAL
	public animales(int anyoNacimineto, String nombre) {
		this.anyoNacimiento=anyoNacimineto;
		this.nombre=nombre;
	}
	public animales(int anyoNacimiento) {
		this.anyoNacimiento=anyoNacimiento;
	}
	public boolean getAdoptado(boolean adoptado) {
		return this.adoptado=true;
		
	}
}
