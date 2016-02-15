package ec.com.simuladorexamen.utilidades;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import ec.com.simuladorexamen.entity.Parametro;

public class UtilsAplicacion {

	public static void actualizar(Parametro parametro) {
		UtilsAplicacion.parametro = parametro;
	}

	public static void enviarVariableVista(String variable, boolean valor) {
		RequestContext.getCurrentInstance().addCallbackParam(variable, valor);
	}

	public static void execute(List<String> jqs) {
		for (String jq : jqs)
			RequestContext.getCurrentInstance().execute(jq);
	}

	public static void execute(String jq) {
		RequestContext.getCurrentInstance().execute(jq);
	}

	public static void presentaMensaje(Severity severity, String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, "MENSAJE DEL SISTEMA", mensaje));
	}

	public static void presentaMensaje(Severity severity, String mensaje, String variable, boolean valor) {
		presentaMensaje(severity, mensaje);
		enviarVariableVista(variable, valor);
	}

	public static void redireccionar(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update(List<String> updates) {
		RequestContext.getCurrentInstance().update(updates);
	}

	public static void update(String update) {
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(update);
	}

	public static Parametro parametro;
}
