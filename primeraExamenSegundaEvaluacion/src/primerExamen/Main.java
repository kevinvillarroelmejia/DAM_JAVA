package primerExamen;

public class Main {

	public static void main(String[] args) {
		
		JefesDeProyecto jefe1=new JefesDeProyecto("Jose", Empleados.generarCodigo(), 2999.99);
		JefesDeProyecto jefe2=new JefesDeProyecto("Kevin", Empleados.generarCodigo(), 1000.10);
		
		Programadores dev1=new Programadores("Antonio", Empleados.generarCodigo(), 2222.33);
		Programadores dev2=new Programadores("David", Empleados.generarCodigo(), 1111.20,"Java");
		Programadores dev3=new Programadores("Ruben", Empleados.generarCodigo(), 4221.20,"Java","Python");


		Proyecto proyecto1=new Proyecto("Proyecto Google", "Desarrollar Google", jefe1,Proyecto.generarCodigo());
		//con dos programadores
		Proyecto proyecto2=new Proyecto("API Android",Proyecto.generarCodigo(), "Desplejar la API para de Android", jefe1,2);
		
		dev1.infoPorgramadores();
		dev2.infoPorgramadores();
		dev3.infoPorgramadores();
		
		proyecto1.inforProyecto();
		proyecto2.inforProyecto();
		
		proyecto2.cambiarJefeDeProyecto(jefe2);
		proyecto2.inforProyecto();
		
	}


}
