package com.library.controller;

import com.library.entity.Book;
import com.library.model.request.BookFamousFilterRequest;
import com.library.model.view.BookView;
import com.library.service.BookService;
import com.library.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
@SessionAttributes("filter")
public class BookController {

    private static final LocalDateTime MONTH_AGO = LocalDateTime.now().minusMonths(1);

    private final BookService bookService;

    private final ClientService clientService;

    @Autowired
    public BookController(BookService bookService, ClientService clientService) {
        this.bookService = bookService;
        this.clientService = clientService;
    }

    @ModelAttribute("filter")
    public BookFamousFilterRequest getRequest() {
        return new BookFamousFilterRequest();
    }

    @RequestMapping("/")
    public String findBestOfFourPerMonth(Model model) {
        model.addAttribute("books", bookService.findBestBooksByPeriod(MONTH_AGO, 4));
        model.addAttribute("bookAmountDuringIndep", bookService.findReleasedDuringIndependence());
        return "index";
    }


    @GetMapping("/books/filter")
    public String showBooksByFilter(Model model, @ModelAttribute("filter") BookFamousFilterRequest request) {
        model.addAttribute("books", bookService.findBooksByFamousFilter(request));

        return "bookFilter";
    }

    @GetMapping("/books")
    public String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "bookFilter";
    }

    @RequestMapping("/book/{id}")
    public String bookView(Model model, @PathVariable Integer id) {
        Book book = bookService.find(id);
        if (book != null) {
            Double averageClientsAge = clientService.findAverageAgeByBook(book.getId());
            Long rentCount = bookService.getRentCount(book.getId());
            BookView bookView = new BookView(book, averageClientsAge, rentCount);
            model.addAttribute("bookView", bookView);
            return "bookView";
        } else {
            return "bookFilter";
        }
    }
}
