
package pokemon;

public class Pokemon {

	private String nombre;
	private int codigo;
	private String[] tipo = new String[2]; // CREANDO ARRAY DE TAMAÑOS
//	private String evolucion;
	private int pv;
	private Pokemon evolucion;
	private int dano;

	// EL CONSTRUCTOR SE TIENE QUE LLAMAR IGUAL QUE LA CLASE
	// constructor de un tipo
	public Pokemon(int code, String name, String tipo) {
		this.nombre = name;
		this.codigo = code;
		this.tipo[0] = tipo;// metiendo en array de string
//		this.evolucion=evo;
		this.pv = (int) (Math.random() * 51) + 50;
		this.dano = (int) ((Math.random() * 51) + 25);
	}

	// constructor de dos tipos
	public Pokemon(int code, String name, String type, String type2) {
		this.nombre = name;
		this.codigo = code;
		this.tipo[0] = type;
		this.tipo[1] = type2;
//		this.evolucion=evo;
		this.pv = (int) (Math.random() * 51) + 50;// asignando puntos al azar
		this.dano = (int) ((Math.random() * 51) + 25);
	}

	public void infoPokemon() {
		System.out.println("~~~~INFORMACION DEL POKEMON~~~~");
		System.out.println("CODIGO " + this.codigo + " - " + this.nombre);
		if (this.tipo[1] == null) {
			System.out.println("Tipo: " + this.tipo[0]);
		} else {
			System.out.println("Tipo: " + this.tipo[0] + ", " + this.tipo[1]);
		}
		if (this.evolucion != null) {// si tiene evolucion
			System.out.println("Evoluciona en: " + this.evolucion.nombre);
		}
		System.out.println("PV: " + this.pv);
		System.out.println("Daño " + this.dano);
	}

	public void setEvolucion(Pokemon p) {// CAMBIANDO EL PUNTERO A OTRA VARIABLE
		this.evolucion = p;
	}

	public Pokemon evoluciona() {
		// PARA DARLE UN PUNTERO AL PROPIO POKEMON QUE LLAMA A ESTA FUNCION
		Pokemon pokemon = this;
		if (this.evolucion == null) {
			System.out.println("Este pokemon no sabe evolucionar");
		} else {
			pokemon = this.evolucion;
		}
		return pokemon;
	}

	// FUNCION PARA HACER DAÑO
	// HASTA QUE ALGUNO DE ELLOS LA VIDA LLEGUE A <= 0
	public boolean combateContra(Pokemon atacado) {
		// SOLUCION JOSE.M
		boolean conbateTerminado = false;
		boolean vencedor=false;
		do {
			if (atacado.pv <= 0 || this.pv <= 0) {
				conbateTerminado = true;
			}
			if (this.pv <= 0) {
				System.out.println("Un programa sin PV no puede combatir");
			} else if (conbateTerminado == false) {
				int danyo = (int) ((Math.random() * 51) + 25);
				atacado.pv -= danyo;
				if (atacado.pv > 0) {
					danyo = (int) ((Math.random() * 51) + 25);
					this.pv -= danyo;
					if (this.pv > 0) {
						conbateTerminado = false;
					} else {
						vencedor=false;
						System.out.println(this.nombre + " ha sido derrotado");
						conbateTerminado = true;
					}
				} else {
					vencedor=true;
					System.out.println(atacado.nombre + " ha sido derrotado");
					conbateTerminado = true;
				}
			}
		} while (conbateTerminado == false);
		//TRUE SI GANA EL ATACANTE, FLASE SI EL ATACADO
		return vencedor;
	}

}
