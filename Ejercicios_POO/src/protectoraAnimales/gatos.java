package protectoraAnimales;

public class gatos extends animales{
	private boolean vacunado;
	public gatos(int anyoNacimiento,String nombre,boolean vacunado) {
		super(anyoNacimiento,nombre);
		this.vacunado=vacunado;
	}
}
