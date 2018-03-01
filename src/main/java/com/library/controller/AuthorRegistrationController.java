package com.library.controller;

import com.library.model.request.AuthorRequest;
import com.library.model.request.BookRequest;
import com.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("newAuthorComponent")
public class AuthorRegistrationController {

    private final AuthorService authorService;

    public AuthorRegistrationController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authorRegistration")
    public String getRegistrationPage(Model model) {
        return "authorRegistration";
    }

    @ModelAttribute("newAuthorComponent")
    public AuthorRequest getForm() {
        return new AuthorRequest();
    }

    @PostMapping("/authorRegistration")
    public String save(@ModelAttribute("newAuthorComponent") AuthorRequest request, SessionStatus status) {
        authorService.save(request);
        return "redirect:/authorRegistration";
    }
}
