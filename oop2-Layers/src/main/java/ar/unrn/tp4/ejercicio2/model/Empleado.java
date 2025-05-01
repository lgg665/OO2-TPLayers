package ar.unrn.tp4.ejercicio2.model;

import java.time.LocalDate;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String email;

    public Empleado(String apellido, String nombre, LocalDate fechaDeNacimiento, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.email = email;
    }

    public boolean cumpleEsteDia(LocalDate dia) {
        return this.fechaDeNacimiento.getDayOfMonth() == dia.getDayOfMonth()
                && this.fechaDeNacimiento.getMonth() == dia.getMonth();
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getEmail() {
        return email;
    }
}
