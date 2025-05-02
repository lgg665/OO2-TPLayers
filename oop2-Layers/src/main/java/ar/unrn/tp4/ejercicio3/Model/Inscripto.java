package ar.unrn.tp4.ejercicio3.Model;

public class Inscripto {
    public static final String DEBE_CARGAR_UN_TELÉFONO = "Debe cargar un teléfono";
    public static final String CARGAR_UN_NOMBRE = "Debe cargar un nombre";
    public static final String FORMATO_TELÉFONO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    public static final String CARGAR_EMAIL = "El email no puede estar vacío";
    public static final String CARGAR_DNI = "El dni no puede estar vacío";
    public static final String CARGAR_ID = "El id de un concurso invalido";
    private static final String FORMATO_MAIL = "El email debe ser válido";
    private static final String CARGAR_UN_APELLIDO = "Debe cargar un apellido";
    private String apellido;
    private String nombre;
    private String telefono;
    private String email;
    private int idDelConcurso;
    private int dni;

    public Inscripto(String apellido, String nombre, String telefono, String email, int idDelConcurso, int dni) {
        fueNombreCargado(nombre);
        fueApellidoCargado(apellido);
        fueTelefonoCargado(telefono);
        validarTelefono(telefono);
        fueEmailCargado(email);
        validarEmail(email);
        fueIdCargado(idDelConcurso);
        fueDniCargado(dni);

        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.idDelConcurso = idDelConcurso;
        this.dni = dni;
    }

    private void fueApellidoCargado(String apellido) {
        if (apellido.isBlank()) throw new IllegalArgumentException(CARGAR_UN_APELLIDO);
    }

    private void fueDniCargado(int dni) {
        if (dni <= 0) throw new IllegalArgumentException(CARGAR_DNI);

    }

    private void fueIdCargado(int idDelConcurso) {
        if (idDelConcurso <= 0) throw new IllegalArgumentException(CARGAR_ID);
    }

    private void validarEmail(String email) {
        if ((!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")))
            throw new IllegalArgumentException(FORMATO_MAIL);
    }

    private void validarTelefono(String telefono) {
        if (!telefono.matches("\\d{4}-\\d{6}"))
            throw new IllegalArgumentException(FORMATO_TELÉFONO);
    }

    private void fueEmailCargado(String email) {
        if (email.isBlank()) throw new IllegalArgumentException(CARGAR_EMAIL);
    }


    private void fueTelefonoCargado(String telefono) {
        if (telefono.isBlank()) throw new IllegalArgumentException(DEBE_CARGAR_UN_TELÉFONO);
    }

    private void fueNombreCargado(String nombre) {
        if (nombre.isBlank()) throw new IllegalArgumentException(CARGAR_UN_NOMBRE);
    }

    public int cualConcursoEstaInscripto() {
        return idDelConcurso;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
