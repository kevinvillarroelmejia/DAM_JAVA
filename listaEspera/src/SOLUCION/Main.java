package SOLUCION;

public class Main {
	public static void main(String[] args) {
		Especialidad cardiologia = new Especialidad("Cardiología");
		Especialidad oftalmologia = new Especialidad("Oftalmología");
		Especialidad dermatologia = new Especialidad("Dermatología");
		Especialidad reanimacion = new Especialidad("Reanimación");
		
		Medico m1 = new Medico("Sergio Serrano Arroyo", cardiologia);
		Medico m2 = new Medico("Sara García Martín", oftalmologia);
		Medico m3 = new Medico("Gabriel Alexandru Iacob", reanimacion);
		Medico m4 = new Medico("Oscar", reanimacion);
		
		Paciente p1 = new Paciente("Jordan Daniel Zuñiga");
		Paciente p2 = new Paciente("Mario Cristian Carcalete");
		Paciente p3 = new Paciente("Kevin Rashid");
		Paciente p4 = new Paciente("Jose María");
				
		reanimacion.mostrarMedicos();
		dermatologia.mostrarMedicos();
		
		p1.pideCita(cardiologia);
		p1.pideCita(cardiologia);
		p2.pideCita(cardiologia);
		
		p2.anulaCita(reanimacion);
		
		cardiologia.mostrarMedicos();
		
		p1.pideCita(reanimacion);
		p2.pideCita(reanimacion);
		p3.pideCita(reanimacion);
		p4.pideCita(reanimacion);
		
		reanimacion.mostrarMedicos();
		
	}
}