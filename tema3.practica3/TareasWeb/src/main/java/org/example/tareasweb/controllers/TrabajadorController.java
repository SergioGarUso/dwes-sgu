package org.example.tareasweb.controllers;

import org.example.tareasweb.entities.Trabajador;
import org.example.tareasweb.services.EquipoService;
import org.example.tareasweb.services.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public String listarTrabajadores(Model model) {
        List<Trabajador> trabajadores = trabajadorService.listarTrabajadores();
        model.addAttribute("trabajadores", trabajadores);
        return "tr-listar";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("trabajador", new Trabajador());
        model.addAttribute("equipos", equipoService.listarEquipos());
        return "tr-crear";
    }

    @PostMapping("/crear")
    public String guardarTrabajador(@ModelAttribute Trabajador trabajador) {
        trabajadorService.guardarTrabajador(trabajador);
        return "redirect:/trabajadores";
    }

    @GetMapping("/{id}")
    public String verTrabajador(@PathVariable Integer id, Model model) {
        Trabajador trabajador = trabajadorService.obtenerTrabajadorPorId(id);
        model.addAttribute("trabajador", trabajador);
        return "tr-ver";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Trabajador trabajador = trabajadorService.obtenerTrabajadorPorId(id);
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("equipos", equipoService.listarEquipos());
        return "tr-editar";
    }

    @PostMapping("/{id}/editar")
    public String actualizarTrabajador(@PathVariable Integer id, @ModelAttribute Trabajador trabajador) {
        trabajadorService.actualizarTrabajador(id, trabajador);
        return "redirect:/trabajadores";
    }
}
