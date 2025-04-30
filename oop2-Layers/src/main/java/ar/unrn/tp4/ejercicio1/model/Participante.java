package ar.unrn.tp4.ejercicio1.model;

public class Participante {
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
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
    }

    private void fueTelefonoCargado(String telefono) {
        if (telefono.isBlank()) throw new IllegalArgumentException("Debe cargar un teléfono");
    }

    private void fueNombreCargado(String nombre) {
        if (nombre.isBlank()) throw new IllegalArgumentException("Debe cargar un nombre");
    }

    private void validarTelefono(String telefono) {
        if (!telefono.matches("\\d{4}-\\d{6}"))
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
    }

    public String nombre() {
        return nombre;
    }

    public String telefono() {
        return telefono;
    }

    public String region() {
        return region;
    }
}