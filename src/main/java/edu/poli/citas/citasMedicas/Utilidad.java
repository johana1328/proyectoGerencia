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
		// ${T(edu.poli.citas.citasMedicas.Utilidad).isInProcess()}
	}

	public static String processDetail(String date, String hour) {
		try {
			if (isInProcess(date, hour)) {
				Date fechaInicio = getDate(date, hour);
				int dias = (int) ((fechaInicio.getTime() - new Date().getTime()) / 86400000);
				if (dias > 0) {
					if (dias == 1) {
						return "Faltan " + dias + " dia";
					} else {
						return "Falta " + dias + " dias";
					}
				} else {
					int horas = (int) ((fechaInicio.getTime() - new Date().getTime()) / 3600000);
					if (dias == 1) {
						return "Faltan " + horas + " Hora";
					} else {
						return "Falta " + horas + " Horas";
					}
				}

			} else {
				return "Finalizada";
			}
		} catch (Exception e) {
			return "Error";
		}
	}

	public static String formatHour(String hour) {
		SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm a");
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
		try {
			Date date = formato.parse(hour);
			return newFormat.format(date);
		} catch (ParseException e) {
			return "";
		}
	}

	public static String fecha() {
		SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return newFormat.format(new Date());
		} catch (Exception e) {
			return "";
		}
	}

	private static Date getDate(String date, String hour) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		return formato.parse(date.concat("-").concat(hour));
	}
}
