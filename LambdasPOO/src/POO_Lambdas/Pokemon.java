package POO_Lambdas;

public class Pokemon implements Comparable<Pokemon>{
	private int codigo;
	private String nombre;
	private String[] tipo = new String[2];

	public Pokemon(int c, String n, String t) {
		this.codigo=c;
		this.nombre=n;
		this.tipo[0]=t;
		this.tipo[1]=null;
	}
	
	public Pokemon(int c, String n, String t,String t2) {
		this.codigo=c;
		this.nombre=n;
		this.tipo[0]=t;
		this.tipo[1]=t2;
	}
	
	@Override //decorador PARA VER QUE ESTAMOS SOBREESCRIBIENDO EL METODO toString
	//siempre devuelve String
	public String toString() {
		//lo devuelve el una unica linea
		String linea="(# "+ String.valueOf(this.codigo)+")"+this.nombre+"\n";
		if (tipo[1]==null) {
			linea+="Tipos "+this.tipo[0];
		}else {
			linea+="Tipos "+this.tipo[0]+" y "+this.tipo[1];
		}
		return linea;
	}
	
	@Override
	//le pasamos siempre un objeto generico
	//TODO COMPARAR CODIGOS POKEMON
	public boolean equals(Object otro) {
		boolean iguales=false;
		Pokemon comparado=(Pokemon)otro;
		if(this.codigo==comparado.codigo) {
			iguales=true;
		}
		return iguales;
	}
	
	@Override
	//Para que los objetos de tipo POkemon se puedan comparar en la clase le tenemos que poner
	//implements Comparable<Pokemon>
	public int compareTo(Pokemon otro) {
		int devolver=0;
		if(this.codigo>otro.codigo) {
			devolver=1;
		}else if(this.codigo<otro.codigo) {
			devolver=-1;
		}
		return devolver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}