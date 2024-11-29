package org.example.tareasweb.services;

import org.example.tareasweb.entities.Tarea;
import org.example.tareasweb.repositories.TareaRepository;
import org.springframework.stereotype.Service;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
}
