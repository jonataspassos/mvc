package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import bean.UsuarioBean;
import model.UsuarioModel;

@ManagedBean
@SessionScoped
public class Autentication extends Bean{
	private UsuarioBean usuario;
	
	public Autentication() {
		super();
		this.usuario = new UsuarioBean();
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public void login() {
		if(usuario==null)
			return;
		else {
			UsuarioBean us = (new UsuarioModel()).readBean(usuario);
			if(us != null){
				usuario = us;
				redirectIndex();
			}else {
				System.out.println("Usuario e/ou senha Incorretos!");
				(new MessagesView()).warn("Usuario e/ou senha Incorretos!");
				//addMessage(, "Usuario e/ou senha Incorretos!");
			}
		}
	}
	
	public void logout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(true);
		
		try {
			if (session != null) {
				session.removeAttribute("autentication");
				session.invalidate();
			}
			String realPath = FacesContext.getCurrentInstance()
					.getExternalContext().getApplicationContextPath();
			String loginPaht = realPath + "/";
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(loginPaht);

			this.finalize();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void redirectLogin() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/p/login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void redirectIndex() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean logado() {
		return this.usuario.getId() !=null;
	}
	
	public String init() {
		if(!logado()) {
			redirectLogin();
		}
		return "Logado";
	}
	
	public String path() {
    	return FacesContext.getCurrentInstance()
		.getExternalContext().getApplicationContextPath();
    }
	
	public static UsuarioBean obterUsuarioSessao() {
		// UsuarioGeral ug = new UsuarioGeral();
		// ug.setId(1);
		// return ug;
		UsuarioBean usuario = null;
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec;
		HttpSession session;
		try {
			if (fc != null) {
				ec = fc.getExternalContext();
				if (ec != null) {
					session = (HttpSession) ec.getSession(true);
					if (session != null) {
						Autentication au = ((Autentication) session.getAttribute("autentication"));
						if ( au != null) {
							au.init();
							usuario = au.getUsuario();
						}						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (usuario);

		/*
		 * return ((AutenticacaoMB) ((HttpSession) FacesContext
		 * .getCurrentInstance().getExternalContext().getSession(true))
		 * .getAttribute("autenticacaoMB")).getUsuario();
		 */
	}
	
}
