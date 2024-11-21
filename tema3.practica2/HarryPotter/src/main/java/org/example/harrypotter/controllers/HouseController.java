package org.example.harrypotter.controllers;

import lombok.Getter;
import org.example.harrypotter.entities.House;
import org.example.harrypotter.entities.Student;
import org.example.harrypotter.repositories.StudentRepository;
import org.example.harrypotter.repositories.HouseRepository;
import org.example.harrypotter.services.HouseService;
import org.example.harrypotter.services.StudentService;
import org.example.harrypotter.services.HouseServiceImplementation;
import org.example.harrypotter.services.StudentServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HouseController {
    private HouseService houseService = new HouseServiceImplementation(new HouseRepository());
    private StudentService studentService = new StudentServiceImplementation(new StudentRepository());

    @GetMapping("/houses")
    public String listHouses(Model model) {
        List<House> houses = houseService.getHouses();
        model.addAttribute("houses", houses);
        return "houses";
    }


    @GetMapping("/house/{house}")
    public String showCasa(@PathVariable String house, Model model) {
        House chosenHouse = houseService.getHouseByName(house);
        model.addAttribute("myHouse", chosenHouse);
        model.addAttribute("students", studentService.getStudentsByHouse(house));
        return "house";
    }

    @GetMapping("/house/create")
    public String crearHouses(Model model) {
        model.addAttribute("house", new House());
        return "housesCreate";
    }

    @PostMapping("/house/create")
    public String addHouse(House house) {
        houseService.addHouse(house);
        return "redirect:/houses";
    }

    @GetMapping("/house/update/{name}")
    public String updateBook(@PathVariable String name, Model model) {
        model.addAttribute("house", houseService.getHouseByName(name));
        return "housesUpdate";
    }

}
