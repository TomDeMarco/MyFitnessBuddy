package com.myfitnessbuddy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    //Login page (index.html)
    @GetMapping("/")
    public String showLoginPage() {
        return "index";
    }

    //Handle login form submission (user enters userId)
    @PostMapping("/users/index")
    public String handleLogin(
            @RequestParam("userId") Long userId,
            HttpSession session
    ) {
        //Optionally: validate userId against DB here
        session.setAttribute("userId", userId);
        return "redirect:/home";
    }

    //After login success → show dashboard/home
    @GetMapping("/home")
    public String showHomePage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        model.addAttribute("userId", userId);
        return "home";
    }

    @GetMapping("/log-food")
    public String showLogFoodPage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        model.addAttribute("userId", userId);
        return "log-food";
    }

    @GetMapping("/log-exercise")
    public String showLogExercisePage(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/";
        }

        model.addAttribute("userId", userId);
        return "log-exercise";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
