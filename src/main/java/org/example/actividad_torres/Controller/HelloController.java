package org.example.actividad_torres.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/home")
    public String home(
            @RequestParam(value = "name", defaultValue = "World") String name,
            @RequestParam(value = "lang", defaultValue = "ES") String lang) {

        if (lang.equalsIgnoreCase("ES")) {
            name = "Hola";
        } else if (lang.equalsIgnoreCase("EN")) {
            name = "Hello";
        } else if (lang.equalsIgnoreCase("PT")) {
            name = "Olá";
        } else {
            name = "Chao";
        }

        return String.format("<h1>%s %s!</h1>", name, "World");
    }
}
