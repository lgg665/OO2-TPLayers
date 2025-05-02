package ar.unrn.tp4.ejercicio3.DataBase;

import ar.unrn.tp4.ejercicio3.Model.ArchivoInscripto;
import ar.unrn.tp4.ejercicio3.Model.Inscripto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBArchivoInscripto implements ArchivoInscripto {

    @Override
    public void guardarIncripcion(Inscripto inscripto) {
        // Implementar la lógica para guardar el inscripto en la base de datos
        // utilizando la conexión conn.
        // Aquí puedes usar un PreparedStatement para ejecutar una consulta SQL de inserción.
        String sql = "INSERT INTO inscripto (apellido, nombre, telefono, email, id_concurso) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, inscripto.getApellido());
            pstmt.setString(2, inscripto.getNombre());
            pstmt.setString(3, inscripto.getTelefono());
            pstmt.setString(4, inscripto.getEmail());
            pstmt.setInt(5, inscripto.cualConcursoEstaInscripto());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la inscripción en la base de datos", e);
        }
    }


}
