package com.library.controller;

import com.library.entity.Rent;
import com.library.repository.ClientRepository;
import com.library.repository.CopyOfBookRepository;
import com.library.service.BookService;
import com.library.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LocalisationAndTilesTestController {

    @Autowired
    RentService rentRepository;
    @Autowired
    CopyOfBookRepository copyOfBookRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BookService bookService;

    @RequestMapping("/index")
    public String theListOfAllBooks(Model model) {
        Rent rent = new Rent();
        rent.setCopyOfBook(copyOfBookRepository.find(2));
        rent.setUser(clientRepository.find(2));
        rentRepository.save(rent);

        return "index";
    }

    @RequestMapping("/test")
    public String findBestOfFourPerMonth(Model model, HttpServletRequest httpServletRequest) {
        Integer resultListSize = bookService.findAll().size();
        model.addAttribute(
                "books", bookService.findAll());

        return "bookView";
    }
}