package implement;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import edu.tudai.dao.PersonaDao;
import edu.tudai.db.Persona;

public class PersonaDaoImpl implements PersonaDao{
	
	static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/exampleDB";
	static final String DB_USER = "root";
	static final String DB_PASS = "password";
	
	private void registerDriver() {
		try {
			Class.forName(JDBC_DRIVER).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			
			e.printStackTrace(); 
			//System.exit(1);
		}
	}
	
	private static void createTables(Connection conn) throws SQLException {
		String table = "CREATE TABLE persona(" +
		"id INT," + 
		"nombre VARCHAR(500)," +
		"edad INT," +
		"PRIMARY KEY(id))";
		conn.prepareStatement(table).execute();
		conn.commit();
	}
	
	@Override
	public void insert(Persona persona) {
		Connection conn = null;
		try {
			registerDriver();
			//abrir la conexion
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			if (!)
			String insertar = "INSERT INTO persona (id,nombre,edad) VALUES (?,?,?)";
			try (PreparedStatement  stmt = conn.prepareStatement(insertar)){
				//enviar comando insert
				stmt.setInt(1, persona.getId());
				stmt.setNString(2, persona.getNombre());
				stmt.setInt(3, persona.getEdad());
				stmt.executeLargeUpdate();
				stmt.close();
				conn.commit();
				}
			}
			catch(SQLException e) {
				throw new RuntimeException(e);
			}finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
			}
	}
	
	@Override
	public Persona read(int id) {
	        Connection conn = null;
	        Persona persona = null;

	        try {
	            registerDriver();
	            // abrir la conexion
	            conn = DriverManager.getConnection(DB_URL);
	            // consulta select (selecciona el producto con ID especificado)
	            try (PreparedStatement ps = conn.prepareStatement(
	                    "select * from persona where id = ?")) {
	                // indicar el ID que buscamos
	                ps.setInt(1, id);
	                // ejecutar la consulta
	                try (ResultSet rs = ps.executeQuery()) {
	                    if (rs.next()) {
	                        // obtener cada una de la columnas y mapearlas a la clase Product
	                        persona = new Persona(id,
	                                rs.getString("nombre"),
	                                rs.getInt("edad"));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        } finally {
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return persona;
	}
	
	
	
}
