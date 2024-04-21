package edu.poli.citas.citasMedicas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidad {
	public static boolean isInProcess(String date, String hour) {

		try {
			Date fechaReporte = getDate(date, hour);
			Date fechaActual = new Date();
			if (fechaReporte.after(fechaActual)) {
				return true;
			}
		} catch (ParseException e) {
			System.out.println("Error al procesar fechas " + e.getMessage());
		}
		return false;
		// ${T(com.company.package.SomeClass).staticMethod()}
	}

	public static String processDetail(String date, String hour) {
		try {
			if (isInProcess(date, hour)) {
				Date fechaInicio = getDate(date, hour);
				int dias = (int) ((fechaInicio.getTime() - new Date().getTime()) / 86400000);
				if (dias > 0) {
					if (dias == 1) {
						return dias + " dia";
					} else {
						return dias + " dias";
					}
				} else {
					int horas = (int) ((fechaInicio.getTime() - new Date().getTime()) / 3600000);
					if (dias == 1) {
						return horas + " Hora";
					} else {
						return horas + " Horas";
					}
				}

			} else {
				return "Finalizado";
			}
		} catch (Exception e) {
			return "Error";
		}
	}

	private static Date getDate(String date, String hour) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		return formato.parse(date.concat("-").concat(hour));
	}
}
