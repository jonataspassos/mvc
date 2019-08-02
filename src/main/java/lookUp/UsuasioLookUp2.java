package lookUp;

import java.util.ArrayList;

import bean.TelefoneBean;

public class UsuasioLookUp2 {
	private String id;
	private String login;
	private String password;
	private ArrayList<TelefoneBean>telefone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<TelefoneBean> getTelefone() {
		return telefone;
	}
	public void setTelefone(ArrayList<TelefoneBean> telefone) {
		this.telefone = telefone;
	}
	
}
