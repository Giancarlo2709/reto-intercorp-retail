package pe.intercorpretail.service.client.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtil {
	
	private DateUtil() {
		super();
	}
	
	public static Integer calcularEdad(LocalDate fechaNacimiento) {
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, ahora);
		return periodo.getYears();
	}
	
	public static LocalDate calcularFechaDeceso(Integer edad, double esperanzaVida) {
		Double aniosFaltante = esperanzaVida - edad;
		LocalDate fechaActual = LocalDate.now();
		return fechaActual.plusYears(aniosFaltante.longValue());		
	}

}
