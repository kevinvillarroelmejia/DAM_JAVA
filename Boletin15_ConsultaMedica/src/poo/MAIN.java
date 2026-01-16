package poo;

import java.time.LocalDate;

public class MAIN {

	public static void main(String[] args) {

		CentroMedico ramonCajal=new CentroMedico("Ramon y Cajal", "CM-3434");
		CentroMedico quiron=new CentroMedico("Quiron", "CM-5655");

		
		Medico sainz= new Medico(ramonCajal, "Carlos", "Sainz", "Cirujano", "990099");
		
		Paciente kevin=new Paciente(quiron, "Kevin", "Villarroel", "99999999F", 111111111);
		
		Consulta consulta1=new Consulta(LocalDate.now(),kevin, sainz, "Dolor de cabeza", "Paracetamol");
		
		Consulta c1=new Consulta(LocalDate.now(), kevin, sainz, "Dolos de estomago", "Tomar pastilla");
		
//		sainz.cambiaCentro(quiron);//funcion que cambia de centro medico
		
//		ramonCajal.listaMedicos();
//		
//		quiron.listaMedicos();
//		
//		quiron.listaPacientes();
		
		kevin.listasConsultas();
		
	}

}
