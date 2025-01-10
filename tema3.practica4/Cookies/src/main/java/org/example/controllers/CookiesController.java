package org.example.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.entities.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CookiesController {

    @GetMapping("/")
    public String handleFormPage() {
        return "form";
    }

    @PostMapping("/save-name")
    public String saveName(String name, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", name);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        return "redirect:/show-name";
    }

    @GetMapping("/show-name")
    public String showName(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        Cookie[] cookies = request.getCookies();
        String username = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        if (username == null) {
            return "redirect:/";
        }

        Counter counter = (Counter) session.getAttribute("counter");
        if (counter == null) {
            counter = new Counter();
        }
        counter.increment();
        session.setAttribute("counter", counter);

        model.addAttribute("username", username);
        model.addAttribute("count", counter.getCount());

        return "show-name";
    }
}
