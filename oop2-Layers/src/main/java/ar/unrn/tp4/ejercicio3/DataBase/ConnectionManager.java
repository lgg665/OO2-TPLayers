package ar.unrn.tp4.ejercicio3.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL_DB = "jdbc:mysql://localhost:3306/";
    private static String DB = "002_tplayers"; //cambiar
    private static String USER = "root";
    private static String PASSWORD = "";

    private static Connection conn = null;

    // Crear una nueva conexión
    private static Connection crearConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL_DB + DB, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el driver de la base de datos.", e);
        }
    }


    // Obtener la conexión existente o reconectar si está cerrada
    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = crearConnection(); // reconectar si está cerrada
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
