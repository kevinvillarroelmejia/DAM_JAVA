package protectoraAnimales;

import java.util.Arrays;

public class protectora {
	private animales[] animalesAdoptados=new animales[1];

	//FUNCION QUE ADOPTE UN ANIMAL
	public animales[] adoptarAnimal(animales animal) {
		for(int i=0;i<animalesAdoptados.length;i++) {
			animalesAdoptados=Arrays.copyOf(animalesAdoptados, animalesAdoptados.length+1);
			if(animalesAdoptados[i]==null) {
				animalesAdoptados[i]=animal;
			}
		}
		return animalesAdoptados;
	}	
	//FUNCION QUE MUESTRE LOS ANIMALES ADOPTADOS
	public void animalesAdoptados(animales[] adoptados) {
		adoptados=animalesAdoptados;
		for(int i=0;i<adoptados.length;i++) {
			System.out.println(adoptados[i]);
		}
	}	
}