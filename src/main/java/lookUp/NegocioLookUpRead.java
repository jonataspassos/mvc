package lookUp;

import bean.NegocioBean;

public class NegocioLookUpRead extends NegocioBean{
	private UsuarioLookUpTemp comprador;
	private UsuarioLookUpTemp vendedor;
	public UsuarioLookUpTemp getComprador() {
		return comprador;
	}
	public void setComprador(UsuarioLookUpTemp comprador) {
		this.comprador = comprador;
	}
	public UsuarioLookUpTemp getVendedor() {
		return vendedor;
	}
	public void setVendedor(UsuarioLookUpTemp vendedor) {
		this.vendedor = vendedor;
	}
	@Override
	public String toString() {
		return "NegocioLookUpRead [getComprador()=" + getComprador() + ", getVendedor()=" + getVendedor()
				+ ", getData()=" + getData() + ", getValor()=" + getValor() + "]";
	}
	
	
}
