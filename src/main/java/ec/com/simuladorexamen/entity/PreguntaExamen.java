package ec.com.simuladorexamen.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PreguntaExamen implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Boolean correctaIncorrecta;
	private String respuesta;
	private Integer tiempoRestante;
	private Examen examen;
	private Pregunta pregunta;
	private Timestamp tiempoPregunta;

	public PreguntaExamen() {
	}

	public Boolean getCorrectaIncorrecta() {
		return correctaIncorrecta;
	}

	public Examen getExamen() {
		return examen;
	}

	public Integer getId() {
		return id;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public Timestamp getTiempoPregunta() {
		return tiempoPregunta;
	}

	public Integer getTiempoRestante() {
		return tiempoRestante;
	}

	public void setCorrectaIncorrecta(Boolean correctaIncorrecta) {
		this.correctaIncorrecta = correctaIncorrecta;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public void setTiempoPregunta(Timestamp tiempoPregunta) {
		this.tiempoPregunta = tiempoPregunta;
	}

	public void setTiempoRestante(Integer tiempoRestante) {
		this.tiempoRestante = tiempoRestante;
	}

}