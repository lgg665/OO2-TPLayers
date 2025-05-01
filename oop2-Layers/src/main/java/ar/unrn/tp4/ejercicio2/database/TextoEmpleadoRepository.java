package ar.unrn.tp4.ejercicio2.database;

import ar.unrn.tp4.ejercicio2.model.Empleado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextoEmpleadoRepository implements EmpleadoRepository {
    private Path archivo;

    //obtiene el archivo
    public TextoEmpleadoRepository(Path archivo) {
        this.archivo = archivo;
    }

    //    Devuelve una lista de empleados
    public List<Empleado> obtenerEmpleados() {
        try (Stream<String> lines = Files.lines(archivo)) {
            return lines
                    .map(linea -> linea.split(",\\s*"))
                    .map(datos -> new Empleado(datos[1], datos[0],
                            LocalDate.parse(datos[2]), datos[3]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo", e);
        }
    }
}
