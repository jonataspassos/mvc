package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.TelefoneBean;
import resources.DataBase;

public class TelefoneModel{
	public void create(TelefoneBean telefone) {
		DataBase db = new DataBase();
		Connection conn = null;

		conn = db.getConnection();

		try {
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE TELEFONE_CREATE(?,?,?)");

				st.setString(1, telefone.getUs_id());
				st.setString(2, telefone.getDdd());
				st.setString(3, telefone.getNumero());

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TelefoneBean> list() {
		TelefoneBean telefone;
		DataBase db = new DataBase();
		Connection conn = null;

		ArrayList<TelefoneBean> lista = new ArrayList<TelefoneBean>();

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM TELEFONE");

				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					telefone = new TelefoneBean();

					telefone.setId(rs.getString("id"));
					telefone.setUs_id(rs.getString("us_id"));
					telefone.setDdd(rs.getString("ddd"));
					telefone.setNumero(rs.getString("numero"));

					lista.add(telefone);
				}

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public ArrayList<TelefoneBean> list(String user) {
		TelefoneBean telefone;
		DataBase db = new DataBase();
		Connection conn = null;

		ArrayList<TelefoneBean> lista = new ArrayList<TelefoneBean>();

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM TELEFONE WHERE US_ID = ?");
				
				st.setString(1, user);

				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					telefone = new TelefoneBean();

					telefone.setId(rs.getString("id"));
					telefone.setUs_id(rs.getString("us_id"));
					telefone.setDdd(rs.getString("ddd"));
					telefone.setNumero(rs.getString("numero"));

					lista.add(telefone);
				}

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}


	public void update(TelefoneBean telefone) {
		DataBase db = new DataBase();
		Connection conn = null;

		try {
			conn = db.getConnection();

			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE TELEFONE_UPDATE(?,?,?,?)");

				st.setInt(1, Integer.parseInt(telefone.getId()));
				st.setInt(2, Integer.parseInt(telefone.getUs_id()));
				st.setInt(3, Integer.parseInt(telefone.getDdd()));
				st.setInt(4, Integer.parseInt(telefone.getNumero()));

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(TelefoneBean telefone) {
		DataBase db = new DataBase();
		Connection conn = null;

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE TELEFONE_DELETE(?)");

				st.setInt(1, Integer.parseInt(telefone.getId()));

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		TelefoneModel tem = new TelefoneModel();
		
		TelefoneBean telefone = new TelefoneBean();
		
		telefone.setUs_id("9");
		telefone.setDdd("74");
		telefone.setNumero("12312332");
		tem.create(telefone);
		/*telefone.setId("5");
		telefone.setUs_id("3");
		telefone.setDdd("87");
		telefone.setNumero("12312332");
		tem.update(telefone);*/
		
/*		 telefone.setId("5");
		 tem.delete(telefone);
*/		 
		 
		
		ArrayList<TelefoneBean> telefones = tem.list("2");
		for(int i=0;i<telefones.size();i++) {
			System.out.println(telefones.get(i));
		}
	}

}