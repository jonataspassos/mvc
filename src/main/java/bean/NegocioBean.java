package bean;

public class NegocioBean{
	private String us_vendedor;
	private String us_comprador;
	private String data;
	private String valor;
	public String getUs_vendedor() {
		return us_vendedor;
	}
	public void setUs_vendedor(String us_vendedor) {
		this.us_vendedor = us_vendedor;
	}
	public String getUs_comprador() {
		return us_comprador;
	}
	public void setUs_comprador(String us_comprador) {
		this.us_comprador = us_comprador;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "NegocioBean [us_vendedor=" + us_vendedor + ", us_comprador=" + us_comprador + ", data=" + data
				+ ", valor=" + valor + "]";
	}
}
