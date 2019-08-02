package lookUp;

import bean.NegocioBean;

public class NegocioLookUpList extends NegocioBean{
	private String id_comprador;
	private String id_vendedor;
	private String comprador;
	private String vendedor;
	
	public String getId_comprador() {
		return id_comprador;
	}
	public void setId_comprador(String id_comprador) {
		this.id_comprador = id_comprador;
	}
	public String getId_vendedor() {
		return id_vendedor;
	}
	public void setId_vendedor(String id_vendedor) {
		this.id_vendedor = id_vendedor;
	}
	public String getComprador() {
		return comprador;
	}
	public void setComprador(String comprador) {
		this.comprador = comprador;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	@Override
	public String toString() {
		return "NegocioLookUp [data=" + super.getData() + ", comprador=" + comprador + ", vendedor=" + vendedor + ", valor="
				+ super.getValor() + "]";
	}
}