package com.library.controller;

import com.library.entity.Author;
import com.library.model.view.AuthorView;
import com.library.service.AuthorService;
import com.library.service.BookService;
import com.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorService authorService;

    private final ClientService clientService;

    private final BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, ClientService clientService, BookService bookService) {
        this.authorService = authorService;
        this.clientService = clientService;
        this.bookService = bookService;
    }

    @GetMapping("/authors")
    public String showAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authorFilter";
    }

    @RequestMapping("/author/{id}")
    public String showAuthorView(Model model, @PathVariable Integer id) {
        Author author = authorService.find(id);
        if (author != null) {
            Double averageClientsAge = clientService.findAverageAgeByAuthor(id);
            AuthorView authorView = new AuthorView(author, averageClientsAge);
            model.addAttribute("authorView", authorView);
            return "authorView";
        } else {
            return "authorFilter";
        }
    }
}