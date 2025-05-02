package ar.unrn.tp4.ejercicio3.Model;

import java.time.LocalDate;

public class Concurso {
    private int id;
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;

    public Concurso(int id, String nombre, LocalDate fechaInicioInscripcion, LocalDate fechaFinInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicioInscripcion = fechaInicioInscripcion;
        this.fechaFinInscripcion = fechaFinInscripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate CuandoIniciaIncripcion() {
        return fechaInicioInscripcion;
    }

    public LocalDate CuandoTerminaIncripcion() {
        return fechaFinInscripcion;
    }
}
