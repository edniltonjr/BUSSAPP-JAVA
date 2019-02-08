package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {
	public static void Make(String s) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s));
		RefreshingSessionClass.refreshAll();
	}
}
