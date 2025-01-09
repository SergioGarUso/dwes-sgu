package org.example.completeapp.controllers;

import org.example.completeapp.entities.Book;
import org.example.completeapp.entities.PhysicalBook;
import org.example.completeapp.repositories.BookRepository;
import org.example.completeapp.services.PhysicalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/physicalBooks")
public class PhysicalBookController {
    private final PhysicalBookService physicalBookService;
    private final BookRepository bookRepository;

    public PhysicalBookController(PhysicalBookService physicalBookService, BookRepository bookRepository) {
        this.physicalBookService = physicalBookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public String list(Model model) {
        List<PhysicalBook> physicalBooks = physicalBookService.findAll();
        model.addAttribute("physicalBooks", physicalBooks);
        return "physicalbooks/list";
    }

     @GetMapping("/create")
    public String create(Model model) {
        //TODO: Ejercicio 4
        model.addAttribute("physicalBook", new PhysicalBook());
        model.addAttribute("books", bookRepository.findAll());
        return "physicalbooks/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PhysicalBook physicalBook) {
        physicalBookService.save(physicalBook);
        return "redirect:/physicalbooks";
    }

    //TODO: Ejercicio 4
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        PhysicalBook physicalBook = physicalBookService.findById(id);
        model.addAttribute("physicalBook", physicalBook);
        model.addAttribute("books", bookRepository.findAll());
        return "physicalbooks/form";
    }

    @GetMapping("/filter")
    public String filterBooks(@RequestParam(required = false) String keyword, Model model) {
        List<PhysicalBook> books;
        if (keyword != null) {
            books = physicalBookService.searchByKeyword(keyword);
        } else {
            books = physicalBookService.findAll();
        }
        model.addAttribute("books", books);

        return "physicalbooks/list";
    }


}
