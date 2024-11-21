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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class StudentController {

    private HouseService houseService = new HouseServiceImplementation(new HouseRepository());
    private StudentService studentService = new StudentServiceImplementation(new StudentRepository());

    @GetMapping("/student")
    public String showStudents(@RequestParam String name, Model model) {
        Student student = studentService.getStudentByName(name);
        model.addAttribute("student", student);
        return "student";
    }
}
