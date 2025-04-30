package ar.unrn.tp4.ejercicio1.model;

import java.sql.SQLException;

public interface ParticipanteService {

    void agregarParticipante(String nombre, String telefono, String region) throws SQLException;
}
