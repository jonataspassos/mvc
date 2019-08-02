package bean;

public class TelefoneBean{
	private String id;
	private String us_id;
	private String ddd;
	private String numero;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUs_id() {
		return us_id;
	}
	public void setUs_id(String us_id) {
		this.us_id = us_id;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "TelefoneBean [us_id=" + us_id + ", numero=(" + ddd + ") " + numero + "]";
	}
}
