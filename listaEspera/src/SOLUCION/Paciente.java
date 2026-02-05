package SOLUCION;

import java.util.HashMap;
import java.util.Map;

public class Paciente extends Persona{
	/*AQUI*/
	private HashMap<String, Cita> listaCitas = new HashMap<>();
	
	public Paciente(String nombre) {
		super(nombre);
	}
	
	public void pideCita(Especialidad especialidad) { 
		// miramos en el diccionario asociado al paciente si ya tiene una cita de esa especialidad
		// es fácil, porque guardamos la cita en un diccionario donde la clave es la especialidad
		/*AQUI*/
		if(this.listaCitas.containsKey(especialidad.getNombre())) {
			Cita cita = listaCitas.get(especialidad.getNombre());
			System.out.println("\nEste paciente ya tiene una cita para la especialidad " 
					+ cita.getNombreMedico() + " con " + cita.getNombreMedico().getNombre() + " el dia "+cita.getFechaAsistirCita());
		}
		// si no tiene cita para esa especialidad consultamos si hay médicos para esa especialidad
		// si no hay, no podemos darle cita
		else if (especialidad.numMedicos() == 0)
			System.out.println("\nNo hay médicos de la especialidad " + especialidad.getNombre());
		else{
			// si hay médicos en la especialidad, vamos a ver a quién le asignamos la cita según las normas que hemos dado
			// eso lo calculamos con el método getMedico. Ver detalles allí
			Medico medico = especialidad.getMedico();
			medico.incrementaContadorCitas();
			Cita cita2=new Cita(medico);
			// y añadimos la cita al diccionario del paciente
			listaCitas.put(especialidad.getNombre(), cita2);
			System.out.println("Cita asignada para la especialidad de " + especialidad.getNombre() 
					+ " con " + medico.getNombre());
		}
	}

	public void anulaCita(Especialidad es) {
		if(this.listaCitas.containsKey(es.getNombre())) {
			//tiene cita pespecialiddad
			Cita cita=listaCitas.remove(es.getNombre());
			cita.getNombreMedico();
			System.out.println("Cita para el "+cita.getFechaAsistirCita()+" .CANCELADA");
		}else {
			System.out.println("\n No tiene cita con ningun medico de la especialidad");
		}
	}
	
}
