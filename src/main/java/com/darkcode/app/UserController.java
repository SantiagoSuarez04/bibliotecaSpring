package com.darkcode.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.darkcode.app.model.User;

@Controller
public class UserController {
    @GetMapping("/User")
    public String Usuario(){
        return "Usuario";
    }
    @PostMapping("/GuardarUsuario")
    public String registroLibro(@ModelAttribute User user){
        System.out.println(user.toString());
        return "Libro";
    }
}
