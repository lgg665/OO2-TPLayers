package ar.unrn.tp4.ejercicio2.database;

import ar.unrn.tp4.ejercicio2.model.Empleado;

import java.util.List;

public interface EmpleadoRepository {
    List<Empleado> obtenerEmpleados();
}
