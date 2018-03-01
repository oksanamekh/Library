package com.library.controller;

import com.library.entity.Book;
import com.library.entity.Client;
import com.library.model.view.ClientView;
import com.library.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public String clientStatistic(Model model) {
        List<Client> clients = clientService.findAll();
        List<ClientView> clientViews = new ArrayList<>();
        if (!clients.isEmpty()) {
            for (Client client : clients) {
                Integer usingLibraryDaysCount = clientService.getUsingLibraryDaysCount(client.getId());
                List<Book> notReturnedBooks = clientService.findNotReturnedBooks(client.getId());
                clientViews.add(new ClientView(client, usingLibraryDaysCount, notReturnedBooks));
            }
        } else {
            return "index"; // TODO Create adminMenu.jsp
        }
        model.addAttribute("clientViews", new ArrayList<>());
        return "clients";
    }
}
