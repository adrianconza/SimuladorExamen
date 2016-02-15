package ec.com.simuladorexamen.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Examen implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer calificacion;
	private Timestamp fecha;
	private Integer tiempo;
	private Integer intento;
	private Integer intentoMaximo;
	private List<PreguntaExamen> preguntasExamenes;

	public Examen() {
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public Integer getId() {
		return id;
	}

	public Integer getIntento() {
		return intento;
	}

	public Integer getIntentoMaximo() {
		return intentoMaximo;
	}

	public List<PreguntaExamen> getPreguntasExamenes() {
		return preguntasExamenes;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIntento(Integer intento) {
		this.intento = intento;
	}

	public void setIntentoMaximo(Integer intentoMaximo) {
		this.intentoMaximo = intentoMaximo;
	}

	public void setPreguntasExamenes(List<PreguntaExamen> preguntasExamenes) {
		this.preguntasExamenes = preguntasExamenes;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

}