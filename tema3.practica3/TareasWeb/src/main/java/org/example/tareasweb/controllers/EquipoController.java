package org.example.tareasweb.controllers;

import org.example.tareasweb.entities.Equipo;
import org.example.tareasweb.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Listar equipos
    @GetMapping
    public String listarEquipos(Model model) {
        List<Equipo> equipos = equipoService.listarEquipos();
        model.addAttribute("equipos", equipos);
        return "eq-listar";
    }

    // Crear equipo (formulario)
    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("equipo", new Equipo());
        return "eq-crear";
    }

    // Guardar equipo
    @PostMapping("/crear")
    public String guardarEquipo(@ModelAttribute Equipo equipo) {
        equipoService.guardarEquipo(equipo);
        return "redirect:/equipos";
    }

    // Ver detalles del equipo
    @GetMapping("/{id}")
    public String verEquipo(@PathVariable Integer id, Model model) {
        Equipo equipo = equipoService.obtenerEquipoPorId(id);
        model.addAttribute("equipo", equipo);
        return "eq-ver";
    }

    // Modificar equipo (formulario)
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Equipo equipo = equipoService.obtenerEquipoPorId(id);
        model.addAttribute("equipo", equipo);
        return "eq-editar";
    }

    // Actualizar equipo
    @PostMapping("/{id}/editar")
    public String actualizarEquipo(@PathVariable Integer id, @ModelAttribute Equipo equipo) {
        equipoService.actualizarEquipo(id, equipo);
        return "redirect:/equipos";
    }
}
