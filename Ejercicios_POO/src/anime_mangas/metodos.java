package anime_mangas;

public class metodos {
	public manga compraManga(manga[] estanteria, manga libro1) {// añadir al inventario
		int i=0;
		int nullEncontrado=0;
		boolean bandera=false;
		do {
			for (int x = 0; x < estanteria.length; x++) {
				if(estanteria[i]==null) {
					nullEncontrado++;
				}
			}
			if(nullEncontrado==0) {
				bandera=true;
			}
			if(estanteria[i]==null) {
				estanteria[i]=libro1;
				bandera=true;
			}
			if(i!=estanteria.length-1) {
				i++;				
			}
		}while(bandera==false);
		return libro1;
//		return this.estanteria[0]=m1;
	}

	public void librosComprados(manga[] estanteria) {
		for (int i = 0; i < estanteria.length; i++) {
			if (estanteria[i] != null) {
				System.out.println("Autor "+estanteria[i].getAutor());
				System.out.println("Titulo "+estanteria[i].getTitulo());
				System.out.println("Genero "+estanteria[i].getGenero());
				System.out.println("Numero "+estanteria[i].getUltNumeroColeccion());
			}
		}
	}
}
