package ar.unrn.tp4.ejercicio3.DataBase;

import ar.unrn.tp4.ejercicio3.Model.ArchivoConcurso;
import ar.unrn.tp4.ejercicio3.Model.Concurso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBArchivoConcurso implements ArchivoConcurso {

    @Override
    public List<Concurso> cargarConcursos() {
        List<Concurso> concursos = new ArrayList<>();
        String query = "SELECT id, nombre, fecha_inicio, fecha_fin FROM concursos";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                LocalDate fechaInicio = rs.getDate("fecha_inicio").toLocalDate();
                LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();

                concursos.add(new Concurso(id, nombre, fechaInicio, fechaFin));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al cargar los concursos desde la base de datos", e);
        }
        return concursos;
    }

}
