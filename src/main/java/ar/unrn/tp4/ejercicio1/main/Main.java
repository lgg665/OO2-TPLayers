package ar.unrn.tp4.ejercicio1.main;

import ar.unrn.tp4.ejercicio1.database.ParticipanteRepository;
import ar.unrn.tp4.ejercicio1.model.DefaultParticipanteService;
import ar.unrn.tp4.ejercicio1.model.ParticipanteService;
import ar.unrn.tp4.ejercicio1.ui.AgregarParticipante;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        inicializar();

        EventQueue.invokeLater(() -> {
            try {
                Connection conn = DriverManager.getConnection(
                        "jdbc:derby:memory:participantes;create=true", "app", "app");
                ParticipanteRepository repo = new ParticipanteRepository(conn);
                ParticipanteService service = new DefaultParticipanteService(repo);
                new AgregarParticipante(service);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
    }

    private static void inicializar() {
        try (var connection = DriverManager.getConnection(
                "jdbc:derby:memory:participantes;create=true",
                "app",
                "app")) {
            var stmt = connection.createStatement();
            createTableParticipantes(stmt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void createTableParticipantes(Statement stmt) throws SQLException {
        stmt.executeUpdate("CREATE TABLE participantes (" +
                "id_participante INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                "nombre VARCHAR(255), " +
                "telefono VARCHAR(15), " +
                "region VARCHAR(50))");
    }
}
