package ar.unrn.tp4.ejercicio2.database;

import ar.unrn.tp4.ejercicio2.model.ArchivoEmpleados;
import ar.unrn.tp4.ejercicio2.model.Empleado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextoArchivoEmpleados implements ArchivoEmpleados {
    private Path archivo;

    //obtiene el archivo
    public TextoArchivoEmpleados(Path archivo) {
        this.archivo = archivo;
    }

    //    Devuelve una lista de empleados
    public List<Empleado> obtenerEmpleados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        try (Stream<String> lines = Files.lines(archivo)) {
            return lines
                    .map(linea -> linea.split(",\\s*"))
                    .map(datos -> new Empleado(
                            datos[1].trim(),                 // nombre
                            datos[0].trim(),                 // apellido
                            LocalDate.parse(datos[2].trim(), formatter), // fecha con formato
                            datos[3].trim()))                // email
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }

}
