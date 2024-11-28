package org.example.tareasweb.services;

import org.example.tareasweb.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

}
