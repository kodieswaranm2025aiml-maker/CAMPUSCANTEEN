package com.example.canteen.controller;
import com.example.canteen.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class AuthController {
    private final RegistrationService registration;
    public AuthController(RegistrationService registration){this.registration=registration;}
    @GetMapping("/register") public String registerPage(){return "register";}
    @PostMapping("/register") public String register(@RequestParam String name,@RequestParam String username,@RequestParam String password,Model model){
        try {registration.registerStudent(name,username,password); return "redirect:/login?registered";}
        catch(IllegalArgumentException ex){model.addAttribute("error",ex.getMessage()); return "register";}
    }
}
