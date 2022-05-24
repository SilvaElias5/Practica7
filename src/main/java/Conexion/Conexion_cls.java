package Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
/**
 * 
 * @author silva
 * se creadatasource para controlar laconexion con sql  
 */
public class Conexion_cls {
	private static BasicDataSource dataSource =null;
	
	private static DataSource getDataSource() {
		if (dataSource==null) {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("1914");
			dataSource.setUrl("jdbc:mysql://localhost:3306/practica1");
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);	
		}
		
		return dataSource;
	}
	/**
	 * 
	 * @retur variable de tipo connection 
	 * @throws SQLException
	 */
	public static Connection  regresaConexion() throws SQLException {
		return getDataSource().getConnection();
	}
}
