package Solucion;

public class Ejercicio4 {

	public static void main(String[] args) {

		Rectangulo perimetro=(base,altura) ->{
			double resultado = (2*base+2*altura);
			return resultado;
		};
		Rectangulo area=(base, altura) -> {
			double resultado=base*altura;
			return resultado;
		};
		System.out.printf("%.2f\n",perimetro.calcular(20, 30));
		System.out.printf("%.2f\n",area.calcular(10, 5));
	}
}
