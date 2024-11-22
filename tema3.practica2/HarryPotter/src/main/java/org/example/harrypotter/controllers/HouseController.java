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
import java.util.Random;

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
    public String addHouse(Model model) {
        model.addAttribute("house", new House());
        return "housesCreate";
    }

    @PostMapping("/house/create")
    public String addHouse(House house) {
        houseService.addHouse(house);
        return "redirect:/houses";
    }

    @GetMapping("/house/update/{name}")
    public String updateHouse(@PathVariable String name, Model model) {
        model.addAttribute("house", houseService.getHouseByName(name));
        return "housesUpdate";
    }

    @PostMapping("/house/update/{name}")
    public String updateHouse(@PathVariable String name, House house) {
        houseService.updateHouse(name, house);
        return "redirect:/houses";
    }

    @GetMapping("/house/delete/{name}")
    public String deleteHouse(@PathVariable String name) {
        houseService.deleteHouse(name);
        return "redirect:/houses";
    }

    @GetMapping("/student")
    public String showStudents(@RequestParam String name, Model model) {
        Student student = studentService.getStudentByName(name);
        model.addAttribute("student", student);
        return "student";
    }

    @GetMapping("/house/createstudent/{name}")
    public String addStudent(@PathVariable String name, Model model) {
        House chosenHouse = houseService.getHouseByName(name);
        model.addAttribute("myHouse", chosenHouse);
        model.addAttribute("student", new Student());
        return "studentCreate";
    }

    @PostMapping("/house/createstudent/{name}")
    public String addStudent(@PathVariable String name, Student student) {
        student.setHouse(houseService.getHouseByName(name));
        studentService.addStudent(student);
        return "redirect:/house/{name}";
    }

    @GetMapping("/")
    public String createIndex(Model model) {
        List<House> houses = houseService.getHouses();
        List<Student> students = studentService.getStudents();
        Random random = new Random();

        House houseRandom = houses.get(random.nextInt(houses.size()));
        model.addAttribute("houseRandom", houseRandom);

        Student studentRandom = students.get(random.nextInt(students.size()));
        model.addAttribute("studentRandom", studentRandom);
        return "index";
    }

}
