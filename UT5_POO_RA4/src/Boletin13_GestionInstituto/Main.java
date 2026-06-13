package Boletin13_GestionInstituto;

public class Main {

	public static void main(String[] args) {
		 // Módulos
        Modulo prog = new Modulo("Programación", 1, 8, false);
        Modulo bbdd = new Modulo("Bases de Datos", 1, 5, false);
        Modulo ed   = new Modulo("Entornos de Desarrollo", 1, 3, false);

        // Ciclo
        Ciclo dam = new Ciclo("DAM", "Superior");
        // aquí necesitarás un método añadirModulo() en Ciclo para agregar los módulos

        // Profesor sin grupo (para evitar la dependencia circular)
        Profesor profe = new Profesor("Carlos", "García", Profesor.Departamento.Informatica);

        // Grupo
        Grupo grupo1 = new Grupo("DAM1", dam, profe, 0, "DAM1");

        // Alumnos
        Alumno alumno1 = new Alumno("Kevin", "López", 19, dam, grupo1);
        Alumno alumno2 = new Alumno("Ana", "Martínez", 17, dam, grupo1);

        // Añadir alumnos al grupo
        grupo1.ayadirAlumno(alumno1);
        grupo1.ayadirAlumno(alumno2);
		
		dam.ayadirModulo(prog);
		dam.ayadirModulo(bbdd);
        // Mostrar grupo
        System.out.println(grupo1);

	}
}
