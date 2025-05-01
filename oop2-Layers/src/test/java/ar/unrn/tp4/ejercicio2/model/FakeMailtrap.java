package ar.unrn.tp4.ejercicio2.model;

import java.util.ArrayList;
import java.util.List;

public class FakeMailtrap implements ManejoDeNotificaciones {
    public List<String> correosContactados = new ArrayList<>();

    @Override
    public void enviarSaludo(Empleado empleado) {
        correosContactados.add(empleado.getEmail());
    }
}
