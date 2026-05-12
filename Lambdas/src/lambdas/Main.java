package lambdas;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		// la funcion lamda es una funcion anonima por asi decirlo, que no tienen nombre
		//se maneja como si fuera una variable
		
		//una funcion lamda NORMALMENTE devuelve algo
		
		//definimos una lamda a traves de una interfaz
		
		
		
		//TODO ----- AHORA SI ESTO ES LA FUNCION LAMDA
		//recibe dos valores (a,b) y -> devuelve lo que esta despues del a+b
		Operacion suma=(a,b)-> a+b; 
		Operacion mayor=(a,b)->{
			int m=a;
			if(b>a) {
				m=b;
			}
			return m;
		};
		
		//INVOCANDO 
		System.out.println(suma.ejecutar(5, 3));
		System.out.println(mayor.ejecutar(4, 5));
		
		
		//TODO -- UNA FUNCION QUE HAGA LO SIGUIENTE:
		//que reciba un valor con decimales luego un entero que es el iva
		//devuelve un string pvp el precio una vez aplicado el iva €
		Operacion2 precioIVA=(precio,iva)->{
			//calculando iva
			precio=(iva*precio)/100+precio;
			//(double) TODO -- para que me lo redondee a dos decimales
			precio=(double)Math.round(precio*100)/100; 
			return "PVP: "+precio+"€";
		};
		
		System.out.println(precioIVA.calcularIVA(5.565, 21));
		
		
		//runable funcion que no recibe nada y no devuelve nada
		//normalmente para mostrar un mensaje
		Runnable hola =()-> System.out.println("Hola mundo");
		//metodo para ejecutar la funcion lamda
		hola.run();
		
		
		
		//Consumer interfaz que recibe un dato del tipo que sea y no devuelve nada
		//recibe un unico valor
		Consumer<String> saludo=(nombre)->System.out.println("hola "+nombre);
		//para utilizar el metodo saludo...
		saludo.accept("Kevin Rashid");
		Consumer<Integer> jubilacion=(edad)->{
			if(edad>=67) {
				System.out.println("Te puede jubilar");
			}else {
				System.out.println("te faltan "+ String.valueOf(67-edad)+" años para jubilarte");
			}
		};
		
		jubilacion.accept(57);
		
		
		//supplier no recibe nada y devuelve un valor
		//numero aletorio entre el 1 y 6
		
		//para llamarlo .get
		Supplier<Integer> tiradaDeDados=()->{
			int azar=(int)(Math.random()*6)+1;
			return azar;
		};
		System.out.println(tiradaDeDados.get());
		
		
		
		//otras interfaces investigar
		/*
		 * BiFunction
		 * TriFuction
		 * Comparator
		 * 
		 * */
		
		
	}


}








