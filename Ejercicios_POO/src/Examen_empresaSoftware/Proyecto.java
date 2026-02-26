package Examen_empresaSoftware;

public class Proyecto {
	private String nombre;
	private String codigo;
	private JefeDeProyecto jefe;
	private int numEquipo = 0;
	private int siguientePuesto = 0;
	private Programador[] equipo = null;
	
    private static int contadorProyectos = 0;

	public Proyecto(String nombre, JefeDeProyecto jefe) {
        this.nombre = nombre;
        this.jefe = jefe;
        contadorProyectos++;
        this.codigo = obtenerCodigo();
        this.jefe.incrementaProyectos();
        System.out.printf("Proyecto: %s. %s. Jefe de Proyectos: %s\n", 
        		this.codigo, 
        		this.nombre, 
        		this.jefe.getNombre());
    }
	
	public Proyecto(String nombre, JefeDeProyecto jefe, int numEquipo) {
        this.nombre = nombre;
        this.jefe = jefe;
        this.numEquipo = numEquipo;
        this.equipo = new Programador[this.numEquipo];
        contadorProyectos++;
        this.codigo = obtenerCodigo();
        System.out.printf("Proyecto: %s. %s. Jefe de Proyectos: %s. Desarrolladores asignados: %d\n", 
        		this.codigo, 
        		this.nombre, 
        		this.jefe.getNombre(), 
        		this.numEquipo);
    }
	
    public static String obtenerCodigo() {
    	String codigo = String.valueOf(contadorProyectos);
        for(int i=codigo.length(); i<3; i++)
        	codigo = "0" + codigo;
        codigo = "PRO-" + codigo;
        return codigo;
    }
    
    public void cambiarJefe(JefeDeProyecto nuevoJefe) {
    	this.jefe.decrementaProyectos();
    	this.jefe = nuevoJefe;
    	this.jefe.incrementaProyectos();
    	System.out.printf("El Jefe del Proyecto %s ha cambiado. Ahora es %s\n", this.codigo, this.jefe.getNombre());
    }
    
    public void asignarEquipo(int numEquipo) {
    	if(this.equipo==null) {
    		this.numEquipo = numEquipo;
            this.equipo = new Programador[this.numEquipo];
    		System.out.printf("%d desarrolladores asignados al proyecto %s\n", this.numEquipo, this.codigo);
    	}
    	else
    		System.out.printf("Ya hay %d desarrolladores asignados al proyecto %s. Este dato no puede cambiarse\n", this.numEquipo, this.codigo);	
    }
    
    public void asignarDesarrollador(Programador p) {
    	if(this.equipo == null)
    		System.out.printf("No se puede asignar a %s al proyecto %s. No tiene aún definido el número de desarrolladores.\n", p.getNombre(), this.codigo);
    	else if(this.siguientePuesto == this.numEquipo)
    		System.out.printf("No se puede asignar a %s al proyecto %s. Máximo de desarrolladores cubierto.\n", p.getNombre(), this.codigo);
    	else {
    		this.equipo[siguientePuesto] = p;
    		this.siguientePuesto++;
    		System.out.printf("%s asignado al proyecto %s\n", p.getNombre(), this.codigo);
    	}
    }
    
    public void listarInfo() {
    	System.out.printf("Proyecto %s. %s\n", this.codigo, this.nombre);
    	System.out.printf("Jefe de proyectos: %s. %s\n", this.jefe.getCodigo(), this.jefe.getNombre());
    	System.out.printf("Desarrolladores asignados:\n");
    	for(Programador p:equipo) {
    		System.out.printf("%s. %s\n", p.getCodigo(), p.getNombre());
    	}
    }
	
}
