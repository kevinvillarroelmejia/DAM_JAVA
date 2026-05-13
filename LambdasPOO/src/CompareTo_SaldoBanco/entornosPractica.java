package CompareTo_SaldoBanco;

/**
 * Clase que representa la cuenta bancaria de un cliente.
 * Almacena el nombre del titular y su saldo, y permite
 * comparar cuentas entre si para ordenarlas por saldo
 * de menor a mayor.
 * 
 * @author Kevin Rashid Villarroel Mejia
 * @since 2026-05-09
 */
public class entornosPractica implements Comparable<entornosPractica> {

	private String nombre;
	private float saldo;

	/**
	 * Constructor que crea una cuenta con el nombre del titular y su saldo inicial.
	 * 
	 * @param nombre nombre del titular de la cuenta
	 * @param saldo saldo inicial de la cuenta
	 */
	public entornosPractica(String nombre, float saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}

	/**
	 * Devuelve una representacion en texto de la cuenta
	 * con el nombre del titular y su saldo.
	 * 
	 * @return cadena con los datos de la cuenta formateados
	 * @deprecated Se recomienda usar {@link #mostrarInfo()} en su lugar,
	 *             ya que ofrece un formato mas completo.
	 */
	@Deprecated
	@Override
	public String toString() {
		String linea = "";
		linea = "Nombre--> " + this.nombre + " Saldo--> " + this.saldo;
		return linea;
	}

	/**
	 * Compara esta cuenta con otra cuenta segun el saldo.
	 * Se usa para ordenar las cuentas de menor a mayor saldo.
	 * 
	 * @param otro la otra cuenta con la que se compara
	 * @return 1 si esta cuenta tiene mayor saldo, -1 si tiene menos, 0 si son iguales
	 */
	@Override
	public int compareTo(entornosPractica otro) {
		int devolver = 0;
		if (this.saldo > otro.saldo) {
			devolver = 1;
		} else if (this.saldo < otro.saldo) {
			devolver = -1;
		}
		return devolver;
	}

	/**
	 * Muestra la informacion de la cuenta con un formato mas detallado.
	 * Este metodo sustituye a {@link #toString()}.
	 * 
	 * @return cadena con los datos del titular y el saldo en euros
	 */
	public String mostrarInfo() {
		return "Titular: " + this.nombre + " | Saldo: " + this.saldo + " EUR";
	}

}