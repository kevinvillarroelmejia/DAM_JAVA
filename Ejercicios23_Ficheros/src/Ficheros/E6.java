package Ficheros;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class E6 {

	public static void main(String[] args) {
		Path fichero=Path.of("/home/alumno/agenda.txt");
		ArrayList<String >lineas=null;
		boolean correcto=false;
		try {
			lineas=(ArrayList<String>)Files.readAllLines(fichero);
			for(int i=0;i<lineas.size();i++) {
				if(i%3==0) {
					if(lineas.get(i).matches("[1-9]{3}")) {
						correcto=true;
					}else {
						correcto=false;
					}
				}
				if(i%3!=0) {
					if(lineas.get(i).matches("[A-Za-z]")) {
						correcto=true;
					}else {
						correcto=false;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR "+e.getMessage());
		}
		if(correcto) {
			System.out.println("Formato correcto");
		}else {
			System.err.println("Formato incorrecto");
		}
	
	}

}
