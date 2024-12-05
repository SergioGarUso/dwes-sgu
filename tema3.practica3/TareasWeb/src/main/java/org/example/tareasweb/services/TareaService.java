package org.example.tareasweb.services;

import org.example.tareasweb.entities.Tarea;
import org.example.tareasweb.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea obtenerTareaPorId(Integer id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        return tarea.orElse(null);
    }

    public Tarea actualizarTarea(Integer id, Tarea tareaActualizada) {
        Tarea tareaExistente = obtenerTareaPorId(id);
        if (tareaExistente != null) {
            tareaExistente.setNombre(tareaActualizada.getNombre());
            tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
            tareaExistente.setFechaApertura(tareaActualizada.getFechaApertura());
            tareaExistente.setFechaPlanificadaCierre(tareaActualizada.getFechaPlanificadaCierre());
            tareaExistente.setEstado(tareaActualizada.getEstado());
            tareaExistente.setTipo(tareaActualizada.getTipo());
            tareaExistente.setTrabajadores(tareaActualizada.getTrabajadores());
            return tareaRepository.save(tareaExistente);
        }
        return null;
    }

    public void eliminarTarea(Integer id) {
        tareaRepository.deleteById(id);
    }

    public List<Tarea> obtenerTareasRetrasadas() {
        LocalDate fechaActual = LocalDate.now();
        return tareaRepository.findByFechaPlanificadaCierreBeforeAndEstadoNot(fechaActual, "cerrada");
    }

    public List<Tarea> obtenerTareasEnCursoPorTrabajador(Integer trabajadorId) {
        return tareaRepository.findByEstadoOrderByFechaAperturaAsc("en progreso");
    }

    public List<Tarea> obtenerTareasAbiertasOrdenadas() {
        return tareaRepository.findByEstadoOrderByFechaAperturaAsc("abierta");
    }

    public Map<String, Object> obtenerResumenTiposTarea() {
        List<Tarea> tareas = listarTareas();
        Map<String, Integer> conteoTipos = new HashMap<>();
        int total = tareas.size();

        for (Tarea tarea : tareas) {
            String tipo = tarea.getTipo();
            conteoTipos.put(tipo, conteoTipos.getOrDefault(tipo, 0) + 1);
        }

        Map<String, Object> resumen = new HashMap<>();
        for (Map.Entry<String, Integer> entry : conteoTipos.entrySet()) {
            double porcentaje = (entry.getValue() * 100.0) / total;
            resumen.put(entry.getKey(), porcentaje);
        }

        return resumen;
    }
}
