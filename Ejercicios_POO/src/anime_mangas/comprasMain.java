package anime_mangas;

public class comprasMain {

	public static void main(String[] args) {
		manga manga1 = new manga("kevin", "Doraemon", "isekai", 1);
		manga manga2= new manga("Jordan", "Death Note", "yoQueSe", 2);
		manga[] estanteria = new manga[2];
		// CREANDO UN OBJETO DE LA CLASE METODOS
		// PARA PODER UTILIZAR SUS METODOS
		metodos metodos = new metodos();
		//añade a la estanteria un libro
		metodos.compraManga(estanteria, manga1);
		metodos.compraManga(estanteria, manga2);
		metodos.librosComprados(estanteria);//muestra la estanteria
	}
}
