package ar.unrn.tp4.ejercicio1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL = "jdbc:derby:memory:participantes;create=true";
    private static final String USER = "app";
    private static final String PASS = "app";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection conn = null;

    // Crear una nueva conexión
    private static Connection crearConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            new SQLException("Error al cargar el driver de la base de datos.", e);
        } catch (SQLException sqlEx) {
            new SQLException("No se pudo establecer conexión con la base de datos." + " " + sqlEx.getMessage());
        }
        return null;
    }

    //Método para conectar a la base de datos
    public static void connect() {
        conn = crearConnection();
        if (conn != null) {
            System.out.println("Conexión establecida exitosamente.");
        }
    }

    // Método para desconectar la base de datos
    public static void disconnect() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión ce1rrada exitosamente.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null; // aseguramos que se anule la conexión cerrada
            }
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

    // Método para reconectar
    public static void reconnect() {
        disconnect();
        connect();
    }

    // Métodos para obtener y establecer el DRIVER (si es necesario)
    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String dRIVER) {
        DRIVER = dRIVER;
    }
}
