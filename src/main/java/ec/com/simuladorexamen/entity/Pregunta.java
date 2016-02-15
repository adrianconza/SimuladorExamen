package ec.com.simuladorexamen.entity;

import java.io.Serializable;
import java.util.List;

public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String bibliografia;
	private String ejeTematico;
	private String enunciado;
	private String imagenEnunciado;
	private String imagenJustificacion;
	private String justificacion;
	private String sostiApantisi;
	private Integer tiempo;
	private Boolean activo;
	private int unidadDidactica;
	private String unidadesDidacticas;
	private String asignatura;
	private String unidadesCurriculares;
	private String nivelDificultad;
	private Usuario docente;
	private List<PosibleRespuesta> posiblesRespuestas;
	private List<PreguntaExamen> preguntasExamenes;

	public Pregunta() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getEjeTematico() {
		return ejeTematico;
	}

	public void setEjeTematico(String ejeTematico) {
		this.ejeTematico = ejeTematico;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getImagenEnunciado() {
		return imagenEnunciado;
	}

	public void setImagenEnunciado(String imagenEnunciado) {
		this.imagenEnunciado = imagenEnunciado;
	}

	public String getImagenJustificacion() {
		return imagenJustificacion;
	}

	public void setImagenJustificacion(String imagenJustificacion) {
		this.imagenJustificacion = imagenJustificacion;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public String getSostiApantisi() {
		return sostiApantisi;
	}

	public void setSostiApantisi(String sostiApantisi) {
		this.sostiApantisi = sostiApantisi;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public int getUnidadDidactica() {
		return unidadDidactica;
	}

	public void setUnidadDidactica(int unidadDidactica) {
		this.unidadDidactica = unidadDidactica;
	}

	public String getUnidadesDidacticas() {
		return unidadesDidacticas;
	}

	public void setUnidadesDidacticas(String unidadesDidacticas) {
		this.unidadesDidacticas = unidadesDidacticas;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getUnidadesCurriculares() {
		return unidadesCurriculares;
	}

	public void setUnidadesCurriculares(String unidadesCurriculares) {
		this.unidadesCurriculares = unidadesCurriculares;
	}

	public String getNivelDificultad() {
		return nivelDificultad;
	}

	public void setNivelDificultad(String nivelDificultad) {
		this.nivelDificultad = nivelDificultad;
	}

	public Usuario getDocente() {
		return docente;
	}

	public void setDocente(Usuario docente) {
		this.docente = docente;
	}

	public List<PosibleRespuesta> getPosiblesRespuestas() {
		return posiblesRespuestas;
	}

	public void setPosiblesRespuestas(List<PosibleRespuesta> posiblesRespuestas) {
		this.posiblesRespuestas = posiblesRespuestas;
	}

	public List<PreguntaExamen> getPreguntasExamenes() {
		return preguntasExamenes;
	}

	public void setPreguntasExamenes(List<PreguntaExamen> preguntasExamenes) {
		this.preguntasExamenes = preguntasExamenes;
	}

}