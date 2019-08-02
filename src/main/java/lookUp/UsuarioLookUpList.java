package lookUp;

public class UsuarioLookUpList extends UsuarioLookUpTemp{
	private String n_compras;

	public String getN_compras() {
		return n_compras;
	}

	public void setN_compras(String n_compras) {
		this.n_compras = n_compras;
	}

	@Override
	public String toString() {
		return "UsuarioLookUpList [id="
				+ getId() + ", login=" + getLogin() + ", phone=" + getPhone() + ", n_compras=" + getN_compras() + "]";
	}

	
	
}