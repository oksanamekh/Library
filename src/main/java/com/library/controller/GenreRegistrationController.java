package com.library.controller;

import com.library.entity.Genre;
import com.library.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class GenreRegistrationController {

    private final GenreService genreService;

    public GenreRegistrationController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genreRegistration")
    public String getRegistrationPage(Model model) {
        return "genreRegistration";
    }

    @PostMapping
    public String save(@RequestParam String genreName) {
        Genre genre = new Genre();
        genre.setGenreName(genreName);
        genreService.save(genre);
        return "redirect:/genreRegistration";
    }
}
