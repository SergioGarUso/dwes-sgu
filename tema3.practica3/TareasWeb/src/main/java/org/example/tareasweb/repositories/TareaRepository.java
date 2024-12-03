package org.example.tareasweb.repositories;

import org.example.tareasweb.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByFechaPlanificadaCierreBeforeAndEstadoNot(String fechaActual, String estado); // Para tareas retrasadas
    List<Tarea> findByEstadoOrderByFechaAperturaAsc(String estado); // Para tareas abiertas ordenadas por fecha
}
