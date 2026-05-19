package ejercicio2;

public class MainJuegosRol {

	public static void main(String[] args) {
			
		 Druida voldemor= new Druida("voldemor");
		 Sombra gollum=new Sombra("gollum");

		 System.out.println(voldemor.getNombre()+"--Daño golpe="+voldemor.golpear());
		 //System.out.println(voldemor.hechizo());
		 //System.out.println(gollum.movimiento());
		 
		 
		 System.out.println(voldemor.getNombre()+"-- Fuerza ="+voldemor.getFuerza());
		
		 System.out.println(gollum.getNombre()+" -- Daño hechizo="+gollum.hechizo());
	}
}




