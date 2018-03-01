package com.library.controller;

import com.library.entity.Author;
import com.library.model.request.BookRequest;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("newBookComponent")
public class BookRegistrationController {

    private final BookService bookService;
    private final GenreService genreService;
    private final AuthorService authorService;

    public BookRegistrationController(BookService bookService, GenreService genreService, AuthorService authorService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.authorService = authorService;
    }

    //    @GetMapping("/bookRegistration")
//    public String getRegistrationPage(Model model) {
//        return "bookRegistration";
//    }

    @ModelAttribute("newBookComponent")
    public BookRequest getForm() {
        return new BookRequest();
    }

    @RequestMapping("/contact")
    public String showContactPage(Model model) {
        return "contact";
    }

    @PostMapping("/bookRegistration")
    public String save(@ModelAttribute("newBookComponent") BookRequest request, SessionStatus status) {
        bookService.save(request);
        return "redirect:/bookRegistration";
    }

//    @GetMapping("/cancel")
//    public String cancel(SessionStatus status) {
//        status.setComplete();
//        return "redirect:/bookRegistration";
//    }

    @GetMapping("/bookRegistration")
    public String getRegistrationPage1(Model model) {
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("authors", authorService.findAll());
        return "bookRegistration";
    }

}
