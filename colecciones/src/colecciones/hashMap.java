package colecciones;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class hashMap {
	public static void main(String[] args) {
		/*HASHMAP DICCIONARIO CLAVE VALOR
		 * CLAVE UNICAS
		 * SI DUPLICAMOS OTRA CLAVE REEMPLAZA EL ANTIGIUA
		 * LA CLAVE ES LA CABLE DE BUSQUEDA 
		 * 
		 * El String es la Cable el segundo valor
		 * */
		HashMap<String, Double> sueldos=new HashMap<String, Double>();
		//no te lo mete en un orden
		sueldos.put("Jose Maria", 3567.44);
		sueldos.put("Pepe Tomato", 1755.3);
		sueldos.put("Kevin", 1000000.3);
		sueldos.put("Ale", 8000.2);
		System.out.println(sueldos);
		System.out.println("==============================================================");

		sueldos.put("Jose Maria", 5000.4);//Machaca el anterior
		System.out.println(sueldos);
		System.out.println("==============================================================");

		//TODO Eliminando pareja clave:valor
		sueldos.remove("Kevin");
		System.out.println(sueldos);
		System.out.println("==============================================================");

		//Las claves no se pueden cambiar si queremos cambiarla tenemos que borrar la nueva y meter la nueva
		String nombre="Pepe Tomato";
		//Si la clave existe devolvemos el valor
		if(sueldos.containsKey(nombre)) {
			System.out.printf("El sueldo es de %s es %.2f\n",nombre,sueldos.get(nombre));
		}else {
			System.out.println("La clave no existe");
		}
		
		System.out.println("======================RECORRIENDO CON OTRO FORMATO======================");
		/*Recorriendo un diccionario*/
		for(Map.Entry<String,Double>persona:sueldos.entrySet()) {
			System.out.printf("%s: %.2f\n",persona.getKey(),persona.getValue());//devolviendo la clave y el valor
		}
		
		System.err.println("======================RECORRIENDO CON OTRO BUCLE CON CLAVE VALOR==============================");
		for(String persona:sueldos.keySet()) {//keySet devuelve solo las claves del diccionario
			System.out.printf("%s: %.2f\n",persona,sueldos.get(persona));
		}		
		System.err.println("=========================RECORRIENDO PARA SOLO LOS VALORES===============================");
		for(Double sueldo: sueldos.values()) {
			System.out.printf("%.2f\n",sueldo);
		}
		
		System.err.println("=========================RECORRIENDO CON EL ITERATOR===============================");
		/*Si dentro del bucle vamos a tener modifcionaciones de la lista es mejor utilizar iterator*/
		Iterator<Map.Entry<String ,Double>> iterator=sueldos.entrySet().iterator();
		while(iterator.hasNext()) {//cuando llegemos a la ultima opcion sale del bucle
			Map.Entry<String, Double>persona=iterator.next();//pasa al siguiente clave/valor
			System.out.printf("it- %s: %.2f\n",persona.getKey(),persona.getValue());
		}
		System.err.println("=========================RECORRIENDO CON EL ITERATOR OBTENIENDO EL VALOR===============================");
		/*Recorremos el diccionario recogiendo la clave y a atra vez de el recogiendo el valor*/
		Iterator<String > iterator2=sueldos.keySet().iterator();
		while(iterator2.hasNext()) {//cuando llegemos a la ultima opcion sale del bucle
			String nombre3=iterator2.next();//pasa al siguiente clave/valor
			System.out.printf("it2- %s: %.2f\n",nombre3,sueldos.get(nombre3));
		}
		
//		System.err.println("=========================FUNCION LAMBDA===============================");
//		sueldos.forEach((nombre2,sueldo2)->System.out.printf("%s: %.2f\n",nombre2+": "+sueldo2));

		
	}
}
