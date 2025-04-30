package ar.unrn.tp4.ejercicio1.main;

import ar.unrn.tp4.ejercicio1.database.ConnectionManager;
import ar.unrn.tp4.ejercicio1.database.ParticipanteRepository;
import ar.unrn.tp4.ejercicio1.model.DefaultParticipanteService;
import ar.unrn.tp4.ejercicio1.model.ParticipanteService;
import ar.unrn.tp4.ejercicio1.ui.AgregarParticipante;

import java.awt.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Connection conn = ConnectionManager.getConnection();

                ParticipanteRepository repo = new ParticipanteRepository(conn);
                ParticipanteService service = new DefaultParticipanteService(repo);
                new AgregarParticipante(service);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
