package ar.unrn.tp4.ejercicio2.model;

import java.time.LocalDate;
import java.util.List;

public class DefaultEmpleadoService implements EmpleadoService {
    private List<Empleado> empleados;
    private EmailService mailer;

    //    Constructor
    public DefaultEmpleadoService(EmailService mailer, List<Empleado> empleados) {
        this.empleados = empleados;
        this.mailer = mailer;
    }

    // Verifica que el empleado cumpla años en la fecha indicada y envia un mail
    // a la dirección de correo electrónico del empleado dcon una implementación secreta
    @Override
    public void enviarSaludoCumpleaños(LocalDate dia) {
        for (Empleado e : empleados) {
            if (e.cumpleEsteDia(dia)) {
                mailer.enviarSaludo(e);
            }
        }
    }
}
