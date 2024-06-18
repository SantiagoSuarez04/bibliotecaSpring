package com.darkcode.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.darkcode.app.model.UserLibro;

@Controller
public class LibroController {
    @GetMapping("/")
    public String Libro(){
        return "Libro";
    }

    @PostMapping("/GuardarLibro")
    public String registroLibro(@ModelAttribute UserLibro userLibro){
        System.out.println(userLibro.toString());
        return "Libro";
    }
}
