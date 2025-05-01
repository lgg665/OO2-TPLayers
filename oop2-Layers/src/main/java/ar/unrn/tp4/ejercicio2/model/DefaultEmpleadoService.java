package ar.unrn.tp4.ejercicio2.model;

import java.time.LocalDate;

public class DefaultEmpleadoService implements EmpleadoService {
    private ArchivoEmpleados archivo;
    private ManejoDeNotificaciones mailer;

    //    Constructor
    public DefaultEmpleadoService(ManejoDeNotificaciones mailer, ArchivoEmpleados empleados) {
        this.archivo = empleados;
        this.mailer = mailer;
    }

    // Verifica que el empleado cumpla años en la fecha indicada y envia un mail
    // a la dirección de correo electrónico del empleado dcon una implementación secreta
    @Override
    public void enviarSaludoCumpleaños(LocalDate dia) {
        for (Empleado e : archivo.obtenerEmpleados()) {
            if (e.cumpleEsteDia(dia)) {
                mailer.enviarSaludo(e);
            }
        }
    }
}
