package boletin27;

public class Pokemon {
	
	private int codigo;
	private String nombre;
	private float peso;
	private float altura;
	private String[] tipos=new String[2];
	
	public Pokemon(int codigo ,String nombre,float peso,float altura,String tipo1 ) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.peso=peso;
		this.altura=altura;
		this.tipos[0]=tipo1;
	}
	public Pokemon(int codigo ,String nombre,float peso,float altura,String tipo1,String tipo2) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.peso=peso;
		this.altura=altura;
		this.tipos[0]=tipo1;
		this.tipos[1]=tipo2;
	}
	
	@Override
	public String toString() {
		String linea="";
		linea=this.nombre+"(#"+this.codigo+")\n"
				+ "Peso: "+this.peso+"\n"
				+ "Altura: "+this.altura;
		System.err.println("===============");
		return linea;
	}
	
	

}
