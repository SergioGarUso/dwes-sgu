package org.example.tareasweb.services;

import org.example.tareasweb.entities.Equipo;
import org.example.tareasweb.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo obtenerEquipoPorId(Integer id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.orElse(null);
    }

    public Equipo actualizarEquipo(Integer id, Equipo equipoActualizado) {
        Equipo equipoExistente = obtenerEquipoPorId(id);
        if (equipoExistente != null) {
            equipoExistente.setNombre(equipoActualizado.getNombre());
            equipoExistente.setTrabajadores(equipoActualizado.getTrabajadores());
            return equipoRepository.save(equipoExistente);
        }
        return null;
    }

    public void eliminarEquipo(Integer id) {
        equipoRepository.deleteById(id);
    }
}
