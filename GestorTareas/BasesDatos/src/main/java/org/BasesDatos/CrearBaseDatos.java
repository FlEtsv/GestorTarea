package org.BasesDatos;
import java.sql.*;

public class CrearBaseDatos {

		public void Crear() {

	        // SQL para crear las tablas
	        String sqlUsuarios = """
	            CREATE TABLE IF NOT EXISTS usuarios (
	                id INTEGER PRIMARY KEY AUTOINCREMENT,
	                username TEXT NOT NULL UNIQUE,
	                password_hash TEXT NOT NULL,
	                email TEXT UNIQUE,
	                fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	            );
	            """;

	        String sqlTareas = """
	            CREATE TABLE IF NOT EXISTS tareas (
	                id INTEGER PRIMARY KEY AUTOINCREMENT,
	                usuario_id INTEGER,
	                titulo TEXT NOT NULL,
	                descripcion TEXT,
	                estado TEXT CHECK(estado IN ('pendiente', 'en progreso', 'completada')) DEFAULT 'pendiente',
	                fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	                fecha_limite DATE,
	                FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
	            );
	            """;

	        // Conectar a SQLite y crear las tablas
	        try (Connection conn = ConexionDB.conectar();
	             Statement stmt = conn.createStatement()) {
	            // Crear la tabla de usuarios
	            stmt.execute(sqlUsuarios);

	            // Crear la tabla de tareas
	            stmt.execute(sqlTareas);

	            System.out.println("Tablas creadas con éxito.");
	        } catch (Exception e) {
	            System.out.println("Error al crear las tablas: " + e.getMessage());
	        }
	    }

	}
