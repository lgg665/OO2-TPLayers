package ar.unrn.tp4.ejercicio2.model;

import ar.unrn.tp4.ejercicio2.database.TextoArchivoEmpleados;
import org.junit.Test;

import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefaultEmpleadoServiceTest {
    @Test
    public void PrimerDeMayo() {
        var archivo = new TextoArchivoEmpleados(Path.of("src/main/java/ar/unrn/tp4/ejercicio2/Lista-Empleados"));
        var fakeMailer = new FakeMailtrap();
        var servicio = new DefaultEmpleadoService(fakeMailer, archivo);
        var dia = LocalDate.of(2025, 5, 1);

        servicio.enviarSaludoCumpleaños(dia);

        // Verificar que se envió el saludo a los empleados que cumplen años el 1 de mayo
        //es decir, al unico que cumple el /05/01
        assertEquals(1, fakeMailer.correosContactados.size());
        assertTrue(fakeMailer.correosContactados.get(0).contains("pepito@gmail.com"));
    }

    @Test
    public void DosDeMayoTest() {
        var archivo = new TextoArchivoEmpleados(Path.of("src/main/java/ar/unrn/tp4/ejercicio2/Lista-Empleados"));
        var fakeMailer = new FakeMailtrap();
        var servicio = new DefaultEmpleadoService(fakeMailer, archivo);
        var dia = LocalDate.of(2025, 5, 2);

        servicio.enviarSaludoCumpleaños(dia);

        // Verificar que se envió el saludo a los empleados que cumplen años el 1 de mayo
        //es decir, al unico que cumple el /05/01
        assertEquals(1, fakeMailer.correosContactados.size());
        assertTrue(fakeMailer.correosContactados.get(0).contains("lolo@yahoo.com"));
    }

}
