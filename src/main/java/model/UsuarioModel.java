package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import resources.DataBase;
import bean.UsuarioBean;
import lookUp.UsuarioLookUpList;
import lookUp.UsuarioLookUpRead;

public class UsuarioModel {

	public void create(UsuarioBean usuario) {
		DataBase db = new DataBase();
		Connection conn = null;

		conn = db.getConnection();

		try {
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE USUARIO_CREATE(?,?)");

				st.setString(1, usuario.getLogin());
				st.setString(2, usuario.getPassword());

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UsuarioLookUpRead read(String user) {
		UsuarioLookUpRead usuario;
		DataBase db = new DataBase();
		Connection conn = null;
		
		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
				
				st.setString(1, user);

				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					usuario = new UsuarioLookUpRead();
					
					usuario.setId(rs.getString("id"));
					usuario.setLogin(rs.getString("login"));
					usuario.setPassword(rs.getString("password"));
					
					usuario.setTelefones((new TelefoneModel()).list(user));
					
					return usuario;
				}
				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	} 
	
	public UsuarioBean readBean(String user) {
		UsuarioBean usuario;
		DataBase db = new DataBase();
		Connection conn = null;
		
		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
				
				st.setString(1, user);

				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					usuario = new UsuarioBean();
					
					usuario.setId(rs.getString("id"));
					usuario.setLogin(rs.getString("login"));
					usuario.setPassword(rs.getString("password"));
					
					return usuario;
				}
				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	} 
	
	public UsuarioBean readBean(UsuarioBean user) {
		UsuarioBean usuario;
		DataBase db = new DataBase();
		Connection conn = null;
		
		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM USUARIO WHERE LOGIN = ?");
				
				st.setString(1, user.getLogin());

				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					usuario = new UsuarioBean();
					
					usuario.setId(rs.getString("id"));
					usuario.setLogin(rs.getString("login"));
					usuario.setPassword(rs.getString("password"));
					
					if(user.getPassword().equals(usuario.getPassword()))
						return usuario;
				}
				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	} 
	
	
	public ArrayList<UsuarioLookUpList> list() {
		UsuarioLookUpList usuario;
		DataBase db = new DataBase();
		Connection conn = null;

		ArrayList<UsuarioLookUpList> lista = new ArrayList<UsuarioLookUpList>();

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("SELECT * FROM USUARIO_LIST");

				ResultSet rs = st.executeQuery();

				while (rs.next()) {

					usuario = new UsuarioLookUpList();

					usuario.setId(rs.getString("id"));
					usuario.setLogin(rs.getString("login"));
					usuario.setPhone(rs.getString("phone"));
					usuario.setN_compras(rs.getString("n_compras"));

					lista.add(usuario);
				}

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void update(UsuarioBean usuario) {
		DataBase db = new DataBase();
		Connection conn = null;

		try {
			conn = db.getConnection();

			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE USUARIO_UPDATE(?,?,?)");

				st.setInt(1, Integer.parseInt(usuario.getId()));
				st.setString(2, usuario.getLogin());
				st.setString(3, usuario.getPassword());

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(UsuarioBean usuario) {
		DataBase db = new DataBase();
		Connection conn = null;

		try {

			conn = db.getConnection();
			if (conn != null) {

				PreparedStatement st = conn.prepareStatement("EXECUTE PROCEDURE USUARIO_DELETE(?)");

				st.setInt(1, Integer.parseInt(usuario.getId()));

				st.execute();

				st.close();
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String [] args) {
		UsuarioModel usm = new UsuarioModel();
		
		UsuarioBean usuario = new UsuarioBean();
		
		usuario.setLogin("kemuel");
		usuario.setPassword("123");
		usm.create(usuario);
		
		ArrayList<UsuarioLookUpList> usuarios_view = usm.list();
		for(int i=0;i<usuarios_view.size();i++) {
			System.out.println(usuarios_view.get(i));
		}
		
		System.out.println(usm.read("1"));
		
	}
}