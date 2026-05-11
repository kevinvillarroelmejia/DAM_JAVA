package boletin27;

public class Pokemon implements Comparable<Pokemon>{
	
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
		this.tipos[1]=null;
	}
	//CONTRUCTOR PARA POKEMON CON TOS TIPOS UTILIZANDO EL PRIMER CONSTRUCTOR
	public Pokemon(int codigo ,String nombre,float peso,float altura,String tipo1,String tipo2) {
		this(codigo,nombre,peso,altura,tipo1);
		this.tipos[1]=tipo2;
	}
	
	@Override
	public String toString() {
		String linea="";
		linea=this.nombre+"(#"+this.codigo+")\n"
				+ "Peso: "+this.peso+"\n"
				+ "Altura: "+this.altura+"\n"
				+ "tipo: "+this.tipos[0];
		System.err.println("===============");
		return linea;
	}
	
	@Override
	//UTILIZANDO EL compareTo para ordenar afabeticamente
	public int compareTo(Pokemon p) {
		int resultado=0;
//		if(this.nombre.compareTo(o.nombre)>0) {
//			resultado=1;
//		}else if(this.nombre.compareTo(o.nombre)<0){
//			resultado=-1;
//		}
//		return 0;
		return this.nombre.compareTo(p.nombre);
	}
	
	

}
