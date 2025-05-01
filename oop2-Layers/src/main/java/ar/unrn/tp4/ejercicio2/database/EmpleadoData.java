package ar.unrn.tp4.ejercicio2.database;

import java.time.LocalDate;

public record EmpleadoData(String apellido, String nombre, LocalDate fechaDeNacimiento, String email) {
}
