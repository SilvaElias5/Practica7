package Sentencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Conexion.Conexion_cls;
import Modelo.Modelo_Us;

public class Sentencias_cls {
	private Connection con;
	private PreparedStatement stm;
	private boolean estado;
	
	public boolean insetar(Modelo_Us mod) throws SQLException {
		String sql = null;
		estado = false;
		try {
			con=obtenerConexion();
			con.setAutoCommit(false);
			sql ="INSERT INTO suscriptor(id,Nombre_pila,Apellido_paterno,Apellido_materno,Servicio,Fecha_nacimiento,Plan,Estatus)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			stm =con.prepareStatement(sql);
			stm.setString(1, null);
			stm.setString(2, mod.getNombre_pila());
			stm.setString(3, mod.getApellido_paterno());
			stm.setString(4, mod.getApellido_materno());
			stm.setString(5, mod.getServicio());
			stm.setInt(6, mod.getFecha_nacimiento());
			stm.setString(7,mod.getPlan());
			stm.setString(8, mod.getEstatus());
			
			estado= stm.executeUpdate()>0;
			System.out.println("Se pudo insertar");
			con.commit();
			stm.close();
			con.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo insertar"+e);
			e.printStackTrace();
		}
		return estado;
		
	}
	
	public boolean editar(Modelo_Us mod) {
		
		String sql = null;
		estado = false;
		try {
			con=obtenerConexion();
			con.setAutoCommit(false);
			sql ="UPDATE  suscriptor SET Nombre_pila=?,Apellido_paterno=?,Apellido_materno=?,Servicio=?,Fecha_nacimiento=?,Plan=?,Estatus=? WHERE id=?"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			stm =con.prepareStatement(sql);
			
			stm.setString(1, mod.getNombre_pila());
			stm.setString(2, mod.getApellido_paterno());
			stm.setString(3, mod.getApellido_materno());
			stm.setString(4, mod.getServicio());
			stm.setInt(5, mod.getFecha_nacimiento());
			stm.setString(6,mod.getPlan());
			stm.setString(7, mod.getEstatus());
			stm.setInt(8, mod.getId());
			
			estado= stm.executeUpdate()>0;
			System.out.println("Se pudo editar");
			con.commit();
			stm.close();
			con.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo editar"+e);
			e.printStackTrace();
		}
		return estado;
		
	}
	
	public boolean eliminar(int idUs) {
		
		String sql = null;
		estado = false;
		try {
			con=obtenerConexion();
			con.setAutoCommit(false);
			sql ="DELETE FROM suscriptor WHERE id=?";
			stm.setInt(1, idUs);
			estado= stm.executeUpdate()>0;
			System.out.println("Se pudo eliminar");
			con.commit();
			stm.close();
			con.close();
				
		} catch (SQLException e) {
			System.out.println("No se pudo eliminar "+e);
			e.printStackTrace();
		}
		return estado;
		
	}
	
	public List<Modelo_Us> obtener() {
		
		String sql = null;
		estado = false;
		ResultSet resul=null;
		List<Modelo_Us> lista = new ArrayList<>();
		try {
			con = obtenerConexion();
			sql = "SELECT * FROM suscriptor";
			resul = stm.executeQuery(sql);
			while(resul.next()) {
				Modelo_Us mo = new Modelo_Us();
				mo.setId(resul.getInt(1));
				mo.setNombre_pila(resul.getString(2));
				mo.setApellido_paterno(resul.getString(3));
				mo.setApellido_materno(resul.getString(4));
				mo.setServicio(resul.getString(5));
				mo.setFecha_nacimiento(resul.getInt(6));
				mo.setPlan(resul.getString(7));
				mo.setEstatus(resul.getString(8));
				lista.add(mo);	
				
				System.out.println("Se pudo mostrar");
			}
		} catch (Exception e) {
			System.out.println("No se pudo mostrar");
		}
		
		return lista;
		
		
	}
	
	public Modelo_Us obtenerUno(int idUs) {
		String sql = null;
		estado = false;
		ResultSet resul=null;
		Modelo_Us mo = new Modelo_Us();
		
		try {
			con = obtenerConexion();
			sql = "SELECT * FROM suscriptor WHERE id=?";
			stm=con.prepareStatement(sql);
			stm.setInt(1, idUs);
			
			resul = stm.executeQuery(sql);
			
			if(resul.next()) {
				
				mo.setId(resul.getInt(1));
				mo.setNombre_pila(resul.getString(2));
				mo.setApellido_paterno(resul.getString(3));
				mo.setApellido_materno(resul.getString(4));
				mo.setServicio(resul.getString(5));
				mo.setFecha_nacimiento(resul.getInt(6));
				mo.setPlan(resul.getString(7));
				mo.setEstatus(resul.getString(8));			
			}
			System.out.println("Se pudo mostrar");
		} catch (Exception e) {
			System.out.println("No se pudo mostrar");
		}
		return mo;
		
	}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion_cls.regresaConexion();
	}
	
	
	
	

}
