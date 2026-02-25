package solucionExamen;

public class Main {
	public static void main(String[] args) {
		
		Programador p1 = new Programador("Ines Perado", 1500, true, false);
		Programador p2 = new Programador("Ricardo Borriquero", 1400, true, true);
		Programador p3 = new Programador("Germán Ivela", 1600.44, false, false);
		Programador p4 = new Programador("Benito Camelas", 1300.75, false, true);
		
		JefeDeProyecto jp1 = new JefeDeProyecto("Felipe Lotas", 2000.21);
		JefeDeProyecto jp2 = new JefeDeProyecto("Elena Nito Del Bosque", 1900);

		Proyecto pro1 = new Proyecto("Programa de contabilidad", jp1);
		Proyecto pro2 = new Proyecto("Programa de gestión de institutos", jp2, 2);
		Proyecto pro3 = new Proyecto("Programa de pruebas", jp1);
		
		pro2.cambiarJefe(jp1);
		pro1.asignarEquipo(3);
		pro2.asignarEquipo(3);
		
		pro2.asignarDesarrollador(p1);
		pro2.asignarDesarrollador(p2);
		pro2.asignarDesarrollador(p3);
		pro3.asignarDesarrollador(p4);
		
		pro2.listarInfo();
		
		p1.calcularSueldo();
		jp1.calcularSueldo();
		
	}
}
