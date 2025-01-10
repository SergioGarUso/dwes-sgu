package org.example.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.entities.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CookiesController {

    @GetMapping("/")
    public String handleRequest(HttpSession session, Model model) {
        Counter counter = (Counter)
                session.getAttribute("counter");
        if (counter == null) {
            counter = new Counter();
        }
        counter.increment();
        session.setAttribute("counter", counter);
        model.addAttribute("count", counter.getCount());
        return "counter";
    }
}
