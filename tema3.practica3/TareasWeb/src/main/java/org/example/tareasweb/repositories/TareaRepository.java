package org.example.tareasweb.repositories;

import org.example.tareasweb.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByFechaPlanificadaCierreBeforeAndEstadoNot(LocalDate fechaPlanificadaCierre, String estado);
    List<Tarea> findByEstadoOrderByFechaAperturaAsc(String estado); // Para tareas abiertas ordenadas por fecha
}
