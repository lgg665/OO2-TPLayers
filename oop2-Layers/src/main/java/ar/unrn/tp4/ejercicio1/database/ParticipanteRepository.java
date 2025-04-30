package ar.unrn.tp4.ejercicio1.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteRepository {
    private Connection dbConn;

    public ParticipanteRepository(Connection dbConn) {
        this.dbConn = dbConn;
    }

    public void guardar(ParticipanteData data) throws SQLException {
        try (PreparedStatement st = dbConn.prepareStatement(
                "INSERT INTO participantes(nombre, telefono, region) VALUES (?, ?, ?)")) {
            st.setString(1, data.nombre());
            st.setString(2, data.telefono());
            st.setString(3, data.region());
            st.executeUpdate();
        }
    }
}
