package acceso_Aletorio;

import java.io.RandomAccessFile;
import java.util.HashMap;

public class fichero_AccesoAletorio {

	static final int TAMAÑO_NOMBRE=20;
	static  final int TAMAÑO_REGISTRO= (TAMAÑO_NOMBRE*2)+4; //CONSTANTE -- NO SE PUEDE MODIFICAR EL VALOR

	public static void main(String[] args) {
		// modificable
		String fichero = "/home/alumno/agenda.dat";
		HashMap<String, Integer> agenda = new HashMap<String, Integer>();
		agenda.put("Alejandro", 33);
		agenda.put("Luis", 24);
		agenda.put("Kevin", 7);
		agenda.put("Elvira", 41);
		try {
			crearAgenda(fichero, agenda);
		
			modificaRegistro(fichero,2,"Ana Maria",33);
			leerRegistro(fichero, 2);
			leerRegistro(fichero, 3);
			nuevoRegistro(fichero,"Jose Antonio",56);
			leerRegistro(fichero, 5);
			leerTodosRegistros(fichero);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	//SI EL FICHERO EXISTE NO SE ELIMINA (pero nos los sobreEscribe)

	// AQUI TAMBIEN SE TIENEN QUE TRATAR CON EXCEPSIONES
	// throws Exception -- cuando salte una excepcion la gestionara el try catch de
	// arriba
	// === APERTURA DE FICHERO ===
	// r cuando solo leemos leer
	// rw cuando queremos leer y escribir

	private static void leerTodosRegistros(String fichero) {
		// TODO Auto-generated method stub
		
	}

	public static void nuevoRegistro(String fichero, String nombre, int edad) throws Exception{
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			raf.seek(raf.length());
			escribirNombre(raf,nombre);
			raf.writeInt(edad);
			System.out.println("Registro añadiendo correctamente");
		}

	}

	public static void modificaRegistro(String fichero, int registro, String nombre, int edad) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
			long posicion =TAMAÑO_REGISTRO*(registro-1);
			if(posicion>=raf.length()) {
				System.out.println("El registro "+registro+" no existe");
				System.out.println("El registro mas alto es el "+raf.length()/TAMAÑO_REGISTRO);
			}else {
				raf.seek(posicion);//colocamos el curso en la posicion que le indicamos (SI NO LA POSICION POR DEFECTO ES 0)
				escribirNombre(raf, nombre);
				raf.write(edad);
				System.out.println("Registro "+registro+" modificado correctamente");
			}
		}
	}

	public static void crearAgenda(String fichero, HashMap<String, Integer> agenda) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) { // rw modo de apertura del fichero
			for (String nombre : agenda.keySet()) { // recogiendo el nombre
				int edad = agenda.get(nombre);
				escribirNombre(raf,nombre);
				raf.writeInt(edad);
			}
			System.out.println("Agenda creada. Tamaño: "+raf.length()+" bytes");//length aqui daria lo que ocupa el fichero
		}

	}

	public static void escribirNombre(RandomAccessFile raf, String nombre) throws Exception{
		char[] chars=new char[TAMAÑO_NOMBRE];
		for(int i=0;i<TAMAÑO_NOMBRE;i++) {
			if(i<nombre.length()) {
				chars[i]=nombre.charAt(i);
			}else {
				chars[i]=' ';
			}
		}
		for(char c:chars) {
			raf.write(c);//si no tuvieramos throws Exception esto daria error
		}
	}
	
	//abrimos el fichero en modo r
	public static void leerRegistro(String fichero,int registro) throws Exception {
		try (RandomAccessFile raf = new RandomAccessFile(fichero, "r")) {
			long posicion =TAMAÑO_REGISTRO*(registro-1);
			if(posicion>=raf.length()) {
				System.out.println("El registro "+registro+" no existe");
				System.out.println("El registro mas alto es el "+raf.length()/TAMAÑO_REGISTRO);
			}else {
				raf.seek(posicion);//colocamos el curso en la posicion que le indicamos
				String nombre=leerNombre(raf);
				int edad=raf.readInt();
				System.out.printf("Registro : %d- Nombre: %s Edad: %d\n",registro,nombre,edad);
			}
		}
	}

	public static String leerNombre(RandomAccessFile raf) throws Exception{
		String nombre="";
		for(int i=0;i<TAMAÑO_NOMBRE;i++) {
			char c=raf.readChar();
			nombre=nombre+c;
		}
		return nombre.trim();
	}
	
	
	

}
