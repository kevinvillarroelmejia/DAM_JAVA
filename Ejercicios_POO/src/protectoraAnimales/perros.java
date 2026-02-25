package protectoraAnimales;

public class perros extends animales{
	private boolean vacunado=false;
	public perros(int anyoNacimiento,String nombre,boolean vacunado) {
		super(anyoNacimiento,nombre);
		this.vacunado=vacunado;
	}
}
