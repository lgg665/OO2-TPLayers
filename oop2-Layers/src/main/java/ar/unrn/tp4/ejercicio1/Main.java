package ar.unrn.tp4.ejercicio1;

import ar.unrn.tp4.ejercicio1.database.ParticipanteRepository;
import ar.unrn.tp4.ejercicio1.model.DefaultParticipanteService;
import ar.unrn.tp4.ejercicio1.ui.AgregarParticipante;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        inicializar();
        Connection conn = DriverManager.getConnection("jdbc:derby:memory:participantes;create=true", "app", "app");
        ParticipanteRepository repo = new ParticipanteRepository(conn);
        DefaultParticipanteService service = new DefaultParticipanteService(repo);

        EventQueue.invokeLater(() -> new AgregarParticipante(service));
    }

    private static void inicializar() {
        try (var connection = DriverManager.getConnection(
                "jdbc:derby:memory:participantes;create=true", "app", "app")) {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE participantes (" +
                    "id_participante INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "nombre VARCHAR(255), telefono VARCHAR(15), region VARCHAR(50))");
        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar la base de datos", e);
        }
    }
}
