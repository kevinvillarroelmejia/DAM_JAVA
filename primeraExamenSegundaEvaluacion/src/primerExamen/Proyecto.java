package primerExamen;

import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private String definicionTexto;
	private JefesDeProyecto jefeDeProyecto;
	private int numMaxProgramadores;
	private String codigo;
	
	private ArrayList<Programadores> programadores=new ArrayList<Programadores>();
	private ArrayList<Proyecto> listaProyectos=new ArrayList<Proyecto>();
	//sin programadores
	public Proyecto(String nombre,String definicionTexto,JefesDeProyecto jefeDeProyecto,String codigo) {
		this.nombre=nombre;
		this.definicionTexto=definicionTexto;
		this.jefeDeProyecto=jefeDeProyecto;
		this.codigo=codigo;
		listaProyectos.add(this);
	}
	//proyecto con programadores
	public Proyecto(String nombre,String codigo ,String definicionTexto,JefesDeProyecto jefeDeProyecto,int numeroMaxProgramadores) {
		this.nombre=nombre;
		this.definicionTexto=definicionTexto;
		this.jefeDeProyecto=jefeDeProyecto;
		this.numMaxProgramadores=numeroMaxProgramadores;
		listaProyectos.add(this);
	}
	
	public void inforProyecto() {
		System.out.println("");
		System.out.println("Proyecto: "+this.codigo+". "+this.nombre);
		System.out.println("Jefe de proyecto: "+this.jefeDeProyecto.getNombre());
		if(numMaxProgramadores!=0) {
			System.out.print("Desarrollados asignados: "+this.numMaxProgramadores);
		}
		System.out.println("");
	}
	public void cambiarJefeDeProyecto(JefesDeProyecto jefe) {
		this.jefeDeProyecto.eliminarJefe(this);
		this.jefeDeProyecto=jefe;
		this.jefeDeProyecto.ayadirJefe(jefe);
	}
	public void ayadirProgramadorAlProyecto(Programadores p) {
			programadores.add(p);
	}
	public static String generarCodigo() {
		String codigo="EMP-";
		for(int i=0;i<3;i++) {
			int numeroI=i;
			String numeroITexto=String.valueOf(numeroI);
			codigo=codigo+numeroITexto;
		}
		return codigo;
	}
	
//	public cambiarJefeProyecto(JefesDeProyecto jefeDeProyecto) {
//		
//	}

}
