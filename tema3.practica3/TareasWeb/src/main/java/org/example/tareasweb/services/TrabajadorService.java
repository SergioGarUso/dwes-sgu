package org.example.tareasweb.services;

import org.example.tareasweb.entities.Trabajador;
import org.example.tareasweb.repositories.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    public List<Trabajador> listarTrabajadores() {
        return trabajadorRepository.findAll();
    }

    public Trabajador guardarTrabajador(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    public Trabajador obtenerTrabajadorPorId(Integer id) {
        Optional<Trabajador> trabajador = trabajadorRepository.findById(id);
        return trabajador.orElse(null);
    }

    public Trabajador actualizarTrabajador(Integer id, Trabajador trabajadorActualizado) {
        Trabajador trabajadorExistente = obtenerTrabajadorPorId(id);
        if (trabajadorExistente != null) {
            trabajadorExistente.setNombre(trabajadorActualizado.getNombre());
            trabajadorExistente.setEdad(trabajadorActualizado.getEdad());
            trabajadorExistente.setEquipo(trabajadorActualizado.getEquipo());
            trabajadorExistente.setTareas(trabajadorActualizado.getTareas());
            return trabajadorRepository.save(trabajadorExistente);
        }
        return null;
    }

    public void eliminarTrabajador(Integer id) {
        trabajadorRepository.deleteById(id);
    }
}
