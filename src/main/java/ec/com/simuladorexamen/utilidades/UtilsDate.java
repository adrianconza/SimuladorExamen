package ec.com.simuladorexamen.utilidades;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class UtilsDate {

	public static Calendar calendarCompleto(Date fecha) {
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c.setTime(fecha);
		c.set(Calendar.HOUR_OF_DAY, c1.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c1.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, c1.get(Calendar.SECOND));
		return c;
	}

	public static int compareTo(Date fecha, Date fecha1) {
		return fechaFormatoDate(fecha).compareTo(fechaFormatoDate(fecha1));
	}

	public static Date date(Timestamp fecha) {
		return new Date(fecha.getTime());
	}

	public static Date dateCompleto(Date fecha) {
		return new Date(fecha.getTime() + 86399999);
	}

	public static String dateFin(Date fecha) {
		return fechaFormatoString(fecha) + " 23:59:59.999";
	}

	public static String dateInicio(Date fecha) {
		return fechaFormatoString(fecha) + " 00:00:00.000";
	}

	public static Long diasMora(Date fecha, Date fechaMora) {
		return (fechaFormatoDate(fecha).getTime() - fechaFormatoDate(fechaMora).getTime()) / ms;
	}

	public static Date fechaFormatoCorte(String fecha) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd", new Locale("ES")).parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date fechaFormatoDate(Date fecha) {
		return fechaFormatoDate(fechaFormatoString(fecha));
	}

	public static Date fechaFormatoDate(String fecha) {
		try {
			return formatoFecha.parse(fecha);
		} catch (ParseException e) {
			return new Date();
		}
	}

	public static Date fechaFormatoDate(String fecha, String formato) {
		try {
			return new SimpleDateFormat(formato, new Locale("ES")).parse(fecha);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String fechaFormatoString(Date fecha) {
		return formatoFecha.format(fecha);
	}

	public static String fechaFormatoString(Date fecha, String formato) {
		return new SimpleDateFormat(formato, new Locale("ES")).format(fecha);
	}

	public static String fechaFormatoString(String fecha) {
		return fechaFormatoString(fechaFormatoDate(fecha));
	}

	public static String fechaFormatoString(Timestamp fecha, String formato) {
		return new SimpleDateFormat(formato, new Locale("ES")).format(fecha);
	}

	public static Date getPrimerDiaDelMes(Date fecha) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.set(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),
				calendario.getActualMinimum(Calendar.DAY_OF_MONTH));
		return calendario.getTime();
	}

	public static Date getUltimoDiaDelMes(Date fecha) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.set(calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH),
				calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendario.getTime();
	}

	public static Date sumarDias(Date fechaInicio, int dias) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.DATE, dias);
		return calendar.getTime();
	}

	public static Timestamp timestamp() {
		return new Timestamp(new Date().getTime());
	}

	public static Timestamp timestamp(Date fecha) {
		return new Timestamp(fecha.getTime());
	}

	public static Timestamp timestamp(long fecha) {
		return new Timestamp(fecha);
	}

	public static Timestamp timestamp(String fecha) {
		return new Timestamp(fechaFormatoDate(fecha).getTime());
	}

	public static Timestamp timestampCompleto(Date fecha) {
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c.setTime(fecha);
		c.set(Calendar.HOUR_OF_DAY, c1.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c1.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, c1.get(Calendar.SECOND));
		return new Timestamp(c.getTime().getTime());
	}

	private static final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", new Locale("ES"));

	private static final long ms = 24 * 60 * 60 * 1000;

}
