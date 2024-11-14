package org.example.harrypotter.controllers;

import lombok.Getter;
import org.example.entities.Author;
import org.example.thymeleafexample.entities.Book;
import org.example.thymeleafexample.repositories.BookRepository;
import org.example.thymeleafexample.services.BookService;
import org.example.thymeleafexample.services.BookServiceImplemenation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public class HouseController {
    @GetMapping("/book/{isbn}")
    public String showBook(@PathVariable String name, Model model) {
        model.addAttribute("house", houseService.getHouseByName(name));
        return "house";
}
