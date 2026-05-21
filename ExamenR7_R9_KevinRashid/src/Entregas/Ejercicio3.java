package Entregas;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		CadenasString espacios=(a)->{
			String texto=a;

			String sinEspacio=texto.replace(" ", "");
			
			return sinEspacio;
		};
		System.out.println(espacios.cadenaInvertida("hola hola"));
		
		//perdi mucho tiempo 
		Guion guion=(a)->{
			String texto=a;
			for(int i=0;i<texto.length();i++) {
				texto=texto+texto.charAt(i);
				texto=texto+"-";
			}
			return texto;
		};
		System.out.println(guion.añadirGuion("hola"));
	}
	
	
	
}
