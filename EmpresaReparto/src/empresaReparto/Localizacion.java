package empresaReparto;

public class Localizacion {
	private int x;
	private int y;

	public Localizacion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distancia(Localizacion destino) {

		//int xMin=Math.min(destino.getX(), this.x);
		//int yMin=Math.max(destino.y, this.y);
		
		double distancia = Math.hypot(x, y);//sacar la hipotenusa de dos puntos
		
		return distancia;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

//	public void setX(int x) {
//		this.x = x;
//	}
//
//	public void setY(int y) {
//		this.y = y;
//	}

}
