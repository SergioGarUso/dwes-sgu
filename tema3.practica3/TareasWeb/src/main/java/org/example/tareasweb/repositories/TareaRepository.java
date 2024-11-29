package org.example.tareasweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.tareasweb.entities.Tarea;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
