package org.example.tareasweb.controllers;

import org.example.tareasweb.entities.Tarea;
import org.example.tareasweb.services.TareaService;
import org.example.tareasweb.services.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public String listarTareas(Model model) {
        List<Tarea> tareas = tareaService.listarTareas();
        model.addAttribute("tareas", tareas);
        return "tareas/listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("tarea", new Tarea());
        model.addAttribute("trabajadores", trabajadorService.listarTrabajadores());
        return "tareas/crear";
    }

    @PostMapping("/crear")
    public String guardarTarea(@ModelAttribute Tarea tarea) {
        tareaService.guardarTarea(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/{id}")
    public String verTarea(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        model.addAttribute("tarea", tarea);
        return "tareas/ver";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        model.addAttribute("tarea", tarea);
        model.addAttribute("trabajadores", trabajadorService.listarTrabajadores());
        return "tareas/editar";
    }

    @PostMapping("/{id}/editar")
    public String actualizarTarea(@PathVariable Long id, @ModelAttribute Tarea tarea) {
        tareaService.actualizarTarea(id, tarea);
        return "redirect:/tareas";
    }
}
