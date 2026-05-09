package examen1_empresaSoftware;


public class Main {
	public static void main(String[] args) {
		
		Programador p1=new Programador("Ines Perado",1500, true, false);
		Programador p2=new Programador("Ricardo Borriquero", 1400, true, true);
		Programador p3 = new Programador("Germán Ivela", 1600.44, false, false);
		Programador p4 = new Programador("Benito Camelas", 1300.75, false, true);
		
		JefesProyecto jp1 = new JefesProyecto("Felipe Lotas", 2000.21);
		JefesProyecto jp2 = new JefesProyecto("Elena Nito Del Bosque", 1900);
		
		p1.calcularSalario();
		
	}
}
