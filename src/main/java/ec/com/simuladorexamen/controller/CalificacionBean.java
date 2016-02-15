package ec.com.simuladorexamen.controller;

import static ec.com.simuladorexamen.utilidades.UtilsAplicacion.redireccionar;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.simuladorexamen.entity.Examen;
import ec.com.simuladorexamen.entity.PreguntaExamen;

@Controller
@Scope("session")
public class CalificacionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String calificacion;
	private Examen examen;

	public CalificacionBean() {
		if (examen == null)
			redireccionar("escojerCarrera.jsf");
	}

	public String getCalificacion() {
		if (examen == null)
			redireccionar("escojerCarrera.jsf");
		return calificacion;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public void verCalificacion() {
		if (examen == null)
			redireccionar("escojerCarrera.jsf");
		int cal = 0;
		for (PreguntaExamen pe : examen.getPreguntasExamenes())
			if (pe.getCorrectaIncorrecta() != null && pe.getCorrectaIncorrecta() == true)
				cal++;
		examen.setCalificacion(cal);
		calificacion = String.valueOf(examen.getCalificacion()) + "/" + examen.getPreguntasExamenes().size()
				+ " puntos";
	}

}
