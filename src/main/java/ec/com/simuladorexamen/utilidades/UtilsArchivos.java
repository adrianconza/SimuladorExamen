package ec.com.simuladorexamen.utilidades;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

public class UtilsArchivos {

	private static final Properties p = System.getProperties();

	private static final String sep = p.getProperty("file.separator");

	private static final String rutaRaiz = (p.getProperty("os.name").compareToIgnoreCase("linux") == 0 ? "/opt"
			: p.getProperty("user.home")) + sep + "exetasi" + sep;

	// devuelve un array byte de un archivo
	public static byte[] convertir(File file) {
		byte[] a = new byte[(int) file.length()];
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(a);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	// devuelve un array byte de un archivo
	public static byte[] convertir(String ruta) {
		File file = new File(ruta);
		byte[] a = new byte[(int) file.length()];
		try {
			FileInputStream fis = new FileInputStream(file);
			fis.read(a);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	// devuelve un array byte de un string
	public static byte[] convertirString(String archivo) {
		try {
			return archivo.getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// devuelve la ruta y si no existe la crea
	public static String crearRuta(String ruta) {
		File directorio = new File(ruta);
		if (!directorio.exists())
			directorio.mkdirs();
		return ruta;
	}

	// devuelve true si elimina el archivo
	public static boolean eliminarArchivo(String archivo) {
		File directorio = new File(archivo);
		return directorio.delete();
	}

	public static String getRutaImagen() {
		return crearRuta(getRutaRaiz() + "imagenes" + sep);
	}

	public static String getRutaRaiz() {
		return crearRuta(rutaRaiz);
	}

	public static String getRutaReportes() {
		return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes") + sep;
	}

	// guarda la imagen en una ruta especifica y si el ancho y alto es diferente
	// de cero la redimenciona a la imagen
	public static String guardarImagen(String ruta, BufferedImage imagen, String nombreImagen, int ancho, int alto) {

		try {
			if (ancho != 0 && alto != 0)
				imagen = redimencionarImagen(imagen, ancho, alto);
			File img = new File(ruta + sep + nombreImagen + ".png");
			ImageIO.write(imagen, "png", img);
			return img.getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String leerArchivo(String archivo) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), "UTF-8"));
			String linea;
			while ((linea = br.readLine()) != null)
				sb.append(linea + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static String leerArchivo(InputStream archivo) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(archivo, "UTF-8"));
			String linea;
			System.out.println(br.readLine());
			while ((linea = br.readLine()) != null)
				sb.append(linea + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sb.toString();
	}

	// lee la imagen entrante y la devuelve como BufferedImage
	public static BufferedImage leerImagen(InputStream imagen, String ruta) {
		try {
			if (imagen != null)
				return ImageIO.read(imagen);
			if (ruta != null && ruta.compareTo("") != 0) {
				File directorio = new File(ruta);
				if (directorio.exists())
					return ImageIO.read(directorio);
			}
			return ImageIO.read(new File(getRutaImagen() + sep + "default.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// lee la imagen entrante y la devuelve como BufferedImage
	public static InputStream leerImagen(String ruta) {
		try {
			System.out.println("****** " + ruta);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			BufferedImage bi = leerImagen(null, ruta);
			if (bi != null)
				ImageIO.write(bi, "png", os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String moverArchivo(String archivo, String archivoFinal) {
		File a = new File(archivo);
		a.renameTo(new File(archivoFinal));
		return archivoFinal;
	}

	// redimenciona a la imagen
	private static BufferedImage redimencionarImagen(BufferedImage imagen, int ancho, int alto) {
		Image img = imagen.getScaledInstance(ancho, alto, Image.SCALE_AREA_AVERAGING);
		BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		bufferedImage.getGraphics().drawImage(img, 0, 0, null);
		return bufferedImage;
	}

}
