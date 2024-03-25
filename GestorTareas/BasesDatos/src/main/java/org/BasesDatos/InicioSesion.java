package org.BasesDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InicioSesion {

    

    /**
     * Intenta iniciar sesión con el nombre de usuario o correo electrónico y contraseña proporcionados.
     *
     * @param Email
     * @param Email Nombre de usuario o correo electrónico del usuario que intenta iniciar sesión.
     * @param password Contraseña proporcionada por el usuario.
     * @return id si el inicio es exitoso, en caso de fallar devuelve -3
     */
	public int iniciarSesion(String Email, String password) {
	    // Sentencia SQL para buscar el usuario por nombre de usuario o correo electrónico y obtener su id
	    String sql;
            System.out.println( "Este es el email" + Email + " y la contraseña a verificar " + password);
            sql = "SELECT id, password_hash FROM usuarios WHERE  email = ?";

	    try (Connection conn = ConexionDB.conectar();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        // Establece los parámetros de la consulta
	        pstmt.setString(1, Email);
	        // Ejecuta la consulta
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
                        System.out.println("usuario encontrado");
	                String storedHash = rs.getString("password_hash");
                        System.out.println(storedHash + " verificacion pendiente de este hash del usuario encontrado");
	                // Verifica si la contraseña coincide
	                boolean passwordMatch = HashPassword.verifyPassword(password, storedHash);
	                if (passwordMatch) {
                            System.out.println(rs.getInt("id"));
	                    // Devuelve el id del usuario si la contraseña es correcta
	                    return rs.getInt("id");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al iniciar sesión: " + e.getMessage());
                
	    }
	    // Devuelve -1 si el usuario no se encuentra o si la contraseña no coincide
	    return -3;
	}
}

