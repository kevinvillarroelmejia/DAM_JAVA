package FechasYHoras;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class fechasYhoras {

	public static void main(String[] args) {
		// ~~~~ TODO SON INMUTABLES ~~~~
		// fecha actual
		// formato Ingles
		LocalDate hoy = LocalDate.now();
		System.out.println(hoy);
		
		//TODO CONVIRTIENDO DE INT A FECHA(AÑO)
		System.err.println("------CONVIRTIENDO DE INT A FECHA(AÑO)------");
		int año =2026;
		System.out.println("esto es un int --> "+año);
		LocalDate fecha=LocalDate.of(año, 1, 1);
		System.out.println("Esto es fecha -->  "+fecha);
		

		// hora actual
		// hora minuto segundos y billonecimas de segundos
		// 10:33:41.081085294
		LocalTime ahora = LocalTime.now();
		//System.out.println(ahora);

		// año-mes-dia
		LocalDate cumple = LocalDate.of(1968, 12, 8);
		//System.out.println(cumple);
		

		// hora:minutos
		LocalTime citaMedica = LocalTime.of(10, 15);
		//System.out.println(citaMedica);

		//TODO //sumando +1 hora
		ahora=ahora.plusHours(1);
		//sumando 15 minutos
		ahora.plusMinutes(15);
		//sumando 10 segundos
		ahora.plusSeconds(10);
		
		//menos 3 horas
		ahora.minusHours(3);
		//menos 20 minutos
		ahora.minusMinutes(20);
		//menos 50 segundos
		ahora.minusSeconds(50);
		
		//sumando un año
		LocalDate dentroDeUnAnyo=hoy.plusYears(1);
		//sumando 4 dias
		dentroDeUnAnyo.plusDays(4);
		//sumando 3 meses
		dentroDeUnAnyo.plusMonths(3);
		//sumando 6 semanas
		dentroDeUnAnyo.plusWeeks(6);

		//restando 8 dias
		dentroDeUnAnyo.minusDays(8);
		//rentando 10 semanas
		dentroDeUnAnyo.minusWeeks(10);
		//restando 5 meses
		dentroDeUnAnyo.minusMonths(5);
		//restando 3 años
		dentroDeUnAnyo.minusYears(3);
		
		System.err.println("------TODO JUNTO CON MAS MILISEGUNDOS------");
		LocalDateTime fechaYhora=LocalDateTime.now();
		//combinando la fecha y hora
		System.out.println(fechaYhora);
		
		
		//TODO FORMATEANDO FECHAS
		//MMMM --> diciembre
		//EEEE --> viernes
		//dd-MM-yy --> 05-12-25
		//dd/MM/yy --> 05/12/25
		//dd-MM-yyyy --> 05-12-2025
		//dd-MMMM-yyyy --> 05-diciembre-2025
		//EEEE, dd/MM/yy  --> viernes, 05/12/25
		System.err.println("------RESTANDO FECHAS | DIFERENCIAS ENTRE FECHAS------");

		
		
		System.err.println("------FECHA INVERTIDA | DIFERENTE FORMATO------");
		DateTimeFormatter formato1= DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
		String fechaConFormato=fechaYhora.format(formato1);//UTILIZANDO EL FORMATO
		System.out.println(fechaConFormato);
		
		System.err.println("------SOLO AÑO------");
		DateTimeFormatter soloAño= DateTimeFormatter.ofPattern("yyyy");
		String añoString=fechaYhora.format(soloAño);//UTILIZANDO EL FORMATO
		System.out.println(añoString);
		
		
		System.err.println("------HORA:MINUTOS------");
		//TODO FORMATENAOD HORAS
		//HH:MM --> 11:12
		DateTimeFormatter horaMinutos= DateTimeFormatter.ofPattern("HH:mm");
		String formatoString=ahora.format(horaMinutos);
		System.out.println(formatoString);
		
		System.err.println("------VALIDANDO FECHA CON UN TEXTO------");
		//TODO VALIDANDO UNA FECHA
		String fechaTXT="08/10/1980";
		//creando formato
		DateTimeFormatter formato3=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate aceptado=LocalDate.parse(fechaTXT,formato3);//convirtiendo
		System.out.println(aceptado);
		
		
		System.out.println("~~~~~~~~~~COMPARANDO FECHAS~~~~~~~~~~");
		//TODO COMPARACION DE FECHAS
		//SI ES ANTEIOR
		if(cumple.isAfter(aceptado)) {
			System.out.println(aceptado+" es porterior a "+hoy);
		}else {
			System.out.println(hoy+" es porterior a "+aceptado);
		}
		
		//SI ES ANTERIOR
		if(cumple.isBefore(aceptado)) {
			System.out.println(aceptado+" es ANTERIOR a "+hoy);
		}else {
			System.out.println(hoy+" es ANTERIOR a "+aceptado);
		}
		
		//SI SON IGUALES
		LocalDate hoy2=LocalDate.now();
		if(hoy.isEqual(hoy2)) {
			System.out.println("LAS FECHAS SON IGUALES");
		}
	}
}



