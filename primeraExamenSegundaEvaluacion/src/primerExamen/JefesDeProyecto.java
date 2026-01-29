package primerExamen;

import java.util.ArrayList;

public class JefesDeProyecto extends Empleados{

	private ArrayList<JefesDeProyecto> listaJefesProyecto=new ArrayList<JefesDeProyecto>();

	public JefesDeProyecto(String nombre, String codigo, double salarioBase) {
		super(nombre, codigo, salarioBase);
	}
	public void ayadirJefe(JefesDeProyecto jefe) {
		listaJefesProyecto.add(this);
	}
	public void eliminarJefe(Proyecto p) {
		listaJefesProyecto.remove(this);
	}


	

}
