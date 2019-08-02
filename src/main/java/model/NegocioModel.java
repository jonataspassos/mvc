package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.NegocioBean;
import lookUp.NegocioLookUpList;
import resources.DataBase;

public class NegocioModel {
	public void create(NegocioBean negocio) {
		DataBase db = new DataBase();
		Connection conn = null;

		conn = db.getConnection();

		try {
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE NEGOCIO_CREATE(?,?,?,?)");

				st.setInt(1, Integer.parseInt(negocio.getUs_vendedor()));
				st.setInt(2, Integer.parseInt(negocio.getUs_comprador()));
				st.setString(3, negocio.getData());
				st.setFloat(4, Float.parseFloat(negocio.getValor()));

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NegocioLookUpList> list() {
		NegocioLookUpList negocio;
		DataBase db = new DataBase();
		Connection conn = null;

		ArrayList<NegocioLookUpList> lista = new ArrayList<NegocioLookUpList>();

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM NEGOCIO_LIST");

				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					negocio = new NegocioLookUpList();

					negocio.setData(rs.getString("data"));
					negocio.setId_comprador(rs.getString("id_comprador"));
					negocio.setId_vendedor(rs.getString("id_vendedor"));
					negocio.setComprador(rs.getString("comprador"));
					negocio.setVendedor(rs.getString("vendedor"));
					negocio.setValor(rs.getString("valor"));

					lista.add(negocio);
				}

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void update(NegocioBean negocio) {
		DataBase db = new DataBase();
		Connection conn = null;

		try {
			conn = db.getConnection();

			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE NEGOCIO_UPDATE(?,?,?,?)");

				st.setInt(1, Integer.parseInt(negocio.getUs_vendedor()));
				st.setInt(2, Integer.parseInt(negocio.getUs_comprador()));
				st.setString(3, negocio.getData());
				st.setFloat(4, Float.parseFloat(negocio.getValor()));

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(NegocioBean negocio) {
		DataBase db = new DataBase();
		Connection conn = null;

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE NEGOCIO_DELETE(?,?,?)");

				st.setInt(1, Integer.parseInt(negocio.getUs_vendedor()));
				st.setInt(2, Integer.parseInt(negocio.getUs_comprador()));
				st.setString(3, negocio.getData());

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) {
		NegocioModel nem = new NegocioModel();
		
		NegocioBean negocio = new NegocioBean();
		negocio.setUs_comprador("0");
		negocio.setUs_vendedor("9");
		negocio.setData("2019-05-5");
		negocio.setValor("500");
		
		nem.create(negocio);
		
		ArrayList<NegocioLookUpList> negocios_view = nem.list();
		for(int i = 0;i<negocios_view.size();i++) {
			System.out.println(negocios_view.get(i));
		}
		
	}
}