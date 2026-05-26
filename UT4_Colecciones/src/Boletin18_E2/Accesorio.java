package Boletin18_E2;

public class Accesorio {
	
	private String nombreAccesorio;
	private int valor;
	
	
	public Accesorio(String nombreAccesorio,int valor) {
		this.nombreAccesorio=nombreAccesorio;
		this.valor=valor;
	}


	public String getNombreAccesorio() {
		return nombreAccesorio;
	}
	
	@Override
	public String toString() {
		return "Nombre Accesorio: "+this.nombreAccesorio+"\nValor: "+this.valor;
	}
	

}
