package controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.UsuarioBean;
import lookUp.UsuarioLookUpList;
import model.UsuarioModel;

@ManagedBean
public class UsuarioController {
	private UsuarioModel usm;
	private UsuarioBean usuario;
	private ArrayList<UsuarioLookUpList> usuarios;
	private UsuarioLookUpList selectedUser;
	
	@PostConstruct
	public void init() {
		usm = new UsuarioModel();
		usuario = Autentication.obterUsuarioSessao();
		usuarios = usm.list();
	}

	public UsuarioModel getUsm() {
		return usm;
	}

	public void setUsm(UsuarioModel usm) {
		this.usm = usm;
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public ArrayList<UsuarioLookUpList> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<UsuarioLookUpList> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioLookUpList getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UsuarioLookUpList selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	
}
