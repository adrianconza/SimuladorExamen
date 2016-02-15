package ec.com.simuladorexamen.utilidades;

public class UtilSeguridad {

	public static String generadorContrasena(int longitud) {

		String NUMEROS = "0123456789";
		String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
		String ESPECIALES = "$#&_-@+-";
		String key = NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES;

		String pswd = "";

		for (int i = 0; i < longitud; i++)
			pswd += (key.charAt((int) (Math.random() * key.length())));

		return pswd;
	}
}