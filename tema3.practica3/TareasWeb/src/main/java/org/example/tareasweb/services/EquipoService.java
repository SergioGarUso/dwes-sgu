package org.example.tareasweb.services;

import org.example.tareasweb.repositories.EquipoRepository;
import org.springframework.stereotype.Service;
import org.example.tareasweb.entities.Equipo;

@Service
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository= equipoRepository;
    }


}
