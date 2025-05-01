package ar.unrn.tp4.ejercicio1.model;

import ar.unrn.tp4.ejercicio1.database.ParticipanteData;
import ar.unrn.tp4.ejercicio1.database.ParticipanteRepository;

import java.sql.SQLException;

public class DefaultParticipanteService implements ParticipanteService {
    private final ParticipanteRepository repository;

    public DefaultParticipanteService(ParticipanteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void agregarParticipante(String nombre, String telefono, String region) throws SQLException {
        Participante participante = new Participante(nombre, telefono, region);
        ParticipanteData data = new ParticipanteData(participante.getNombre(), participante.getTelefono(), participante.getRegion());
        repository.guardar(data);
    }
}