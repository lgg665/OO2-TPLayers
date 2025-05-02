package ar.unrn.tp4.ejercicio3.DataBase;

import ar.unrn.tp4.ejercicio3.Model.ArchivoConcurso;
import ar.unrn.tp4.ejercicio3.Model.Concurso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextoArchivoConcurso implements ArchivoConcurso {
    public static final String TIME_FORMATTER = "yyyy/MM/dd";
    public static final String FILE_NAME = "src/main/java/ar/unrn/tp4/ejercicio3/concursos.txt";
    private Path archivo;

    public TextoArchivoConcurso() {
        this.archivo = Path.of(FILE_NAME);
    }

    @Override
    public List<Concurso> cargarConcursos() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_FORMATTER);
        try (Stream<String> lines = Files.lines(archivo)) {
            return lines
                    .map(linea -> linea.split(",\\s*"))
                    .map(datos -> new Concurso(
                            Integer.parseInt(datos[0].trim()),     //id
                            datos[1].trim(),                 // nombre
                            LocalDate.parse(datos[2].trim(), formatter), // fecha inicio
                            LocalDate.parse(datos[3].trim(), formatter)))  // fecha fin
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }
}
