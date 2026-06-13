package ExamenOrdinaria;

public class E1_Ingredientes {
	
	private String nombreIngrediente;
	private int cantidad;
	private String medida;
	
	public E1_Ingredientes(String nombreIngrediente,int cantidad,String medida) {
		this.nombreIngrediente=nombreIngrediente;
		this.cantidad=cantidad;
		this.medida=medida;
	}
	public E1_Ingredientes(String nombre) {
		this.nombreIngrediente=nombre;
	}
	@Override
	public String toString() {
		String linea;
//		String linea=this.nombreIngrediente+": "+this.cantidad+" "+this.medida;
		if(this.cantidad!=0||this.medida!=null) {
		linea=this.nombreIngrediente+": "+this.cantidad+" "+this.medida;
		}else {
			linea=this.nombreIngrediente;
		}
		return linea;
	}
}
