package ec.com.simuladorexamen.controller;

import static ec.com.simuladorexamen.utilidades.UtilsAplicacion.update;
import static ec.com.simuladorexamen.utilidades.UtilsDate.calendarCompleto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.simuladorexamen.entity.Examen;
import ec.com.simuladorexamen.entity.PosibleRespuesta;
import ec.com.simuladorexamen.entity.Pregunta;
import ec.com.simuladorexamen.entity.PreguntaExamen;
import ec.com.simuladorexamen.utilidades.UtilsAplicacion;
import ec.com.simuladorexamen.utilidades.UtilsDate;

@Controller
@Scope("session")
public class SimuladorExamenBean implements Serializable {
	private static final long serialVersionUID = 1L;

	// @Autowired
	// private CalificacionBean calificacionBean;

	private String crono = "1";
	private String literal;

	private List<PreguntaExamen> listPreguntaExamen;
	private Pregunta pregunta;
	private int numPregunta = 0;
	private int preguntas = 0;
	private Examen examen;
	private PreguntaExamen pe;
	private String tiempo = "";
	private String intento = "";

	private String rutaImagenEnunciado = "";
	private String rutaImagen1 = "";
	private String rutaImagen2 = "";
	private String rutaImagen3 = "";
	private String rutaImagen4 = "";
	private String literal1 = "";
	private String literal2 = "";
	private String literal3 = "";
	private String literal4 = "";
	private boolean muetraImagenEnunciado = false;
	private boolean muetraImagenesPregunta = false;

	public SimuladorExamenBean() {
		System.out.println("******1******");
		Examen e = armarExamen();
		numPregunta = 0;
		comenzarExamen(e, 0);
	}

	@PostConstruct
	public void init() {
		System.out.println("******2******");
		Examen e = armarExamen();
		numPregunta = 0;
		comenzarExamen(e, 0);
	}

	public Examen armarExamen() {
		Examen e = new Examen();
		e.setIntento(1);
		e.setIntentoMaximo(1);
		e.setTiempo(600);
		e.setFecha(UtilsDate.timestamp());
		e.setPreguntasExamenes(new ArrayList<PreguntaExamen>());

		PreguntaExamen pe = new PreguntaExamen();
		pe.setExamen(e);
		Pregunta p = new Pregunta();
		p.setEnunciado("EN LA HISTORIA CLINICAS LOS ANTECEDENTES PERSONALES SON EXCEPTO 1");
		// p.setImagenEnunciado("");
		p.setSostiApantisi("A");
		p.setPosiblesRespuestas(new ArrayList<PosibleRespuesta>());
		PosibleRespuesta prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 1");
		// prh.setImagenDescripcion("");
		prh.setLiteral("A");
		p.getPosiblesRespuestas().add(prh);
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 2");
		// prh.setImagenDescripcion("");
		prh.setLiteral("B");
		p.getPosiblesRespuestas().add(prh);
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 3");
		// prh.setImagenDescripcion("");
		prh.setLiteral("C");
		p.getPosiblesRespuestas().add(prh);
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 4");
		// prh.setImagenDescripcion("");
		prh.setLiteral("D");
		p.getPosiblesRespuestas().add(prh);
		pe.setPregunta(p);
		e.getPreguntasExamenes().add(pe);

		pe = new PreguntaExamen();
		pe.setExamen(e);
		p = new Pregunta();
		p.setEnunciado("EN LA HISTORIA CLINICAS LOS ANTECEDENTES PERSONALES SON EXCEPTO 2");
		// p.setImagenEnunciado("");
		p.setSostiApantisi("A");
		p.setPosiblesRespuestas(new ArrayList<PosibleRespuesta>());
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 1");
		// prh.setImagenDescripcion("");
		prh.setLiteral("A");
		p.getPosiblesRespuestas().add(prh);
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 2");
		// prh.setImagenDescripcion("");
		prh.setLiteral("B");
		p.getPosiblesRespuestas().add(prh);
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 3");
		// prh.setImagenDescripcion("");
		prh.setLiteral("C");
		p.getPosiblesRespuestas().add(prh);
		prh = new PosibleRespuesta();
		prh.setPregunta(p);
		prh.setDescripcion("ENFERMEDADES MENTALES 4");
		// prh.setImagenDescripcion("");
		prh.setLiteral("D");
		p.getPosiblesRespuestas().add(prh);
		pe.setPregunta(p);
		e.getPreguntasExamenes().add(pe);

		return e;
	}

	public void comenzarExamen(Examen examen, int preguntas) {
		this.examen = examen;
		listPreguntaExamen = examen.getPreguntasExamenes();
		if (preguntas == 0)
			this.preguntas = listPreguntaExamen.size();
		else
			this.preguntas = preguntas;
		intento = "Intento " + examen.getIntento() + " de " + examen.getIntentoMaximo();
		presentarPregunta();
		List<String> upd = new ArrayList<String>();
		upd.add("formPregunta");
		upd.add("formRespuesta");
		upd.add("formTimer");
		update(upd);
	}

	public void cargarPR() {
		System.out.println("literal1: " + literal);
	}

	public void guardarRespuesta() {
		int tmp = Integer.parseInt(tiempo);
		if (tmp > 0 && (literal == null || literal.compareToIgnoreCase("") == 0)) {
			UtilsAplicacion.presentaMensaje(FacesMessage.SEVERITY_INFO,
					"Responda la pregunta para seguir, caso contrario salte la pregunta");
		} else if (pe != null) {
			pe = listPreguntaExamen.get(numPregunta);
			if (literal != null && literal.compareToIgnoreCase("") != 0) {
				pe.setRespuesta(literal);
				pe.setCorrectaIncorrecta(pregunta.getSostiApantisi().compareTo(pe.getRespuesta()) == 0 ? true : false);
			}
			literal = null;

			boolean bnTodasContestadas = true;
			for (PreguntaExamen pregExamen : listPreguntaExamen)
				if (pregExamen.getCorrectaIncorrecta() == null) {
					bnTodasContestadas = false;
					break;
				}

			if (tmp <= 0 || bnTodasContestadas == true) {
				listPreguntaExamen = null;
				// enviarVariableVista("vistaCalificacion", false);
				// calificacionBean.setExamenId(examen.getId());
				// calificacionBean.verCalificacion();
				// redireccionar("/exetasi/views/privadas/calificacion.jsf");
			} else {
				presentarPregunta();
			}
		}
	}

	public void saltarPregunta() {
		literal = null;
		numPregunta++;
		System.out.println(numPregunta);
		if (numPregunta > listPreguntaExamen.size() - 1)
			numPregunta = 0;
		presentarPregunta();
	}

	public void presentarPregunta() {
		pe = listPreguntaExamen.get(numPregunta);
		if (pe.getCorrectaIncorrecta() == null) {
			pregunta = pe.getPregunta();

			muetraImagenEnunciado = false;
			if (pregunta.getImagenEnunciado() != null && pregunta.getImagenEnunciado().compareToIgnoreCase("") != 0) {
				muetraImagenEnunciado = true;
				rutaImagenEnunciado = pregunta.getImagenEnunciado();
			}
			muetraImagenesPregunta = false;
			if (pregunta.getPosiblesRespuestas() != null) {
				rutaImagen1 = pregunta.getPosiblesRespuestas().get(0).getImagenDescripcion();
				rutaImagen2 = pregunta.getPosiblesRespuestas().get(1).getImagenDescripcion();
				rutaImagen3 = pregunta.getPosiblesRespuestas().get(2).getImagenDescripcion();
				rutaImagen4 = pregunta.getPosiblesRespuestas().get(3).getImagenDescripcion();
				literal1 = pregunta.getPosiblesRespuestas().get(0).getLiteral();
				literal2 = pregunta.getPosiblesRespuestas().get(1).getLiteral();
				literal3 = pregunta.getPosiblesRespuestas().get(2).getLiteral();
				literal4 = pregunta.getPosiblesRespuestas().get(3).getLiteral();
				if (rutaImagen1 != null && rutaImagen1.compareToIgnoreCase("") != 0) {
					muetraImagenesPregunta = true;
				}
			}
		} else {
			saltarPregunta();
		}
	}

	public void tiempoPregunta() {
		if (examen != null) {
			Calendar cal1 = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal1.setTimeInMillis(examen.getFecha().getTime());
			cal2 = calendarCompleto(new Date());
			long milis1 = cal1.getTimeInMillis();
			long milis2 = cal2.getTimeInMillis();
			long diff = milis2 - milis1;
			long diffSeconds = diff / 1000;
			long diffMinutes = diff / (60 * 1000);
			int segundos = (int) diffSeconds;
			segundos += ((int) diffMinutes * 60);
			tiempo = String.valueOf(examen.getTiempo() - segundos);
		}
	}

	public String getCrono() {
		return crono;
	}

	public String getIntento() {
		return intento;
	}

	public String getLiteral() {
		return literal;
	}

	public int getNumPregunta() {
		return numPregunta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public int getPreguntas() {
		return preguntas;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setCrono(String crono) {
		this.crono = crono;
	}

	public void setIntento(String intento) {
		this.intento = intento;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public void setPreguntas(int preguntas) {
		this.preguntas = preguntas;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public String getLiteral1() {
		return literal1;
	}

	public void setLiteral1(String literal1) {
		this.literal1 = literal1;
	}

	public String getLiteral2() {
		return literal2;
	}

	public void setLiteral2(String literal2) {
		this.literal2 = literal2;
	}

	public String getLiteral3() {
		return literal3;
	}

	public void setLiteral3(String literal3) {
		this.literal3 = literal3;
	}

	public String getLiteral4() {
		return literal4;
	}

	public void setLiteral4(String literal4) {
		this.literal4 = literal4;
	}

	public boolean isMuetraImagenEnunciado() {
		return muetraImagenEnunciado;
	}

	public void setMuetraImagenEnunciado(boolean muetraImagenEnunciado) {
		this.muetraImagenEnunciado = muetraImagenEnunciado;
	}

	public boolean isMuetraImagenesPregunta() {
		return muetraImagenesPregunta;
	}

	public void setMuetraImagenesPregunta(boolean muetraImagenesPregunta) {
		this.muetraImagenesPregunta = muetraImagenesPregunta;
	}

}
