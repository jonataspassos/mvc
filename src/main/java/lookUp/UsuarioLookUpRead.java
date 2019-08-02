package lookUp;

import java.util.ArrayList;

import bean.TelefoneBean;
import bean.UsuarioBean;

public class UsuarioLookUpRead extends UsuarioBean {
	private ArrayList<TelefoneBean> telefones;

	public ArrayList<TelefoneBean> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<TelefoneBean> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "UsuarioLookUpRead [id=" + super.getId() + ", login=" + super.getLogin() + ", password="
				+ super.getPassword() + ", telefones=" + telefones + "]";
	}

}
