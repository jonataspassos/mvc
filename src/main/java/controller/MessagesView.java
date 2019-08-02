package controller;

import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MessagesView {
     
    public void info(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
    }
     
    public void warn(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", message));
    }
     
    public void error(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", message));
    }
     
    public void fatal(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erro!", message));
    }
}