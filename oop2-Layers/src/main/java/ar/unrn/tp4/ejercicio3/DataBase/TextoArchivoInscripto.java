package ar.unrn.tp4.ejercicio3.DataBase;

import ar.unrn.tp4.ejercicio3.Model.ArchivoInscripto;
import ar.unrn.tp4.ejercicio3.Model.Inscripto;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class TextoArchivoInscripto implements ArchivoInscripto {
    public static final String FILE_NAME = "src/main/java/ar/unrn/tp4/ejercicio3/inscriptos.txt";
    private Path archivo;

    public TextoArchivoInscripto() {
        this.archivo = Path.of(FILE_NAME);
    }

    public void guardarIncripcion(Inscripto inscripto) {
        try (FileWriter writer = new FileWriter(String.valueOf(archivo), true)) {
            int idParticipante = inscripto.cualConcursoEstaInscripto();

            String inscripcion = inscripto.getApellido() + ", " +
                    inscripto.getNombre() + ", " +
                    inscripto.getTelefono() + ", " +
                    inscripto.getEmail() + ", " +
                    idParticipante;

            writer.write(String.format("%s %n", inscripcion));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
