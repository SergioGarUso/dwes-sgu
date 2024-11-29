package org.example.tareasweb.services;

import org.example.tareasweb.repositories.TrabajadorRepository;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorService {
    private TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {

    }
}
