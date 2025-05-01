package ar.unrn.tp4.ejercicio1.model;

public class Participante {
    public static final String REGIONES_CONOCIDAS = "Las conocidas son: China, US, Europa";
    public static final String DEBE_CARGAR_UN_TELÉFONO = "Debe cargar un teléfono";
    public static final String CARGAR_UN_NOMBRE = "Debe cargar un nombre";
    public static final String FORMATO_TELÉFONO = "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN";
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) {
        fueNombreCargado(nombre);
        fueTelefonoCargado(telefono);
        validarTelefono(telefono);
        verificarRegion(region);

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }


    private void verificarRegion(String region) {
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
            throw new IllegalArgumentException("Región desconocida. " + REGIONES_CONOCIDAS);
    }

    private void fueTelefonoCargado(String telefono) {
        if (telefono.isBlank()) throw new IllegalArgumentException(DEBE_CARGAR_UN_TELÉFONO);
    }

    private void fueNombreCargado(String nombre) {
        if (nombre.isBlank()) throw new IllegalArgumentException(CARGAR_UN_NOMBRE);
    }

    private void validarTelefono(String telefono) {
        if (!telefono.matches("\\d{4}-\\d{6}"))
            throw new IllegalArgumentException(FORMATO_TELÉFONO);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRegion() {
        return region;
    }
}