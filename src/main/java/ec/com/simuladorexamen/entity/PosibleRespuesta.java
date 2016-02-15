package ec.com.simuladorexamen.entity;

import java.io.Serializable;

public class PosibleRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descripcion;
	private String imagenDescripcion;
	private String literal;
	private Pregunta pregunta;

	public PosibleRespuesta() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Integer getId() {
		return id;
	}

	public String getImagenDescripcion() {
		return imagenDescripcion;
	}

	public String getLiteral() {
		return literal;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImagenDescripcion(String imagenDescripcion) {
		this.imagenDescripcion = imagenDescripcion;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}