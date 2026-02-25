package empresaReparto;

public class Localizacion {
	private int x;
	private int y;

	public Localizacion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distancia(Localizacion destino) {

		double distancia = Math.hypot(x, y);//sacar la hipotenusa de dos puntos
		return distancia;
		//int xMin=Math.min(destino.getX(), this.x);
		//int yMin=Math.max(destino.y, this.y);
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
