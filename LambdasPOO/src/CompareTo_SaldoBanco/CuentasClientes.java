package CompareTo_SaldoBanco;


public class CuentasClientes implements Comparable<CuentasClientes>{
	
	private String nombre;
	private float saldo;
	
	public CuentasClientes(String nombre, float saldo) {
		this.nombre=nombre;
		this.saldo=saldo;
	}
	
	@Override 
	public String toString() {
		String linea="";
		linea="Nombre--> "+this.nombre+" Saldo--> "+this.saldo;
		return linea;
	}

	@Override
	public int compareTo(CuentasClientes otro) {
		int devolver=0;
		if(this.saldo>otro.saldo) {
			devolver=1;
		}else if(this.saldo<otro.saldo) {
			devolver=-1;
		}
		return devolver;
	}
	
	

}